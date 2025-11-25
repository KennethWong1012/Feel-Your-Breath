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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FavoriteColorsActivity extends AppCompatActivity {

    private LinearLayout layoutFavorites;
    private SharedPreferencesHelper sharedPreferencesHelper;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_colors);

        layoutFavorites = findViewById(R.id.layoutFavorites);
        Button btnReturnMain = findViewById(R.id.btnReturnMain);

        sharedPreferencesHelper = new SharedPreferencesHelper(this);
        inflater = LayoutInflater.from(this);

        loadFavorites();

        btnReturnMain.setOnClickListener(v -> finish());
    }

    private void loadFavorites() {
        layoutFavorites.removeAllViews();
        Set<String> favoriteNames = sharedPreferencesHelper.getFavorites();

        if (favoriteNames.isEmpty()) {
            TextView emptyView = new TextView(this);
            emptyView.setText(R.string.no_favorites_yet);
            emptyView.setGravity(Gravity.CENTER);
            emptyView.setPadding(0, 50, 0, 0);
            emptyView.setTextColor(ContextCompat.getColor(this, R.color.text_color));
            emptyView.setTextSize(18);
            layoutFavorites.addView(emptyView);
            return;
        }

        List<Mood> favoriteMoods = new ArrayList<>();
        for(String name : favoriteNames) {
            try {
                favoriteMoods.add(Mood.valueOf(name));
            } catch (Exception e) {
                // Ignore invalid names
            }
        }

        for (Mood mood : favoriteMoods) {
            // 重用 list_item_record 佈局，但隱藏日期
            View favoriteView = inflater.inflate(R.layout.list_item_record, layoutFavorites, false);

            TextView tvDate = favoriteView.findViewById(R.id.tvRecordDate);
            TextView tvMood = favoriteView.findViewById(R.id.tvRecordMood);
            View viewColor = favoriteView.findViewById(R.id.viewRecordColor);
            ImageButton btnFavorite = favoriteView.findViewById(R.id.btnFavoriteStar);

            tvDate.setVisibility(View.GONE); // 隱藏日期
            tvMood.setText(getString(mood.getNameResId()));
            viewColor.setBackgroundColor(ContextCompat.getColor(this, mood.getColorResId()));
            btnFavorite.setImageResource(R.drawable.ic_star_filled); // 這裡都是最愛，所以是實心

            // 點擊星星移除最愛
            btnFavorite.setOnClickListener(v -> {
                sharedPreferencesHelper.removeFavorite(mood);
                Toast.makeText(this, R.string.removed_from_favorites, Toast.LENGTH_SHORT).show();
                loadFavorites(); // 重新加載列表以刷新UI
            });

            layoutFavorites.addView(favoriteView);

            // 添加分隔線
            View separator = new View(this);
            separator.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 2));
            separator.setBackgroundColor(ContextCompat.getColor(this, R.color.light_blue_background));
            layoutFavorites.addView(separator);
        }
    }
}