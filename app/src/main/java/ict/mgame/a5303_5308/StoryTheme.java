package ict.mgame.a5303_5308;

import java.util.List;

public class StoryTheme {
    private String themeTitle;
    private String storyContent;
    private List<QuizModels.Question> questions;

    public StoryTheme(String themeTitle, String storyContent, List<QuizModels.Question> questions) {
        this.themeTitle = themeTitle;
        this.storyContent = storyContent;
        this.questions = questions;
    }

    public String getThemeTitle() {
        return themeTitle;
    }

    public String getStoryContent() {
        return storyContent;
    }

    public List<QuizModels.Question> getQuestions() {
        return questions;
    }
}