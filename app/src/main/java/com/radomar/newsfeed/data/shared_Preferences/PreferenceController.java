package com.radomar.newsfeed.data.shared_Preferences;

/**
 * Created by Andrew on 15.05.2017.
 */

public interface PreferenceController {

    void saveToken(String token);
    String getToken();

}
