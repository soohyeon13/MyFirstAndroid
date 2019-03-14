package com.example.user.myapplication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataBus {
    private List<String> allData;

    public DataBus() {
        allData = new LinkedList<>();
    }

    public void addData(String data) {
        allData.add(data);
    }

    public void removeData(int position) {
        allData.remove(position);
    }

    public void removeLastData() {
        allData.remove(allData.size() - 1);
    }

    public List<String> getOriginalAllData() {
        return allData;
    }

    public List<String> getCopiedAllData() {
        return new ArrayList<>(allData);
    }
}