package com.example.tascabuttons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Reciclar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciclar);
        Titular[] titulars = new Titular[] {
                new Titular("Lobo pensando","pensando", R.drawable._50),
                new Titular("Lobo tocando piano","tocando piano", R.drawable._6ac5ba070e188d56e21aa90df5dc9f6),
                new Titular("Lobo mirandose en el espejo","mirandose en el espejo", R.drawable.b39),
                new Titular("Lobo rompiendo su camisa","rompiendo su camisa", R.drawable.werewolf),
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recView);
        AdaptadorTitulares adaptadorTitulares = new AdaptadorTitulares(titulars);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptadorTitulares);
    }
}