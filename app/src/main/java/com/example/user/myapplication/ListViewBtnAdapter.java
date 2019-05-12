package com.example.user.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewBtnAdapter extends BaseAdapter {

    private ArrayList<MyItem> mItems = new ArrayList<>();

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_btn_item, parent, false);
        }

        ImageView list_img = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView list_text = (TextView) convertView.findViewById(R.id.listViewText1);
        Button list_btn = (Button) convertView.findViewById(R.id.listViewBtn1);


        MyItem myItem = (MyItem) getItem(position);

        list_img.setImageDrawable(myItem.getIcon());
        list_text.setText(myItem.getName());
        list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return convertView;
    }

    public void addItem(Drawable img, String name) {
        MyItem mItem = new MyItem();

        mItem.setIcon(img);
        mItem.setName(name);

        mItems.add(mItem);
    }
}
