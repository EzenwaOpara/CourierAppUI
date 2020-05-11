package com.benjamin.courierappui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Icons> mIcons;
    private RecyclerView mRecyclerView;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        initializeData();
        initializeAdapter();
    }

    private void initializeAdapter() {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mIcons);
        mRecyclerView.setAdapter(adapter);
    }

    private void initializeData() {
        mIcons = new ArrayList<>();
        mIcons.add(new Icons("Create Shipment", R.drawable.ic_local_shipping));
        mIcons.add(new Icons("Schedule Pickup", R.drawable.ic_event));
        mIcons.add(new Icons("My Wallet", R.drawable.ic_account_balance_wallet));
        mIcons.add(new Icons("Information", R.drawable.ic_perm_device_information));
    }
    public class Icons {
        String name;
        int iconId;
        Icons(String name, int iconId){
            this.name = name;
            this.iconId = iconId;
        }
    }
}