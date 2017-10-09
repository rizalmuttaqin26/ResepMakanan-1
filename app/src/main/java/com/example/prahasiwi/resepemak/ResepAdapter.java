package com.example.prahasiwi.resepemak;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PRAHASIWI on 02/10/2017.
 */

//Adapter dan ViewHolder
//Menghubungkan Data dengan tampilan
public class ResepAdapter extends RecyclerView.Adapter<ResepAdapter.ResepViewHolder> {
    private Context context;
    private ArrayList<Resep> resep;

    public ResepAdapter(Context context, ArrayList<Resep> resep){
        this.context = context;
        this.resep = resep;
    }

    //Hubungan antara layout parent dan anak
    @Override
    public ResepAdapter.ResepViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_resep,parent,false);
        return new ResepViewHolder(view);
    }

    public class ResepViewHolder extends RecyclerView.ViewHolder{
        ImageView imageResep;
        TextView textJudul;
        TextView textPenjelasan;
        RelativeLayout relativeLayout;

        public ResepViewHolder(View itemView){
            super(itemView);
            imageResep = (ImageView) itemView.findViewById(R.id.image_resep);
            textJudul = (TextView) itemView.findViewById(R.id.text_judul);
            textPenjelasan = (TextView) itemView.findViewById(R.id.text_penjelasan);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.rl_parent);
        }
    }

    //Mengikat data dari sumber ke dalam view yang ada di layout anak
    @Override
    public void onBindViewHolder(ResepAdapter.ResepViewHolder holder, final int position) {
        holder.textJudul.setText(resep.get(position).getJudulResep());
        holder.textPenjelasan.setText(resep.get(position).getPenjelasanResep());
        holder.imageResep.setImageResource(resep.get(position).getGambarResep());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DataResep.class);
                intent.putExtra("Bahan",resep.get(position).getBahanResep());
                intent.putExtra("Step",resep.get(position).getStepResep());
                intent.putExtra("Gambar",resep.get(position).getGambarResep());
                intent.putExtra("Judul",resep.get(position).getJudulResep());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return resep.size();
    }
}
