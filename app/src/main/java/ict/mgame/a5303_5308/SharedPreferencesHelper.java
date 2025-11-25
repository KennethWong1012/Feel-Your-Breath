package ict.mgame.a5303_5308;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class SharedPreferencesHelper {

    private static final String PREF_NAME = "FeelYourBreathPrefs";
    private static final String KEY_RECORDS = "key_records";
    private static final String KEY_FAVORITES = "key_favorites";
    private static final String USER_PREFIX = "user_"; // 用於儲存用戶的前綴

    private SharedPreferences sharedPreferences;
    private Gson gson;

    public SharedPreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    // --- ✨ 新增：用戶帳號管理 ---

    /**
     * 檢查用戶名是否存在
     * @param username 要檢查的用戶名
     * @return 如果存在返回 true, 否則 false
     */
    public boolean doesUserExist(String username) {
        return sharedPreferences.contains(USER_PREFIX + username);
    }

    /**
     * 儲存新用戶
     * @param username 用戶名
     * @param password 密碼
     */
    public void saveUser(String username, String password) {
        sharedPreferences.edit().putString(USER_PREFIX + username, password).apply();
    }

    /**
     * 驗證用戶登入
     * @param username 用戶名
     * @param password 密碼
     * @return 如果用戶名和密碼匹配返回 true, 否則 false
     */
    public boolean checkUserCredentials(String username, String password) {
        String storedPassword = sharedPreferences.getString(USER_PREFIX + username, null);
        return storedPassword != null && storedPassword.equals(password);
    }


    // --- 記錄管理 (維持不變) ---
    public void saveRecord(Mood mood) {
        List<RecordItem> records = getRecords();
        if (records == null) {
            records = new ArrayList<>();
        }

        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date());
        records.add(0, new RecordItem(currentDate, mood.name()));

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

    // --- 我的最愛管理 (維持不變) ---
    public Set<String> getFavorites() {
        String json = sharedPreferences.getString(KEY_FAVORITES, null);
        if (json == null) {
            return new HashSet<>();
        }
        Type type = new TypeToken<HashSet<String>>() {}.getType();
        return gson.fromJson(json, type);
    }

    private void saveFavorites(Set<String> favorites) {
        String json = gson.toJson(favorites);
        sharedPreferences.edit().putString(KEY_FAVORITES, json).apply();
    }

    public boolean isFavorite(Mood mood) {
        return getFavorites().contains(mood.name());
    }

    public void addFavorite(Mood mood) {
        Set<String> favorites = getFavorites();
        favorites.add(mood.name());
        saveFavorites(favorites);
    }

    public void removeFavorite(Mood mood) {
        Set<String> favorites = getFavorites();
        favorites.remove(mood.name());
        saveFavorites(favorites);
    }
}