package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class FragmentMyPage extends Fragment {
    View view;

    public static FragmentMyPage newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentMyPage fragment = new FragmentMyPage();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_mypage,container,false);
        return view;
    }

    public void onViewCreated(@Nullable View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);

        Button btn1 = view.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent order = new Intent(getActivity(),MyPageOrder.class);
                startActivity(order);
            }
        });
        final Switch sw = view.findViewById(R.id.switch1);
        Button btn2 = view.findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(getActivity(),"체크상태 :"+isChecked,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button btn3 = view.findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent interest = new Intent(getActivity(),MyPageInterest.class);
                startActivity(interest);
            }
        });

        Button btn4 = view.findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewitem = new Intent(getActivity(),MyPageViewItem.class);
                startActivity(viewitem);
            }
        });
    }

}
