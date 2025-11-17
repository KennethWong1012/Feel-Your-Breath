package ict.mgame.a5303_5308;

import java.util.List;

public class QuizModels {

    public static class Answer {
        private String text;
        private Mood mood;

        public Answer(String text, Mood mood) {
            this.text = text;
            this.mood = mood;
        }

        public String getText() {
            return text;
        }

        public Mood getMood() {
            return mood;
        }
    }

    public static class Question {
        private String questionText;
        private List<Answer> answers;

        public Question(String questionText, List<Answer> answers) {
            this.questionText = questionText;
            this.answers = answers;
        }

        public String getQuestionText() {
            return questionText;
        }

        public List<Answer> getAnswers() {
            return answers;
        }
    }
}