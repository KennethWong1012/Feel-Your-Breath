package ict.mgame.a5303_5308;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.UUID;

@SuppressLint("MissingPermission")
public class BluetoothLeManager {

    private static final String TAG = "BluetoothLeManager";

    // ESP32 程式碼中定義的 UUID
    private static final UUID SERVICE_UUID = UUID.fromString("4fafc201-1fb5-459e-8fcc-c5c9c331914b");
    private static final UUID CHARACTERISTIC_UUID_RX = UUID.fromString("beb5483e-36e1-4688-b7f5-ea07361b26a8");

    private static BluetoothLeManager instance;
    private Context context;
    private BluetoothManager bluetoothManager;
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothLeScanner bluetoothLeScanner;
    private BluetoothGatt bluetoothGatt;
    private BluetoothGattCharacteristic rxCharacteristic;

    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean isScanning = false;
    private static final long SCAN_PERIOD = 10000;

    private ConnectionStateListener connectionStateListener;

    public enum BleConnectionState {
        DISCONNECTED,
        SCANNING,
        CONNECTING,
        CONNECTED
    }

    public static synchronized BluetoothLeManager getInstance() {
        if (instance == null) {
            instance = new BluetoothLeManager();
        }
        return instance;
    }

    private BluetoothLeManager() {}

    public void init(Context context) {
        this.context = context.getApplicationContext();
        this.bluetoothManager = (BluetoothManager) this.context.getSystemService(Context.BLUETOOTH_SERVICE);
        if (this.bluetoothManager != null) {
            this.bluetoothAdapter = this.bluetoothManager.getAdapter();
        }
    }

    public void setConnectionStateListener(ConnectionStateListener listener) {
        this.connectionStateListener = listener;
    }

    public boolean isConnected() {
        return bluetoothGatt != null && rxCharacteristic != null;
    }

    public void connect() {
        if (isScanning || isConnected()) {
            Log.w(TAG, "Already scanning or connected.");
            return;
        }

        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            Log.e(TAG, "Bluetooth is not enabled.");
            if (connectionStateListener != null) {
                connectionStateListener.onStateChanged(BleConnectionState.DISCONNECTED, "Bluetooth not enabled");
            }
            return;
        }

        bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
        ScanFilter scanFilter = new ScanFilter.Builder()
                .setServiceUuid(new ParcelUuid(SERVICE_UUID))
                .build();
        ScanSettings scanSettings = new ScanSettings.Builder()
                .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
                .build();

        handler.postDelayed(() -> {
            if (isScanning) {
                stopScan();
                if (connectionStateListener != null) {
                    connectionStateListener.onStateChanged(BleConnectionState.DISCONNECTED, "Device not found");
                }
            }
        }, SCAN_PERIOD);

        isScanning = true;
        if (connectionStateListener != null) {
            connectionStateListener.onStateChanged(BleConnectionState.SCANNING, null);
        }
        bluetoothLeScanner.startScan(Collections.singletonList(scanFilter), scanSettings, leScanCallback);
        Log.d(TAG, "Started scanning for device with service UUID: " + SERVICE_UUID);
    }

    public void disconnect() {
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
        }
    }

    private void stopScan() {
        if (isScanning && bluetoothLeScanner != null) {
            isScanning = false;
            bluetoothLeScanner.stopScan(leScanCallback);
            Log.d(TAG, "Scan stopped.");
        }
    }

    private final ScanCallback leScanCallback = new ScanCallback() {
        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            super.onScanResult(callbackType, result);
            BluetoothDevice device = result.getDevice();
            // A null check for device name is good practice
            String deviceName = device.getName() == null ? "Unknown" : device.getName();
            Log.d(TAG, "Device found: " + deviceName + " [" + device.getAddress() + "]");
            stopScan();
            if (connectionStateListener != null) {
                connectionStateListener.onStateChanged(BleConnectionState.CONNECTING, null);
            }
            bluetoothGatt = device.connectGatt(context, false, gattCallback);
        }

        @Override
        public void onScanFailed(int errorCode) {
            super.onScanFailed(errorCode);
            Log.e(TAG, "Scan failed with error code: " + errorCode);
            isScanning = false;
            if (connectionStateListener != null) {
                connectionStateListener.onStateChanged(BleConnectionState.DISCONNECTED, "Scan failed");
            }
        }
    };

    private final BluetoothGattCallback gattCallback = new BluetoothGattCallback() {
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                Log.i(TAG, "Connected to GATT server.");
                gatt.discoverServices();
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                Log.i(TAG, "Disconnected from GATT server.");
                if (bluetoothGatt != null) {
                    bluetoothGatt.close();
                }
                bluetoothGatt = null;
                rxCharacteristic = null;
                if (connectionStateListener != null) {
                    handler.post(() -> connectionStateListener.onStateChanged(BleConnectionState.DISCONNECTED, null));
                }
            }
        }

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                BluetoothGattService service = gatt.getService(SERVICE_UUID);
                if (service != null) {
                    rxCharacteristic = service.getCharacteristic(CHARACTERISTIC_UUID_RX);
                    if (rxCharacteristic != null) {
                        Log.i(TAG, "Service and Characteristic found. Ready to send data.");
                        if (connectionStateListener != null) {
                            handler.post(() -> connectionStateListener.onStateChanged(BleConnectionState.CONNECTED, null));
                        }
                    } else {
                        Log.w(TAG, "Characteristic not found!");
                        disconnect();
                    }
                } else {
                    Log.w(TAG, "Service not found!");
                    disconnect();
                }
            } else {
                Log.w(TAG, "onServicesDiscovered received: " + status);
            }
        }
    };

    // --- 公共指令方法 ---

    public void sendColor(int color) {
        String hexColor = String.format("#%06X", (0xFFFFFF & color));
        sendData(hexColor);
    }

    public void turnOffLights() {
        sendData("#000000");
    }

    public void startRandomColorEffect() {
        sendData("#RANDOM");
    }

    private void sendData(String data) {
        if (!isConnected()) {
            Log.w(TAG, "Not connected. Cannot send data.");
            return;
        }

        // Android 13 (TIRAMISU) and above require a new way to write characteristics
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            // ✨✨✨ THIS IS THE CORRECTED LINE ✨✨✨
            bluetoothGatt.writeCharacteristic(rxCharacteristic, data.getBytes(StandardCharsets.UTF_8), BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        } else {
            rxCharacteristic.setValue(data.getBytes(StandardCharsets.UTF_8));
            rxCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
            bluetoothGatt.writeCharacteristic(rxCharacteristic);
        }
        Log.d(TAG, "Writing data: " + data);
    }

    public interface ConnectionStateListener {
        void onStateChanged(BleConnectionState state, String message);
    }
}