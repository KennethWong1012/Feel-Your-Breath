package ict.mgame.a5303_5308;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.List;

public class RecordActivity extends AppCompatActivity {

    private LinearLayout layoutRecords;
    private SharedPreferencesHelper sharedPreferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        layoutRecords = findViewById(R.id.layoutRecords);
        Button btnReturnMain = findViewById(R.id.btnReturnMain);
        Button btnPause = findViewById(R.id.btnPause);

        sharedPreferencesHelper = new SharedPreferencesHelper(this);

        loadRecords();

        btnReturnMain.setOnClickListener(v -> {
            finish(); // 直接關閉當前頁面返回主頁
        });

        btnPause.setOnClickListener(v -> {
            Toast.makeText(this, R.string.placeholder_feature, Toast.LENGTH_SHORT).show();
        });
    }

    private void loadRecords() {
        layoutRecords.removeAllViews(); // 清除舊視圖
        List<RecordItem> records = sharedPreferencesHelper.getRecords();

        if (records.isEmpty()) {
            TextView emptyView = new TextView(this);
            emptyView.setText(R.string.no_records_yet);
            emptyView.setGravity(Gravity.CENTER);
            emptyView.setPadding(0, 50, 0, 0);
            emptyView.setTextColor(ContextCompat.getColor(this, R.color.text_color));
            emptyView.setTextSize(18);
            layoutRecords.addView(emptyView);
            return;
        }

        for (RecordItem item : records) {
            // 為每條記錄創建一個水平佈局
            LinearLayout recordRow = new LinearLayout(this);
            recordRow.setOrientation(LinearLayout.HORIZONTAL);
            recordRow.setGravity(Gravity.CENTER_VERTICAL);
            recordRow.setPadding(8, 16, 8, 16);

            // 日期 TextView
            TextView dateView = new TextView(this);
            dateView.setText(item.getDate());
            dateView.setTextSize(18);
            dateView.setTextColor(ContextCompat.getColor(this, R.color.text_color));
            LinearLayout.LayoutParams dateParams = new LinearLayout.LayoutParams(
                    0, LinearLayout.LayoutParams.WRAP_CONTENT, 2.0f); // 讓日期佔更多空間
            dateView.setLayoutParams(dateParams);

            // 心情 TextView
            TextView moodView = new TextView(this);
            moodView.setTextSize(18);
            moodView.setTextColor(ContextCompat.getColor(this, R.color.text_color));
            moodView.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams moodParams = new LinearLayout.LayoutParams(
                    0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.5f);
            moodView.setLayoutParams(moodParams);

            // 顏色方塊 View
            View colorBlock = new View(this);
            LinearLayout.LayoutParams colorParams = new LinearLayout.LayoutParams(80, 80);
            colorParams.leftMargin = 24;
            colorBlock.setLayoutParams(colorParams);

            try {
                Mood mood = Mood.valueOf(item.getMood());
                // 設置心情的中文名稱
                moodView.setText(getString(mood.getNameResId()));
                // 設置顏色方塊的顏色
                colorBlock.setBackgroundColor(ContextCompat.getColor(this, mood.getColorResId()));
            } catch (Exception e) {
                moodView.setText(item.getMood()); // Fallback
                colorBlock.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            }

            // 將元件添加到行佈局
            recordRow.addView(dateView);
            recordRow.addView(moodView);
            recordRow.addView(colorBlock);

            // 將行佈局添加到主佈局
            layoutRecords.addView(recordRow);

            // 添加分隔線
            View separator = new View(this);
            separator.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 2));
            separator.setBackgroundColor(ContextCompat.getColor(this, R.color.light_blue_background));
            layoutRecords.addView(separator);
        }
    }
}