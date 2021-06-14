package com.example.pas_29_10rpl1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static List<Model> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Menu Makanan");
        if (models != null) {
            Model model = (Model) getIntent().getExtras().getSerializable("model");
            models.add(model);
            System.out.println(model);
        }
        else setUp();


        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MakananAdaptor(models));

        FloatingActionButton tomboltambah = findViewById(R.id.addbutton);
        tomboltambah.setOnClickListener(v -> {
        startActivity(new Intent(this,ActivityTambah.class));
        });
    }
    private void setUp(){
        models = new ArrayList<>();
        models.add(new Model("Burger",R.drawable.beefburger));
        models.add(new Model("Kentang Goreng",R.drawable.kentanggoreng));
        models.add(new Model("Es Teh",R.drawable.esteh));
        models.add(new Model("Cola",R.drawable.cocacola));
    }
}