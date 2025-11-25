package ict.mgame.a5303_5308;

import android.content.Intent;
import android.os.Bundle;
import android.view.View; // 導入 View
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private SharedPreferencesHelper sharedPreferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferencesHelper = new SharedPreferencesHelper(this);

        // 初始化按鈕
        Button btnStartingTest = findViewById(R.id.btnStartingTest);
        Button btnRandomColour = findViewById(R.id.btnRandomColour);
        Button btnFavoriteColors = findViewById(R.id.btnFavoriteColors);
        Button btnRecord = findViewById(R.id.btnRecord);
        Button btnLogout = findViewById(R.id.btnLogout);
        Button btnPause = findViewById(R.id.btnPause);

        // ✨ 修改開始：將顏色方塊的變數類型從 Button 改為 View ✨
        View colorHappy = findViewById(R.id.colorHappy);
        View colorSad = findViewById(R.id.colorSad);
        View colorAnger = findViewById(R.id.colorAnger);
        View colorFear = findViewById(R.id.colorFear);
        View colorSelfAbasement = findViewById(R.id.colorSelfAbasement);
        View colorAnxiety = findViewById(R.id.colorAnxiety);
        View colorDisgust = findViewById(R.id.colorDisgust);
        // ✨ 修改結束 ✨

        // 設定點擊事件
        btnStartingTest.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StoryActivity.class);
            startActivity(intent);
        });

        btnRandomColour.setOnClickListener(v -> {
            Mood[] moods = Mood.values();
            Mood randomMood = moods[new Random().nextInt(moods.length)];
            // 新增：保存記錄
            sharedPreferencesHelper.saveRecord(randomMood);
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
            // 返回登入頁面
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        btnPause.setOnClickListener(v -> showPlaceholderToast());

        // 顏色方塊點擊事件 (這部分程式碼完全不需要修改)
        colorHappy.setOnClickListener(v -> showResult(Mood.HAPPY));
        colorSad.setOnClickListener(v -> showResult(Mood.SAD));
        colorAnger.setOnClickListener(v -> showResult(Mood.ANGER));
        colorFear.setOnClickListener(v -> showResult(Mood.FEAR));
        colorSelfAbasement.setOnClickListener(v -> showResult(Mood.SELF_ABASEMENT));
        colorAnxiety.setOnClickListener(v -> showResult(Mood.ANXIETY));
        colorDisgust.setOnClickListener(v -> showResult(Mood.DISGUST));
    }

    private void showResult(Mood mood) {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("RESULT_MOOD", mood.name());
        startActivity(intent);
    }

    private void showPlaceholderToast() {
        Toast.makeText(this, R.string.placeholder_feature, Toast.LENGTH_SHORT).show();
    }
}