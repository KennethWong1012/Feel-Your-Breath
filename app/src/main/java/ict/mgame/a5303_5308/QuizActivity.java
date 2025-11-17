package ict.mgame.a5303_5308;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizActivity extends AppCompatActivity {

    private TextView tvQuestion;
    private List<Button> answerButtons;
    private List<QuizModels.Question> questions;
    private int currentQuestionIndex = 0;

    private Map<Mood, Integer> moodCounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvQuestion = findViewById(R.id.tvQuestion);
        answerButtons = new ArrayList<>();
        answerButtons.add(findViewById(R.id.btnAnswerA));
        answerButtons.add(findViewById(R.id.btnAnswerB));
        answerButtons.add(findViewById(R.id.btnAnswerC));
        answerButtons.add(findViewById(R.id.btnAnswerD));
        answerButtons.add(findViewById(R.id.btnAnswerE));
        answerButtons.add(findViewById(R.id.btnAnswerF));
        answerButtons.add(findViewById(R.id.btnAnswerG));

        moodCounts = new HashMap<>();
        for (Mood mood : Mood.values()) {
            moodCounts.put(mood, 0);
        }

        // 從 Intent 獲取主題索引
        int themeIndex = getIntent().getIntExtra("THEME_INDEX", 0);
        // 根據索引獲取對應的題目列表
        questions = QuizData.getStoryThemes().get(themeIndex).getQuestions();

        displayQuestion();
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.size()) {
            QuizModels.Question currentQuestion = questions.get(currentQuestionIndex);
            tvQuestion.setText(currentQuestion.getQuestionText());

            List<QuizModels.Answer> answers = new ArrayList<>(currentQuestion.getAnswers());
            Collections.shuffle(answers); // 打亂答案順序

            char optionChar = 'A';
            for (int i = 0; i < answerButtons.size(); i++) {
                Button button = answerButtons.get(i);
                if (i < answers.size()) {
                    QuizModels.Answer answer = answers.get(i);
                    button.setText(String.format("%c: %s", optionChar++, answer.getText()));
                    button.setOnClickListener(v -> onAnswerSelected(answer.getMood()));
                    button.setVisibility(View.VISIBLE);
                } else {
                    button.setVisibility(View.GONE);
                }
            }
        } else {
            finishQuiz();
        }
    }

    private void onAnswerSelected(Mood mood) {
        // 增加對應心情的計數
        moodCounts.put(mood, moodCounts.get(mood) + 1);
        currentQuestionIndex++;
        displayQuestion();
    }

    private void finishQuiz() {
        Mood finalMood = Mood.HAPPY; // 預設心情
        int maxCount = -1;

        // 找出計數最高的心情
        for (Map.Entry<Mood, Integer> entry : moodCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                finalMood = entry.getKey();
            }
        }

        // 儲存記錄
        SharedPreferencesHelper helper = new SharedPreferencesHelper(this);
        helper.saveRecord(finalMood);

        // 跳轉到結果頁面
        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        intent.putExtra("RESULT_MOOD", finalMood.name());
        intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        startActivity(intent);
        finish();
    }
}