package ru.job4j.daggerjob4j;

import android.app.Application;
import android.provider.Settings;

import dagger.Component;

public class App extends Application {
    private static StoreComponent store;
    @Override
    public void onCreate(){
        super.onCreate();
        store = DaggerStoreComponent.create();
    }

    public static StoreComponent getStore(){
        return store;
    }
}
