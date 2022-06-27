package com.example.MyHealth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.MyHealth.adapters.recyclerMedAdapter;

import java.util.ArrayList;

public class MedAidList extends AppCompatActivity {
    private ArrayList<MedicalAids> medAidLists;
    private RecyclerView recyclerView;
    private recyclerMedAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_aid_list);
        recyclerView = findViewById(R.id.aidrecycler);

        medAidLists = new ArrayList<MedicalAids>();

        setAidInfo();
        setAdapter();
    }

    private void setAdapter() {
        setOnClickListener();
        recyclerMedAdapter adapter = new recyclerMedAdapter(medAidLists, listener);
       RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener() {
        listener = new recyclerMedAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), MedAidSignUp.class);
                intent.putExtra("name",medAidLists.get(position).getName());
                startActivity(intent);
            }
        };
    }

    private void setAidInfo() {
        medAidLists.add(new MedicalAids("Bonvie"));
        medAidLists.add(new MedicalAids("Cimas"));
        medAidLists.add(new MedicalAids("PSMAS"));

    }
}