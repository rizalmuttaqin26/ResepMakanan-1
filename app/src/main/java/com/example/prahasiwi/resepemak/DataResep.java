package com.example.prahasiwi.resepemak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DataResep extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_resep);
        Intent intent = getIntent();
        getSupportActionBar().setTitle(intent.getStringExtra("Judul"));

        TextView bahan = (TextView) findViewById(R.id.txtBahan);
        TextView step = (TextView) findViewById(R.id.txtStep);
        ImageView gambar = (ImageView) findViewById(R.id.imgResep);

        gambar.setImageResource(intent.getIntExtra("Gambar",0));
        bahan.setText(intent.getStringExtra("Bahan"));
        step.setText(intent.getStringExtra("Step"));
    }
}
