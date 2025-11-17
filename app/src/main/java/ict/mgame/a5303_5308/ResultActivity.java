package ict.mgame.a5303_5308;

import android.content.Intent;
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
        setContentView(R.layout.activity_result);

        View viewColorPreview = findViewById(R.id.viewColorPreview);
        TextView tvMoodResult = findViewById(R.id.tvMoodResult);
        Button btnReturnMain = findViewById(R.id.btnReturnMain);
        Button btnPause = findViewById(R.id.btnPause);

        String moodName = getIntent().getStringExtra("RESULT_MOOD");
        if (moodName != null) {
            try {
                Mood resultMood = Mood.valueOf(moodName);

                // 更新UI
                viewColorPreview.setBackgroundColor(ContextCompat.getColor(this, resultMood.getColorResId()));
                tvMoodResult.setText(getString(resultMood.getNameResId()));

            } catch (IllegalArgumentException e) {
                // 如果傳入的 moodName 無效
                tvMoodResult.setText("Unknown Mood");
            }
        }

        btnReturnMain.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        btnPause.setOnClickListener(v -> {
            Toast.makeText(this, R.string.placeholder_feature, Toast.LENGTH_SHORT).show();
        });
    }
}