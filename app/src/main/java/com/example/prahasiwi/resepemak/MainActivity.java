package com.example.prahasiwi.resepemak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] judul_resep,penjelasan_resep,bahan_resep,step_resep;
    RecyclerView recyclerView;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.rv_resep);
        recyclerView.setLayoutManager(linearLayoutManager);

        judul_resep = getResources().getStringArray(R.array.judulResep);
        penjelasan_resep = getResources().getStringArray(R.array.penjelasanResep);
        bahan_resep =getResources().getStringArray(R.array.bahanResep);
        step_resep = getResources().getStringArray(R.array.stepResep);

        int[] imageResep = {R.drawable.sayurasem,R.drawable.terongbalado,
                R.drawable.ayamtepung,R.drawable.tahutelurkecap,
                R.drawable.tumisjamurtiram,R.drawable.udanggorengtepung};

        ArrayList<Resep> resepList = new ArrayList<>();

        for(int i=0;i<judul_resep.length;i++){
            Resep resep = new Resep(imageResep[i],judul_resep[i],penjelasan_resep[i],bahan_resep[i],step_resep[i]);

            resepList.add(resep);
        }

        ResepAdapter resepAdapter = new ResepAdapter(this,resepList);
        recyclerView.setAdapter(resepAdapter);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Klik sekali lagi", Toast.LENGTH_SHORT).show();
    }
}
