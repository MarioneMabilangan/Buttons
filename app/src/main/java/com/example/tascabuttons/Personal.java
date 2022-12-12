package com.example.tascabuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Personal extends AppCompatActivity {

    String nom, cognoms, telefon, mail, adreça, genere, pais;
    private TextView tnom, tcognoms, ttelefon, tmail, tadreça, tgenere, tpais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        tnom = (TextView) findViewById(R.id.nom);
        tcognoms = (TextView) findViewById(R.id.cognoms);
        ttelefon = (TextView) findViewById(R.id.telefon);
        tmail = (TextView) findViewById(R.id.mail);
        tadreça = (TextView) findViewById(R.id.adreça);
        tgenere = (TextView) findViewById(R.id.genere);
        tpais = (TextView) findViewById(R.id.paises);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nom = extras.getString("nom");
            cognoms = extras.getString("cognoms");
            telefon = extras.getString("telefon");
            mail = extras.getString("mail");
            adreça = extras.getString("adreça");
            genere = extras.getString("genere");
            pais = extras.getString("pais");
        }
        tnom.setText(nom);
        tcognoms.setText(cognoms);
        ttelefon.setText(telefon);
        tmail.setText(mail);
        tadreça.setText(adreça);
        if (genere.equals("Hombre")){
            tgenere.setCompoundDrawablesWithIntrinsicBounds(R.drawable.hombre,0,0,0);
        }
        if (genere.equals("Mujer")){
            tgenere.setCompoundDrawablesWithIntrinsicBounds(R.drawable.communityicon_tks1dvhxz9h51,0,0,0);
        }
        if (genere.equals("Otros")){
            tgenere.setCompoundDrawablesWithIntrinsicBounds(R.drawable.otros,0,0,0);
        }
        if (pais.equals("España")){
            tpais.setCompoundDrawablesWithIntrinsicBounds(R.drawable.country_esp,0,0,0);
        }
        if (pais.equals("US")){
            tpais.setCompoundDrawablesWithIntrinsicBounds(R.drawable.us_united_states_flag_icon,0,0,0);
        }
        if (pais.equals("Francia")){
            tpais.setCompoundDrawablesWithIntrinsicBounds(R.drawable.country_fra,0,0,0);
        }
        if (pais.equals("Argentina")){
            tpais.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ar_argentina_flag_icon,0,0,0);
        }
        if(pais.equals("Cuba")){
            tpais.setCompoundDrawablesWithIntrinsicBounds(R.drawable.cuba,0,0,0);
        }
        ImageButton btn = (ImageButton)findViewById(R.id.flechass);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Personal.this, Reciclar.class);
                startActivity(intent);
            }
        });
    }
}