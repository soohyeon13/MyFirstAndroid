package com.example.user.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.test.mock.MockApplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentBasket extends Fragment {
    View view;
    private  DataBus dataBus;

    public static FragmentBasket newInstance() {
        Bundle args = new Bundle();

        FragmentBasket fragment = new FragmentBasket();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_basket, container, false);

        dataBus = ((App) getActivity().getApplication()).getDataBus();

        return view;
    }
}
