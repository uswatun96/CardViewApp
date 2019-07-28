package com.example.cardviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private List<Mahasiswa> mhsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mhsList = new ArrayList<>();
        adapter = new MahasiswaAdapter(this, mhsList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareData();
    }

    private  void prepareData(){
        int[] photos = new int[]{
                R.drawable.foto1,
                R.drawable.foto2,
                R.drawable.foto3
        };
        mhsList.add(new Mahasiswa("311610391", "Uswatun Chasanah", photos[0]));
        mhsList.add(new Mahasiswa("311610400","Azkia Nurul", photos[1]));
        mhsList.add(new Mahasiswa("311610897", "Fahun Hibban Almuyasar", photos[2]));

        adapter.notifyDataSetChanged();
    }
}
