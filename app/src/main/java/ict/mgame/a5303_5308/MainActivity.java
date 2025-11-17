package ict.mgame.a5303_5308;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化按鈕
        Button btnStartingTest = findViewById(R.id.btnStartingTest);
        Button btnRandomColour = findViewById(R.id.btnRandomColour);
        Button btnRecord = findViewById(R.id.btnRecord);
        Button btnPause = findViewById(R.id.btnPause);

        // 初始化顏色方塊按鈕
        Button colorHappy = findViewById(R.id.colorHappy);
        Button colorSad = findViewById(R.id.colorSad);
        Button colorAnger = findViewById(R.id.colorAnger);
        Button colorFear = findViewById(R.id.colorFear);
        Button colorSelfAbasement = findViewById(R.id.colorSelfAbasement);
        Button colorAnxiety = findViewById(R.id.colorAnxiety);
        Button colorDisgust = findViewById(R.id.colorDisgust);

        // 設定點擊事件
        btnStartingTest.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StoryActivity.class);
            startActivity(intent);
        });

        btnRandomColour.setOnClickListener(v -> {
            Mood[] moods = Mood.values();
            Mood randomMood = moods[new Random().nextInt(moods.length)];
            showResult(randomMood);
        });

        btnRecord.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RecordActivity.class);
            startActivity(intent);
        });

        btnPause.setOnClickListener(v -> showPlaceholderToast());

        // 顏色方塊點擊事件
        colorHappy.setOnClickListener(v -> showResult(Mood.HAPPY));
        colorSad.setOnClickListener(v -> showResult(Mood.SAD));
        colorAnger.setOnClickListener(v -> showResult(Mood.ANGER));
        colorFear.setOnClickListener(v -> showResult(Mood.FEAR));
        colorSelfAbasement.setOnClickListener(v -> showResult(Mood.SELF_ABASEMENT));
        colorAnxiety.setOnClickListener(v -> showResult(Mood.ANXIETY));
        colorDisgust.setOnClickListener(v -> showResult(Mood.DISGUST));
    }

    private void showResult(Mood mood) {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("RESULT_MOOD", mood.name());
        startActivity(intent);
    }

    private void showPlaceholderToast() {
        Toast.makeText(this, R.string.placeholder_feature, Toast.LENGTH_SHORT).show();
    }
}