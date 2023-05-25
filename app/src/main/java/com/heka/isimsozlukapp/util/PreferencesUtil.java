package com.heka.isimsozlukapp.util;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesUtil {
    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_STRING_VALUE = "stringValue";

    public static void saveString(Context context, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_STRING_VALUE, value);
        editor.apply();
    }

    public static String getString(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_STRING_VALUE, "");
    }
}
