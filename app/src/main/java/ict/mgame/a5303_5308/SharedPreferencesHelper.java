package ict.mgame.a5303_5308;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SharedPreferencesHelper {

    private static final String PREF_NAME = "FeelYourBreathPrefs";
    private static final String KEY_RECORDS = "key_records";
    private SharedPreferences sharedPreferences;
    private Gson gson;

    public SharedPreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public void saveRecord(Mood mood) {
        List<RecordItem> records = getRecords();
        if (records == null) {
            records = new ArrayList<>();
        }

        String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        records.add(0, new RecordItem(currentDate, mood.name())); // Add to the top of the list

        String json = gson.toJson(records);
        sharedPreferences.edit().putString(KEY_RECORDS, json).apply();
    }

    public List<RecordItem> getRecords() {
        String json = sharedPreferences.getString(KEY_RECORDS, null);
        if (json == null) {
            return new ArrayList<>();
        }
        Type type = new TypeToken<ArrayList<RecordItem>>() {}.getType();
        return gson.fromJson(json, type);
    }
}