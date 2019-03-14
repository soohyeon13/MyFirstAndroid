package com.example.user.myapplication;

import android.graphics.drawable.Drawable;
import android.widget.Button;

class MyItem {
    private Drawable icon;
    private String name;
    private String contents;
    private Button deletbtn;

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Button setAddbtn() {
        return deletbtn;
    }
}
