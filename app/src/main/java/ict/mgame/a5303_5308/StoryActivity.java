package ict.mgame.a5303_5308;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Random;

public class StoryActivity extends AppCompatActivity {

    private int selectedThemeIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        TextView tvTopicTitle = findViewById(R.id.tvTopicTitle);
        TextView tvStoryContent = findViewById(R.id.tvStoryContent);
        Button btnStartQuiz = findViewById(R.id.btnStartQuiz);

        // 隨機選擇一個故事主題
        List<StoryTheme> themes = QuizData.getStoryThemes();
        selectedThemeIndex = new Random().nextInt(themes.size());
        StoryTheme selectedTheme = themes.get(selectedThemeIndex);

        // 更新UI顯示主題和故事內容
        tvTopicTitle.setText(selectedTheme.getThemeTitle());
        tvStoryContent.setText(selectedTheme.getStoryContent());

        btnStartQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(StoryActivity.this, QuizActivity.class);
            // 將選擇的主題索引傳遞給下一個 Activity
            intent.putExtra("THEME_INDEX", selectedThemeIndex);
            startActivity(intent);
            finish(); // 開始測驗後關閉此頁面
        });
    }
}