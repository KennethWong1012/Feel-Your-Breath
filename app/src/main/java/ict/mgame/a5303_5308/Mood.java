package ict.mgame.a5303_5308;

import android.content.Context;
import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;

public enum Mood {
    HAPPY(R.string.happy, R.color.mood_happy),
    SAD(R.string.sad, R.color.mood_sad),
    ANGER(R.string.anger, R.color.mood_anger),
    FEAR(R.string.fear, R.color.mood_fear),
    SELF_ABASEMENT(R.string.self_abasement, R.color.mood_self_abasement),
    ANXIETY(R.string.anxiety, R.color.mood_anxiety),
    DISGUST(R.string.disgust, R.color.mood_disgust);

    private final int nameResId;
    private final int colorResId;

    Mood(@StringRes int nameResId, @ColorRes int colorResId) {
        this.nameResId = nameResId;
        this.colorResId = colorResId;
    }

    public int getNameResId() {
        return nameResId;
    }

    public int getColorResId() {
        return colorResId;
    }

    // 新增：獲取顏色的整數值
    public int getColor(Context context) {
        return ContextCompat.getColor(context, this.colorResId);
    }
}