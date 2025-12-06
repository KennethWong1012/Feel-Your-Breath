package ict.mgame.a5303_5308;

public interface BleConnectionListener {
    // 定義連接狀態的枚舉
    enum ConnectionState {
        DISCONNECTED,
        CONNECTING,
        CONNECTED,
        FAILED
    }

    // 當連接狀態改變時調用
    void onConnectionStateChanged(ConnectionState state);
}