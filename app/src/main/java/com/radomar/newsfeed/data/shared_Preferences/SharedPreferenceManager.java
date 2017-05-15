package com.radomar.newsfeed.data.shared_Preferences;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by Andrew on 15.05.2017.
 */

public final class SharedPreferenceManager implements PreferenceController {

    private SharedPreferences preferences;
    private static final String SHARED_PREF = "shared_pref";
    private static final String TOKEN_KEY = "token_key";

    @Inject
    public SharedPreferenceManager(Context context) {
        preferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
    }

    @Override
    public void saveToken(String token) {
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TOKEN_KEY, token);
        editor.apply();
    }

    @Override
    public String getToken() {
        return preferences.getString(TOKEN_KEY, "");
    }
}
