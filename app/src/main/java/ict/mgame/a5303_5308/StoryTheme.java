package ict.mgame.a5303_5308;

import androidx.annotation.LayoutRes;
import java.util.List;

public class StoryTheme {
    private String themeTitle;
    private String storyContent;
    private List<QuizModels.Question> questions;
    private String themePrefix;
    private int layoutResId; // 用於 StoryActivity
    private int backgroundDrawableResId; // 用於 QuizActivity

    public StoryTheme(String themeTitle, String storyContent, List<QuizModels.Question> questions, String themePrefix, @LayoutRes int layoutResId, int backgroundDrawableResId) {
        this.themeTitle = themeTitle;
        this.storyContent = storyContent;
        this.questions = questions;
        this.themePrefix = themePrefix;
        this.layoutResId = layoutResId;
        this.backgroundDrawableResId = backgroundDrawableResId;
    }

    // ... Getters ...
    public String getThemeTitle() { return themeTitle; }
    public String getStoryContent() { return storyContent; }
    public List<QuizModels.Question> getQuestions() { return questions; }
    public String getThemePrefix() { return themePrefix; }
    public int getLayoutResId() { return layoutResId; }
    public int getBackgroundDrawableResId() { return backgroundDrawableResId; }
}