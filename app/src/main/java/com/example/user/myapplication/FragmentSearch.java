package com.example.user.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class FragmentSearch extends Fragment {
    View view;
    private ArrayAdapter<String> listViewAdapter;
    private  DataBus dataBus;
    private List<String> originalAllData;

    public static FragmentSearch newInstance() {
        Bundle args = new Bundle();

        final FragmentSearch fragment = new FragmentSearch();
        fragment.dataBus = new DataBus();
        fragment.setArguments(args);

        return fragment;
    }


    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle saveInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText editText = view.findViewById(R.id.editText);
        TextView textName = view.findViewById(R.id.textName);
        final TextView textView3 =  view.findViewById(R.id.textView3);

        initList();
        Button add_btn = view.findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "추가되었습니다.", LENGTH_SHORT).show();
                textView3.setText(editText.getText().toString());
                if (!editText.getText().toString().equals("")) {
                    dataBus.addData(editText.getText().toString());
                    listViewAdapter.notifyDataSetChanged();
                }
            }
        });
        Button delete_btn = view.findViewById(R.id.delete_btn);
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBus.removeLastData();
                listViewAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initList() {
        ListView listView = view.findViewById(R.id.listview);

        listViewAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                dataBus.getOriginalAllData()
        );
        listView.setAdapter(listViewAdapter);
    }
}