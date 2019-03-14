package com.example.user.myapplication;

import android.app.Application;

public class App extends Application {
    private DataBus dataBus;

    @Override
    public void onCreate() {
        super.onCreate();

        dataBus = new DataBus();
    }

    public DataBus getDataBus(){
        return dataBus;
    }
}
