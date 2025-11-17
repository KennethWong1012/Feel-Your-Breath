package ict.mgame.a5303_5308;

public class RecordItem {
    private String date;
    private String mood; // Storing mood as a string (enum name)

    public RecordItem(String date, String mood) {
        this.date = date;
        this.mood = mood;
    }

    public String getDate() {
        return date;
    }

    public String getMood() {
        return mood;
    }
}