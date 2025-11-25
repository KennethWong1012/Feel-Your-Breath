package ict.mgame.a5303_5308;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText etNewUsername, etNewPassword, etConfirmPassword;
    private Button btnCreateAccount, btnBackToLogin;
    private SharedPreferencesHelper sharedPreferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sharedPreferencesHelper = new SharedPreferencesHelper(this);

        etNewUsername = findViewById(R.id.editTextNewUsername);
        etNewPassword = findViewById(R.id.editTextNewPassword);
        etConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        btnCreateAccount = findViewById(R.id.buttonCreateAccount);
        btnBackToLogin = findViewById(R.id.buttonBackToLogin);

        btnCreateAccount.setOnClickListener(v -> registerUser());
        btnBackToLogin.setOnClickListener(v -> finish()); // 點擊返回按鈕，關閉此頁面
    }

    private void registerUser() {
        String username = etNewUsername.getText().toString().trim();
        String password = etNewPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        // 1. 檢查欄位是否為空
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
            Toast.makeText(this, R.string.error_fields_empty, Toast.LENGTH_SHORT).show();
            return;
        }

        // 2. 檢查帳號密碼長度
        if (username.length() < 4) {
            Toast.makeText(this, R.string.error_username_too_short, Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length() < 4) {
            Toast.makeText(this, R.string.error_password_too_short, Toast.LENGTH_SHORT).show();
            return;
        }

        // 3. 檢查兩次輸入的密碼是否一致
        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, R.string.error_passwords_do_not_match, Toast.LENGTH_SHORT).show();
            return;
        }

        // 4. 檢查用戶名是否已被註冊
        if (sharedPreferencesHelper.doesUserExist(username)) {
            Toast.makeText(this, R.string.error_username_exists, Toast.LENGTH_SHORT).show();
            return;
        }

        // 5. 所有檢查通過，儲存用戶
        sharedPreferencesHelper.saveUser(username, password);
        Toast.makeText(this, R.string.register_successful, Toast.LENGTH_LONG).show();
        finish(); // 註冊成功後，關閉註冊頁面，返回登入頁
    }
}