package ict.mgame.a5303_5308;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonRegister;
    private SharedPreferencesHelper sharedPreferencesHelper; // 新增

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 初始化 SharedPreferencesHelper
        sharedPreferencesHelper = new SharedPreferencesHelper(this);

        // 如果 admin 帳號不存在，則創建一個預設帳號
        if (!sharedPreferencesHelper.doesUserExist("admin")) {
            sharedPreferencesHelper.saveUser("admin", "1234");
        }

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonLogin.setOnClickListener(v -> login());

        // ✨ 修改註冊按鈕的行為，跳轉到 RegisterActivity
        buttonRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void login() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // ✨ 使用 SharedPreferencesHelper 來驗證用戶
        if (sharedPreferencesHelper.checkUserCredentials(username, password)) {
            Toast.makeText(this, R.string.login_successful, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, R.string.login_failed, Toast.LENGTH_SHORT).show();
        }
    }
}