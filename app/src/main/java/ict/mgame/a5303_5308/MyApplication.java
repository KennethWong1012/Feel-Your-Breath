package ict.mgame.a5303_5308;

import android.app.Application;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化藍牙管理器
        BluetoothLeManager.getInstance().init(this);
    }
}