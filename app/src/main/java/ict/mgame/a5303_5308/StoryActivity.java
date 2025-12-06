package ict.mgame.a5303_5308;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Random;

// 修改：繼承 BaseActivity
public class StoryActivity extends BaseActivity {

    private TextView tvTopicTitle;
    private TextView tvStoryContent;
    private Button btnStartQuiz;

    private int currentThemeIndex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        tvTopicTitle = findViewById(R.id.tvTopicTitle);
        tvStoryContent = findViewById(R.id.tvStoryContent);
        btnStartQuiz = findViewById(R.id.btnStartQuiz);

        // 隨機選擇一個故事主題
        List<StoryTheme> themes = QuizData.getStoryThemes();
        currentThemeIndex = new Random().nextInt(themes.size());
        StoryTheme selectedTheme = themes.get(currentThemeIndex);

        // 顯示故事內容
        tvTopicTitle.setText(selectedTheme.getThemeTitle());
        tvStoryContent.setText(selectedTheme.getStoryContent());

        // 開始測驗按鈕
        btnStartQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(StoryActivity.this, QuizActivity.class);
            intent.putExtra("THEME_INDEX", currentThemeIndex);
            startActivity(intent);
            finish(); // 答題後不返回故事頁
        });
    }
}