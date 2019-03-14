package com.example.user.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class FragmentRecommend extends Fragment {
    List<String> list;
    View view;

    DataBus getList;
    private DataBus dataBus;

    public static FragmentRecommend newInstance() {
        Bundle args = new Bundle();
        FragmentRecommend fragment = new FragmentRecommend();
        fragment.dataBus = new DataBus();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle saveInstanceState) {
        view = inflater.inflate(R.layout.fragment_recommned, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = view.findViewById(R.id.textName);

        List<String> allData = dataBus.getCopiedAllData();

        if (list !=null && list.size() >=1){
            textView.setText(allData.get(0));
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
}
