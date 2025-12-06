package ict.mgame.a5303_5308;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

// 修改：繼承 BaseActivity
public class ResultActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        View viewColorPreview = findViewById(R.id.viewColorPreview);
        TextView tvMoodResult = findViewById(R.id.tvMoodResult);
        Button btnReturnMain = findViewById(R.id.btnReturnMain);
        // btnPause 的邏輯已在 BaseActivity 中處理

        String moodName = getIntent().getStringExtra("RESULT_MOOD");
        if (moodName != null) {
            try {
                Mood mood = Mood.valueOf(moodName);
                int color = mood.getColor(this);

                // 設定 UI
                viewColorPreview.setBackgroundColor(color);
                tvMoodResult.setText(getString(mood.getNameResId()));

                // 新增：發送顏色到藍牙設備
                if (bluetoothLeManager.isConnected()) {
                    bluetoothLeManager.sendColor(color);
                }

            } catch (IllegalArgumentException e) {
                tvMoodResult.setText("Unknown Mood");
                viewColorPreview.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            }
        }

        btnReturnMain.setOnClickListener(v -> finish());
    }
}