package ict.mgame.a5303_5308;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 這行程式碼會加載我們剛剛修正的 activity_result.xml 檔案
        setContentView(R.layout.activity_result);

        // 綁定 UI 元件
        View viewColorPreview = findViewById(R.id.viewColorPreview);
        TextView tvMoodResult = findViewById(R.id.tvMoodResult);
        Button btnReturnMain = findViewById(R.id.btnReturnMain);
        Button btnPause = findViewById(R.id.btnPause);

        // 從 Intent 中獲取心情結果
        String moodName = getIntent().getStringExtra("RESULT_MOOD");
        if (moodName != null) {
            try {
                Mood mood = Mood.valueOf(moodName);

                // 根據心情設定顏色和文字
                viewColorPreview.setBackgroundColor(ContextCompat.getColor(this, mood.getColorResId()));
                tvMoodResult.setText(getString(mood.getNameResId()));

            } catch (IllegalArgumentException e) {
                // 如果傳來的心情名稱無效，做一個預設處理
                tvMoodResult.setText("Unknown Mood");
                viewColorPreview.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            }
        }

        // 返回按鈕的點擊事件
        btnReturnMain.setOnClickListener(v -> finish());

        // 暫停按鈕的點擊事件
        btnPause.setOnClickListener(v -> {
            Toast.makeText(this, R.string.placeholder_feature, Toast.LENGTH_SHORT).show();
        });
    }
}