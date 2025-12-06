package ict.mgame.a5303_5308;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 修改：繼承 BaseActivity
public class QuizActivity extends BaseActivity {

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

        int themeIndex = getIntent().getIntExtra("THEME_INDEX", 0);
        questions = QuizData.getStoryThemes().get(themeIndex).getQuestions();

        displayQuestion();
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.size()) {
            QuizModels.Question currentQuestion = questions.get(currentQuestionIndex);
            tvQuestion.setText(currentQuestion.getQuestionText());

            List<QuizModels.Answer> answers = new ArrayList<>(currentQuestion.getAnswers());
            Collections.shuffle(answers);

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
        moodCounts.put(mood, moodCounts.get(mood) + 1);
        currentQuestionIndex++;
        displayQuestion();
    }

    private void finishQuiz() {
        Mood finalMood = Mood.HAPPY;
        int maxCount = -1;

        for (Map.Entry<Mood, Integer> entry : moodCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                finalMood = entry.getKey();
            }
        }

        SharedPreferencesHelper helper = new SharedPreferencesHelper(this);
        helper.saveRecord(finalMood);

        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        intent.putExtra("RESULT_MOOD", finalMood.name());
        intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        startActivity(intent);
        finish();
    }
}