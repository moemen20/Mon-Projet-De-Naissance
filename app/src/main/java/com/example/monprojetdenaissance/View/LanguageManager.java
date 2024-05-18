package com.example.monprojetdenaissance.View;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

public class LanguageManager {
    private Context ct;
    public LanguageManager(Context ct){
        this.ct=ct;
    }
    public void updateResources(String code){
        Locale local = new Locale(code);
        Locale.setDefault(local);
        Resources resources = ct.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(local);
        resources.updateConfiguration(configuration,resources.getDisplayMetrics());
    }

}
