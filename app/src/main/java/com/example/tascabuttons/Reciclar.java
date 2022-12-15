package com.example.tascabuttons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class Reciclar extends AppCompatActivity {
    Button btnInsertar,btnEliminar,btnMover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciclar);
        ArrayList<Titular> titulars = new ArrayList<>();

        /*Titular[] titulars = new Titular[] {
                new Titular("Lobo pensando","pensando", R.drawable._50),
                new Titular("Lobo tocando piano","tocando piano", R.drawable._6ac5ba070e188d56e21aa90df5dc9f6),
                new Titular("Lobo mirandose en el espejo","mirandose en el espejo", R.drawable.b39),
                new Titular("Lobo rompiendo su camisa","rompiendo su camisa", R.drawable.werewolf),
                new Titular("Lobo pensando","pensando", R.drawable._50),
                new Titular("Lobo tocando piano","tocando piano", R.drawable._6ac5ba070e188d56e21aa90df5dc9f6),
                new Titular("Lobo mirandose en el espejo","mirandose en el espejo", R.drawable.b39),
                new Titular("Lobo rompiendo su camisa","rompiendo su camisa", R.drawable.werewolf),
                new Titular("Lobo pensando","pensando", R.drawable._50),
                new Titular("Lobo tocando piano","tocando piano", R.drawable._6ac5ba070e188d56e21aa90df5dc9f6),
                new Titular("Lobo mirandose en el espejo","mirandose en el espejo", R.drawable.b39),
                new Titular("Lobo rompiendo su camisa","rompiendo su camisa", R.drawable.werewolf),
        };*/
        titulars.add(new Titular("Lobo pensando","pensando", R.drawable._50));
        titulars.add(new Titular("Lobo tocando piano","tocando piano", R.drawable._6ac5ba070e188d56e21aa90df5dc9f6));
        titulars.add(new Titular("Lobo mirandose en el espejo","mirandose en el espejo", R.drawable.b39));
        titulars.add(new Titular("Lobo rompiendo su camisa","rompiendo su camisa", R.drawable.werewolf));
        titulars.add(new Titular("Lobo pensando","pensando", R.drawable._50));
        titulars.add(new Titular("Lobo tocando piano","tocando piano", R.drawable._6ac5ba070e188d56e21aa90df5dc9f6));
        titulars.add(new Titular("Lobo mirandose en el espejo","mirandose en el espejo", R.drawable.b39));
        titulars.add(new Titular("Lobo rompiendo su camisa","rompiendo su camisa", R.drawable.werewolf));
        titulars.add(new Titular("Lobo pensando","pensando", R.drawable._50));
        titulars.add(new Titular("Lobo tocando piano","tocando piano", R.drawable._6ac5ba070e188d56e21aa90df5dc9f6));
        titulars.add(new Titular("Lobo mirandose en el espejo","mirandose en el espejo", R.drawable.b39));
        titulars.add(new Titular("Lobo rompiendo su camisa","rompiendo su camisa", R.drawable.werewolf));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recView);
        AdaptadorTitulares adaptadorTitulares = new AdaptadorTitulares(titulars);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(recyclerView.getItemAnimator());
        recyclerView.setAdapter(adaptadorTitulares);
        btnInsertar = (Button)findViewById(R.id.btnInsertar);
        btnEliminar = (Button)findViewById(R.id.btnEliminar);
        btnMover = (Button)findViewById(R.id.btnMover);
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titulars.add(new Titular("Lobo misterioso","rompiendo su camisa", R.drawable.werewolf_gettyimages_1332890250));
                adaptadorTitulares.notifyItemInserted(1);
            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titulars.remove(1);
                adaptadorTitulares.notifyItemRemoved(1);
            }
        });
        btnMover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int pos1 = random.nextInt(titulars.size());
                int pos2 = random.nextInt(titulars.size());
                Titular temp = titulars.get(pos1);
                titulars.set(pos1, titulars.get(pos2));
                titulars.set(pos2, temp);
                adaptadorTitulares.notifyItemMoved(pos1,pos2);
            }
        });
    }
}