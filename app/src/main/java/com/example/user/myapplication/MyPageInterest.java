package com.example.user.myapplication;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyPageInterest extends AppCompatActivity {
    private ListView interestList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_interest);

        interestList = (ListView) findViewById(R.id.interestList);

        dataSetting();
    }

    private void dataSetting() {
        ListViewBtnAdapter listAdapter = new ListViewBtnAdapter();


        for (int i = 0; i < 10; i++) {
            listAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.imgbtn), "name_" + i);
        }
        interestList.setAdapter(listAdapter);

    }
}

