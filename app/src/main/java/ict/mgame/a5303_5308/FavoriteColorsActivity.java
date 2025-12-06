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

// 修改：繼承 BaseActivity
public class FavoriteColorsActivity extends BaseActivity {

    private LinearLayout layoutFavorites;
    private SharedPreferencesHelper sharedPreferencesHelper;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 注意：這裡不能調用 super.setContentView，因為 BaseActivity 已經處理了
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
            View favoriteView = inflater.inflate(R.layout.list_item_record, layoutFavorites, false);

            TextView tvDate = favoriteView.findViewById(R.id.tvRecordDate);
            TextView tvMood = favoriteView.findViewById(R.id.tvRecordMood);
            View viewColor = favoriteView.findViewById(R.id.viewRecordColor);
            ImageButton btnFavorite = favoriteView.findViewById(R.id.btnFavoriteStar);

            tvDate.setVisibility(View.GONE);
            tvMood.setText(getString(mood.getNameResId()));
            int color = mood.getColor(this);
            viewColor.setBackgroundColor(color);
            btnFavorite.setImageResource(R.drawable.ic_star_filled);

            // 新增：點擊顏色方塊發送顏色
            viewColor.setOnClickListener(v -> {
                if (bluetoothLeManager.isConnected()) {
                    bluetoothLeManager.sendColor(color);
                    Toast.makeText(this, "Color sent: " + getString(mood.getNameResId()), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Bluetooth not connected", Toast.LENGTH_SHORT).show();
                }
            });

            btnFavorite.setOnClickListener(v -> {
                sharedPreferencesHelper.removeFavorite(mood);
                Toast.makeText(this, R.string.removed_from_favorites, Toast.LENGTH_SHORT).show();
                loadFavorites();
            });

            layoutFavorites.addView(favoriteView);

            View separator = new View(this);
            separator.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 2));
            separator.setBackgroundColor(ContextCompat.getColor(this, R.color.light_blue_background));
            layoutFavorites.addView(separator);
        }
    }
}