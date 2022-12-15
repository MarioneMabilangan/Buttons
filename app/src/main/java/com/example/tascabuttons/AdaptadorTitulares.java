package com.example.tascabuttons;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorTitulares extends RecyclerView.Adapter<AdaptadorTitulares.ViewHolder>{
    private ArrayList<Titular> titulars;

    public AdaptadorTitulares(ArrayList<Titular> titulars){
        this.titulars = titulars;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.recyclar, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Titular myListData = titulars.get(position);
        holder.textView.setText(titulars.get(position).getTitulo());
        holder.imageView.setImageResource(titulars.get(position).getIdimagen());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("DemoRecView", "Pulsado el elemento:${it.titulo}");

            }
        });

    }



    @Override
    public int getItemCount() {
        return titulars.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public TextView textView2;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.lblImagen);
            this.textView = (TextView) itemView.findViewById(R.id.lblTitulo);
            this.textView = (TextView) itemView.findViewById(R.id.lblSubtitulo);
        }
    }
}
