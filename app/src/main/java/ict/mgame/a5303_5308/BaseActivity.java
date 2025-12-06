package ict.mgame.a5303_5308;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected BluetoothLeManager bluetoothLeManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bluetoothLeManager = BluetoothLeManager.getInstance();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

        // 統一處理底部圓形按鈕的點擊事件
        Button btnPause = findViewById(R.id.btnPause);
        if (btnPause != null) {
            btnPause.setOnClickListener(v -> {
                // 新功能：點擊按鈕關閉燈光
                if (bluetoothLeManager.isConnected()) {
                    bluetoothLeManager.turnOffLights();
                    Toast.makeText(this, R.string.lights_off, Toast.LENGTH_SHORT).show();
                } else {
                    // 如果藍牙未連接，保持原有的提示功能
                    Toast.makeText(this, R.string.placeholder_feature, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}