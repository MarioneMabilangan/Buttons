package com.example.tascabuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Resumen extends AppCompatActivity {

    String resumen, resumen2 = null;
    TextView text, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        text=(TextView) findViewById(R.id.textView6);
        text2=(TextView) findViewById(R.id.textView8);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            resumen = extras.getString("resumencheck");
            resumen2 = extras.getString("resumenradio");
        }
        text.setText(resumen);
        text2.setText(resumen2);
        ImageButton btn = (ImageButton)findViewById(R.id.flechas);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resumen.this, Formulario.class);
                startActivity(intent);
            }
        });
    }
}