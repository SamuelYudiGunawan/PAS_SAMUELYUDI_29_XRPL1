package com.example.pas_29_10rpl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ActivityTambah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        getSupportActionBar().setTitle("Tambah Makanan");
        RadioGroup group = findViewById(R.id.pilihan);
        Button tombol = findViewById(R.id.button);
        tombol.setOnClickListener(v -> {
            if (group.getCheckedRadioButtonId() == -1){
                Toast.makeText(this , "Pilih Salah Satu!", Toast.LENGTH_LONG).show();
                return;
            }
            Model model;
            switch (group.getCheckedRadioButtonId()){
                case R.id.burger:
                    model = new Model("Burger",R.drawable.beefburger);
                    break;
                case R.id.cola:
                    model = new Model("Cola",R.drawable.cocacola);
                    break;
                case R.id.esteh:
                    model = new Model("Es Teh",R.drawable.esteh);
                    break;
                case R.id.kentanggoreng:
                    model = new Model("Kentang Goreng",R.drawable.kentanggoreng);
                    break;
                default:model = new Model("",R.drawable.ic_launcher_background);
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("model",model);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}