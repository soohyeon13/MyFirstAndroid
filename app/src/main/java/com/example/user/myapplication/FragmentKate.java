package com.example.user.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentKate extends Fragment {
    View view;

    public static FragmentKate newInstance() {
        Bundle args = new Bundle();

        FragmentKate fragment = new FragmentKate();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,Bundle saveInstanceState) {
        view = inflater.inflate(R.layout.fragment_kate,container,false);

        return view;
    }
}
