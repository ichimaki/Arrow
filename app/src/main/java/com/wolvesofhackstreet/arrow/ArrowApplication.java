package com.wolvesofhackstreet.arrow;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class ArrowApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("FUOxGYWUZvFXXO4SlW0hTPe2uEE16hyczVYACY8e")
                .clientKey("XLnqr6AndHYxwu4VnWZUqpibaLgcNNZ0GevMlAu8")
                .server("https://parseapi.back4app.com/").build()
        );
    }
}
