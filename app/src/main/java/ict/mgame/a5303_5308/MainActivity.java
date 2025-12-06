package ict.mgame.a5303_5308;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;

import java.util.Random;

// 修改：繼承 BaseActivity
public class MainActivity extends BaseActivity implements BluetoothLeManager.ConnectionStateListener {

    private SharedPreferencesHelper sharedPreferencesHelper;
    private ImageButton btnBluetooth;

    // 用於請求權限
    private final ActivityResultLauncher<String[]> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), result -> {
                Boolean fineLocationGranted = result.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false);
                Boolean bluetoothScanGranted = Build.VERSION.SDK_INT < Build.VERSION_CODES.S || result.getOrDefault(Manifest.permission.BLUETOOTH_SCAN, false);
                Boolean bluetoothConnectGranted = Build.VERSION.SDK_INT < Build.VERSION_CODES.S || result.getOrDefault(Manifest.permission.BLUETOOTH_CONNECT, false);

                if (fineLocationGranted && bluetoothScanGranted && bluetoothConnectGranted) {
                    // 權限已授予，開始連接
                    bluetoothLeManager.connect();
                } else {
                    Toast.makeText(this, R.string.ble_permissions_not_granted, Toast.LENGTH_SHORT).show();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferencesHelper = new SharedPreferencesHelper(this);
        bluetoothLeManager.setConnectionStateListener(this);

        // 初始化按鈕
        btnBluetooth = findViewById(R.id.btnBluetooth);
        Button btnStartingTest = findViewById(R.id.btnStartingTest);
        Button btnRandomColour = findViewById(R.id.btnRandomColour);
        Button btnFavoriteColors = findViewById(R.id.btnFavoriteColors);
        Button btnRecord = findViewById(R.id.btnRecord);
        Button btnLogout = findViewById(R.id.btnLogout);
        // btnPause 的邏輯已在 BaseActivity 中處理

        View colorHappy = findViewById(R.id.colorHappy);
        View colorSad = findViewById(R.id.colorSad);
        View colorAnger = findViewById(R.id.colorAnger);
        View colorFear = findViewById(R.id.colorFear);
        View colorSelfAbasement = findViewById(R.id.colorSelfAbasement);
        View colorAnxiety = findViewById(R.id.colorAnxiety);
        View colorDisgust = findViewById(R.id.colorDisgust);

        // --- 設定點擊事件 ---
        btnBluetooth.setOnClickListener(v -> handleBluetoothClick());

        btnStartingTest.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StoryActivity.class);
            startActivity(intent);
        });

        btnRandomColour.setOnClickListener(v -> {
            Mood[] moods = Mood.values();
            Mood randomMood = moods[new Random().nextInt(moods.length)];
            sharedPreferencesHelper.saveRecord(randomMood);

            // 新增：發送顏色到藍牙設備
            if (bluetoothLeManager.isConnected()) {
                int color = ContextCompat.getColor(this, randomMood.getColorResId());
                bluetoothLeManager.sendColor(color);
            }
            showResult(randomMood);
        });

        btnFavoriteColors.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FavoriteColorsActivity.class);
            startActivity(intent);
        });

        btnRecord.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RecordActivity.class);
            startActivity(intent);
        });

        btnLogout.setOnClickListener(v -> {
            // 登出前斷開藍牙
            bluetoothLeManager.disconnect();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        // --- 顏色方塊點擊事件 ---
        colorHappy.setOnClickListener(v -> handleColorClick(Mood.HAPPY));
        colorSad.setOnClickListener(v -> handleColorClick(Mood.SAD));
        colorAnger.setOnClickListener(v -> handleColorClick(Mood.ANGER));
        colorFear.setOnClickListener(v -> handleColorClick(Mood.FEAR));
        colorSelfAbasement.setOnClickListener(v -> handleColorClick(Mood.SELF_ABASEMENT));
        colorAnxiety.setOnClickListener(v -> handleColorClick(Mood.ANXIETY));
        colorDisgust.setOnClickListener(v -> handleColorClick(Mood.DISGUST));

        // 初始更新藍牙按鈕狀態
        updateBluetoothButton(bluetoothLeManager.isConnected() ? BluetoothLeManager.BleConnectionState.CONNECTED : BluetoothLeManager.BleConnectionState.DISCONNECTED);
    }

    private void handleColorClick(Mood mood) {
        // 新增：發送顏色到藍牙設備
        if (bluetoothLeManager.isConnected()) {
            int color = ContextCompat.getColor(this, mood.getColorResId());
            bluetoothLeManager.sendColor(color);
        }
        // 原有邏輯：跳轉到結果頁面
        showResult(mood);
    }

    private void handleBluetoothClick() {
        if (bluetoothLeManager.isConnected()) {
            bluetoothLeManager.disconnect();
        } else {
            checkPermissionsAndConnect();
        }
    }

    private void checkPermissionsAndConnect() {
        String[] permissions;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            permissions = new String[]{
                    Manifest.permission.BLUETOOTH_SCAN,
                    Manifest.permission.BLUETOOTH_CONNECT,
                    Manifest.permission.ACCESS_FINE_LOCATION
            };
        } else {
            permissions = new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            };
        }

        boolean allPermissionsGranted = true;
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                allPermissionsGranted = false;
                break;
            }
        }

        if (allPermissionsGranted) {
            bluetoothLeManager.connect();
        } else {
            requestPermissionLauncher.launch(permissions);
        }
    }

    private void showResult(Mood mood) {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("RESULT_MOOD", mood.name());
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 清理監聽器，防止內存洩漏
        bluetoothLeManager.setConnectionStateListener(null);
    }

    // --- 藍牙狀態回調 ---
    @Override
    public void onStateChanged(BluetoothLeManager.BleConnectionState state, String message) {
        updateBluetoothButton(state);
        String statusText = "";
        switch (state) {
            case DISCONNECTED:
                statusText = message != null ? message : getString(R.string.ble_status_disconnected);
                break;
            case SCANNING:
                statusText = getString(R.string.ble_status_scanning);
                break;
            case CONNECTING:
                statusText = getString(R.string.ble_status_connecting);
                break;
            case CONNECTED:
                statusText = getString(R.string.ble_status_connected);
                break;
        }
        Toast.makeText(this, statusText, Toast.LENGTH_SHORT).show();
    }

    private void updateBluetoothButton(BluetoothLeManager.BleConnectionState state) {
        switch (state) {
            case DISCONNECTED:
                btnBluetooth.setImageResource(R.drawable.ic_bluetooth_disabled);
                break;
            case SCANNING:
            case CONNECTING:
                btnBluetooth.setImageResource(R.drawable.ic_bluetooth_searching);
                break;
            case CONNECTED:
                btnBluetooth.setImageResource(R.drawable.ic_bluetooth_connected);
                break;
        }
    }
}