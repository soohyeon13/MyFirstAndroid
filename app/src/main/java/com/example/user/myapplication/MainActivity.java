package com.example.user.myapplication;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.mock.MockApplication;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button kate1, search_set1, recommend1, basket1, mypage;
    private FragmentManager fm;
    private FragmentTransaction f_tran;
    private FragmentKate fragmentKate;
    private FragmentSearch fragmentSearch;
    private FragmentRecommend fragmentRecommend;
    private FragmentBasket fragmentBasket;
    private FragmentMyPage fragmentMyPage;
    private DataBus dataBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initFragment();
        ImageButton imgbtn = findViewById(R.id.imgbtn1);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyPageOrder.class);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        kate1 = (Button) findViewById(R.id.kate1);
        search_set1 = (Button) findViewById(R.id.search_set1);
        recommend1 = (Button) findViewById(R.id.recommend1);
        basket1 = (Button) findViewById(R.id.basket1);
        mypage = (Button) findViewById(R.id.mypage);

        kate1.setOnClickListener(this);
        search_set1.setOnClickListener(this);
        recommend1.setOnClickListener(this);
        basket1.setOnClickListener(this);
        mypage.setOnClickListener(this);
    }

    private void initFragment() {

        fragmentKate = FragmentKate.newInstance();
        fragmentSearch = FragmentSearch.newInstance();
        fragmentRecommend = FragmentRecommend.newInstance();
        fragmentBasket = FragmentBasket.newInstance();
        fragmentMyPage = FragmentMyPage.newInstance();

        getSupportFragmentManager().beginTransaction().add(R.id.fram_main, fragmentRecommend).commit();
    }

    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        f_tran = fm.beginTransaction();
        switch (n) {
            case 0:
                f_tran.replace(R.id.fram_main, fragmentKate);
                f_tran.commit();
                break;
            case 1:
                f_tran.replace(R.id.fram_main, fragmentSearch);
                f_tran.commit();
                break;
            case 2:
                f_tran.replace(R.id.fram_main, fragmentRecommend);
                f_tran.commit();
                break;
            case 3:
                f_tran.replace(R.id.fram_main, fragmentBasket);
                f_tran.commit();
                break;
            case 4:
                f_tran.replace(R.id.fram_main, fragmentMyPage);
                f_tran.commit();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kate1:
                setFrag(0);
                break;
            case R.id.search_set1:
                setFrag(1);
                break;
            case R.id.recommend1:
                setFrag(2);
                break;
            case R.id.basket1:
                setFrag(3);
                break;
            case R.id.mypage:
                setFrag(4);
                break;
        }
    }
}
