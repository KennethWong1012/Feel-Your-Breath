package ict.mgame.a5303_5308;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.List;

public class RecordActivity extends AppCompatActivity {

    private LinearLayout layoutRecords;
    private SharedPreferencesHelper sharedPreferencesHelper;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        layoutRecords = findViewById(R.id.layoutRecords);
        Button btnReturnMain = findViewById(R.id.btnReturnMain);
        Button btnPause = findViewById(R.id.btnPause);

        sharedPreferencesHelper = new SharedPreferencesHelper(this);
        inflater = LayoutInflater.from(this);

        loadRecords();

        btnReturnMain.setOnClickListener(v -> finish());
        btnPause.setOnClickListener(v -> Toast.makeText(this, R.string.placeholder_feature, Toast.LENGTH_SHORT).show());
    }

    private void loadRecords() {
        layoutRecords.removeAllViews();
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
            View recordView = inflater.inflate(R.layout.list_item_record, layoutRecords, false);

            TextView tvDate = recordView.findViewById(R.id.tvRecordDate);
            TextView tvMood = recordView.findViewById(R.id.tvRecordMood);
            View viewColor = recordView.findViewById(R.id.viewRecordColor);
            ImageButton btnFavorite = recordView.findViewById(R.id.btnFavoriteStar);

            tvDate.setText(item.getDate());

            try {
                Mood mood = Mood.valueOf(item.getMood());
                tvMood.setText(getString(mood.getNameResId()));
                viewColor.setBackgroundColor(ContextCompat.getColor(this, mood.getColorResId()));

                // 設置星星的初始狀態
                updateStarIcon(btnFavorite, sharedPreferencesHelper.isFavorite(mood));

                // 星星按鈕點擊事件
                btnFavorite.setOnClickListener(v -> {
                    if (sharedPreferencesHelper.isFavorite(mood)) {
                        sharedPreferencesHelper.removeFavorite(mood);
                        updateStarIcon(btnFavorite, false);
                        Toast.makeText(this, R.string.removed_from_favorites, Toast.LENGTH_SHORT).show();
                    } else {
                        sharedPreferencesHelper.addFavorite(mood);
                        updateStarIcon(btnFavorite, true);
                        Toast.makeText(this, R.string.added_to_favorites, Toast.LENGTH_SHORT).show();
                    }
                });

            } catch (Exception e) {
                tvMood.setText(item.getMood());
                viewColor.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
                btnFavorite.setVisibility(View.GONE);
            }

            layoutRecords.addView(recordView);

            // 添加分隔線
            View separator = new View(this);
            separator.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 2));
            separator.setBackgroundColor(ContextCompat.getColor(this, R.color.light_blue_background));
            layoutRecords.addView(separator);
        }
    }

    private void updateStarIcon(ImageButton button, boolean isFavorite) {
        if (isFavorite) {
            button.setImageResource(R.drawable.ic_star_filled);
        } else {
            button.setImageResource(R.drawable.ic_star_border);
        }
    }
}