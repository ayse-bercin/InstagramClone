package com.aysebercin.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class ParseStarterActivity extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);
        Parse.initialize(new Parse.Configuration.Builder(this)
           .applicationId("me7TjhkAwcU4R963OCCHszSLVDSUFhysUV6U8nvU")
            .clientKey("Xb8Z3419zDTnmNMYscVTs8cHG2soIhAq6WZHaGOG")
            .server("https://parseapi.back4app.com/")
            .build()
        );
    }
}
