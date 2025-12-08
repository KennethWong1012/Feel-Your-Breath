package ict.mgame.a5303_5308;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class StoryActivity extends BaseActivity {

    private TextView tvTopicTitle;
    private TextView tvStoryContent;
    private Button btnStartQuiz;
    private int currentThemeIndex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. 決定主題
        List<StoryTheme> themes = QuizData.getStoryThemes();
        currentThemeIndex = new Random().nextInt(themes.size());
        StoryTheme selectedTheme = themes.get(currentThemeIndex);

        // ✨ 2. 載入主題專屬的、包含貼圖的佈局檔案
        setContentView(selectedTheme.getLayoutResId());

        // 3. 初始化視圖 (ID來自被include的 layout_story_content.xml)
        initViews();

        // 4. 設定內容
        tvTopicTitle.setText(selectedTheme.getThemeTitle());
        tvStoryContent.setText(selectedTheme.getStoryContent());

        // 5. 設定按鈕監聽器
        btnStartQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(StoryActivity.this, QuizActivity.class);
            intent.putExtra("THEME_INDEX", currentThemeIndex);
            startActivity(intent);
            finish();
        });
    }

    private void initViews() {
        tvTopicTitle = findViewById(R.id.tvTopicTitle);
        tvStoryContent = findViewById(R.id.tvStoryContent);
        btnStartQuiz = findViewById(R.id.btnStartQuiz);
    }
}