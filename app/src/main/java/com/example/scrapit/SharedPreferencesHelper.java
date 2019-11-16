package com.example.scrapit;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.example.scrapit.adapters.Users;
import com.google.gson.GsonBuilder;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferencesHelper {

    private Context ctx;

    public static final String STATUS_KEY = "login_key";
    public static final String MY_PREFS_NAME = "MY_PREFS_FILE";

    public SharedPreferencesHelper(Context context){
        this.ctx = context;
    }

    public void putAuthData(Users user) {
        putStringPreference(ctx,
                MY_PREFS_NAME,
                STATUS_KEY,
                new GsonBuilder()
                        .create()
                        .toJson(user));
    }

    public Users getAuthData() {
        return new GsonBuilder().create().fromJson(
                getStringPreference(ctx, MY_PREFS_NAME, STATUS_KEY), Users.class);
    }


    private void putStringPreference(Context context, String prefsName, String key, String value) {

        SharedPreferences preferences = context.getSharedPreferences(prefsName, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(key, value);
        editor.apply();
    }

    public void clearSharedPref(){
        SharedPreferences settings = ctx.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        settings.edit().clear().apply();
    }

    private String getStringPreference(Context context, String prefsName,
                                       String key) {

        SharedPreferences preferences = context.getSharedPreferences(prefsName,
                Activity.MODE_PRIVATE);
        return preferences.getString(key, "null");
    }

}
