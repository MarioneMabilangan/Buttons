package com.example.tascabuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Formulario extends AppCompatActivity {
    private EditText nom, cognoms, telefon, mail, adreça;
    private Spinner spinner;
    String[] listviewTitle = new String[]{
            "España", "America", "Francia", "Argentina","Cuba"
    };
    int[] listviewImage = new int[]{
            R.drawable.country_esp, R.drawable.us_united_states_flag_icon, R.drawable.country_fra, R.drawable.ar_argentina_flag_icon, R.drawable.cuba
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.valores_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 5; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }
        String[] from = {"listview_image", "listview_title"};
        int[] to = {R.id.listview_image, R.id.listview_item_title};
        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview, from, to);
        ListView androidListView = (ListView) findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);
        nom=(EditText) findViewById(R.id.enom);
        cognoms=(EditText) findViewById(R.id.cognoms);
        telefon=(EditText) findViewById(R.id.telefon);
        mail=(EditText) findViewById(R.id.mail);
        adreça=(EditText) findViewById(R.id.adreça);
        nom.setHint(Html.fromHtml("nom de " + "<b>" +"usuari" + "<b>"));
        cognoms.setHint(Html.fromHtml(""+"<b>" +"cognoms" + "<b>" +" del nom"));
        telefon.setHint(Html.fromHtml(""+"<b>" +"tèlefon"+ "<b>" + " mòbil"));
        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
                String value = String.valueOf(adapterView.getItemAtPosition(position));
                System.out.println(value);
                if (value.equals("{listview_image=2131165413, listview_title=España}")){
                    validarESP(adapterView);
                }
                if(value.equals("{listview_image=2131165415, listview_title=America}")){
                    validarUS(adapterView);
                }
                if(value.equals("{listview_image=2131165414, listview_title=Francia}")){
                    validarFR(adapterView);
                }
                if(value.equals("{listview_image=2131165412, listview_title=Argentina}")){
                    validarAR(adapterView);
                }if(value.equals("{listview_image=2131165416, listview_title=Cuba}")) {
                    validarCU(adapterView);
                }
            }
        });
        }

    public void validarESP(View v){

        Intent i = new Intent(Formulario.this, Personal.class);
        Intent i2 = new Intent(Formulario.this, Resumen.class);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Protecció de dades..!!!");
        alertDialogBuilder.setIcon(R.drawable.xsdsdafas);
        alertDialogBuilder.setMessage(Html.fromHtml("La" + "<b>" +" protecció de dades"+"</b>" +" personals és el conjunt de tècniques jurídiques i informàtiques encaminades a garantir els drets de les persones sobre el control de la seva " + "<b>" +"informació personal"+"</b>" +" i sobre la confidencialitat, integritat i disponibilitat d'aquesta."));
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Accepto", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                i.putExtra("nom",nom.getText().toString());
                i.putExtra("cognoms",cognoms.getText().toString());
                i.putExtra("telefon",telefon.getText().toString());
                i.putExtra("mail",mail.getText().toString());
                i.putExtra("adreça",adreça.getText().toString());
                i.putExtra("genere", spinner.getSelectedItem().toString());
                i.putExtra("pais","España");
                startActivity(i);
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Formulario.this,"No has acceptat la protecció de dades",Toast.LENGTH_SHORT).show();
                startActivity(i2);
            }
        });
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Has cancelat",Toast.LENGTH_SHORT).show();
            }
        });
        if(nom.getText().toString().isEmpty()){
            Toast.makeText(this,"nom buit", Toast.LENGTH_LONG).show();
        }else{
            if(cognoms.getText().toString().isEmpty()){
                Toast.makeText(this,"cognoms buit", Toast.LENGTH_LONG).show();
            }else{
                if(telefon.getText().toString().isEmpty()){
                    Toast.makeText(this,"telefon buit", Toast.LENGTH_LONG).show();
                }else{
                    if(mail.getText().toString().isEmpty()){
                        Toast.makeText(this,"mail buit", Toast.LENGTH_LONG).show();
                    }else{
                        if(adreça.getText().toString().isEmpty()){
                            Toast.makeText(this,"adreça buit", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(this,"Formulari complet!", Toast.LENGTH_LONG).show();
                            AlertDialog alertDialog = alertDialogBuilder.create();
                            alertDialog.show();
                        }
                    }
                }
            }
        }
    }
    public void validarUS(View v){

        Intent i = new Intent(Formulario.this, Personal.class);
        Intent i2 = new Intent(Formulario.this, Resumen.class);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Protecció de dades..!!!");
        alertDialogBuilder.setIcon(R.drawable.xsdsdafas);
        alertDialogBuilder.setMessage(Html.fromHtml("La" + "<b>" +" protecció de dades"+"</b>" +" personals és el conjunt de tècniques jurídiques i informàtiques encaminades a garantir els drets de les persones sobre el control de la seva " + "<b>" +"informació personal"+"</b>" +" i sobre la confidencialitat, integritat i disponibilitat d'aquesta."));
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Accepto", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                i.putExtra("nom",nom.getText().toString());
                i.putExtra("cognoms",cognoms.getText().toString());
                i.putExtra("telefon",telefon.getText().toString());
                i.putExtra("mail",mail.getText().toString());
                i.putExtra("adreça",adreça.getText().toString());
                i.putExtra("genere", spinner.getSelectedItem().toString());
                i.putExtra("pais","US");
                startActivity(i);
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Formulario.this,"No has acceptat la protecció de dades",Toast.LENGTH_SHORT).show();
                startActivity(i2);
            }
        });
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Has cancelat",Toast.LENGTH_SHORT).show();
            }
        });
        if(nom.getText().toString().isEmpty()){
            Toast.makeText(this,"nom buit", Toast.LENGTH_LONG).show();
        }else{
            if(cognoms.getText().toString().isEmpty()){
                Toast.makeText(this,"cognoms buit", Toast.LENGTH_LONG).show();
            }else{
                if(telefon.getText().toString().isEmpty()){
                    Toast.makeText(this,"telefon buit", Toast.LENGTH_LONG).show();
                }else{
                    if(mail.getText().toString().isEmpty()){
                        Toast.makeText(this,"mail buit", Toast.LENGTH_LONG).show();
                    }else{
                        if(adreça.getText().toString().isEmpty()){
                            Toast.makeText(this,"adreça buit", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(this,"Formulari complet!", Toast.LENGTH_LONG).show();
                            AlertDialog alertDialog = alertDialogBuilder.create();
                            alertDialog.show();
                        }
                    }
                }
            }
        }
    }
    public void validarFR(View v){

        Intent i = new Intent(Formulario.this, Personal.class);
        Intent i2 = new Intent(Formulario.this, Resumen.class);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Protecció de dades..!!!");
        alertDialogBuilder.setIcon(R.drawable.xsdsdafas);
        alertDialogBuilder.setMessage(Html.fromHtml("La" + "<b>" +" protecció de dades"+"</b>" +" personals és el conjunt de tècniques jurídiques i informàtiques encaminades a garantir els drets de les persones sobre el control de la seva " + "<b>" +"informació personal"+"</b>" +" i sobre la confidencialitat, integritat i disponibilitat d'aquesta."));
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Accepto", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                i.putExtra("nom",nom.getText().toString());
                i.putExtra("cognoms",cognoms.getText().toString());
                i.putExtra("telefon",telefon.getText().toString());
                i.putExtra("mail",mail.getText().toString());
                i.putExtra("adreça",adreça.getText().toString());
                i.putExtra("genere", spinner.getSelectedItem().toString());
                i.putExtra("pais","Francia");
                startActivity(i);
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Formulario.this,"No has acceptat la protecció de dades",Toast.LENGTH_SHORT).show();
                startActivity(i2);
            }
        });
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Has cancelat",Toast.LENGTH_SHORT).show();
            }
        });
        if(nom.getText().toString().isEmpty()){
            Toast.makeText(this,"nom buit", Toast.LENGTH_LONG).show();
        }else{
            if(cognoms.getText().toString().isEmpty()){
                Toast.makeText(this,"cognoms buit", Toast.LENGTH_LONG).show();
            }else{
                if(telefon.getText().toString().isEmpty()){
                    Toast.makeText(this,"telefon buit", Toast.LENGTH_LONG).show();
                }else{
                    if(mail.getText().toString().isEmpty()){
                        Toast.makeText(this,"mail buit", Toast.LENGTH_LONG).show();
                    }else{
                        if(adreça.getText().toString().isEmpty()){
                            Toast.makeText(this,"adreça buit", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(this,"Formulari complet!", Toast.LENGTH_LONG).show();
                            AlertDialog alertDialog = alertDialogBuilder.create();
                            alertDialog.show();
                        }
                    }
                }
            }
        }
    }
    public void validarAR(View v){

        Intent i = new Intent(Formulario.this, Personal.class);
        Intent i2 = new Intent(Formulario.this, Resumen.class);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Protecció de dades..!!!");
        alertDialogBuilder.setIcon(R.drawable.xsdsdafas);
        alertDialogBuilder.setMessage(Html.fromHtml("La" + "<b>" +" protecció de dades"+"</b>" +" personals és el conjunt de tècniques jurídiques i informàtiques encaminades a garantir els drets de les persones sobre el control de la seva " + "<b>" +"informació personal"+"</b>" +" i sobre la confidencialitat, integritat i disponibilitat d'aquesta."));
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Accepto", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                i.putExtra("nom",nom.getText().toString());
                i.putExtra("cognoms",cognoms.getText().toString());
                i.putExtra("telefon",telefon.getText().toString());
                i.putExtra("mail",mail.getText().toString());
                i.putExtra("adreça",adreça.getText().toString());
                i.putExtra("genere", spinner.getSelectedItem().toString());
                i.putExtra("pais","Argentina");
                startActivity(i);
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Formulario.this,"No has acceptat la protecció de dades",Toast.LENGTH_SHORT).show();
                startActivity(i2);
            }
        });
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Has cancelat",Toast.LENGTH_SHORT).show();
            }
        });
        if(nom.getText().toString().isEmpty()){
            Toast.makeText(this,"nom buit", Toast.LENGTH_LONG).show();
        }else{
            if(cognoms.getText().toString().isEmpty()){
                Toast.makeText(this,"cognoms buit", Toast.LENGTH_LONG).show();
            }else{
                if(telefon.getText().toString().isEmpty()){
                    Toast.makeText(this,"telefon buit", Toast.LENGTH_LONG).show();
                }else{
                    if(mail.getText().toString().isEmpty()){
                        Toast.makeText(this,"mail buit", Toast.LENGTH_LONG).show();
                    }else{
                        if(adreça.getText().toString().isEmpty()){
                            Toast.makeText(this,"adreça buit", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(this,"Formulari complet!", Toast.LENGTH_LONG).show();
                            AlertDialog alertDialog = alertDialogBuilder.create();
                            alertDialog.show();
                        }
                    }
                }
            }
        }
    }
    public void validarCU(View v){

        Intent i = new Intent(Formulario.this, Personal.class);
        Intent i2 = new Intent(Formulario.this, Resumen.class);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Protecció de dades..!!!");
        alertDialogBuilder.setIcon(R.drawable.xsdsdafas);
        alertDialogBuilder.setMessage(Html.fromHtml("La" + "<b>" +" protecció de dades"+"</b>" +" personals és el conjunt de tècniques jurídiques i informàtiques encaminades a garantir els drets de les persones sobre el control de la seva " + "<b>" +"informació personal"+"</b>" +" i sobre la confidencialitat, integritat i disponibilitat d'aquesta."));
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Accepto", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                i.putExtra("nom",nom.getText().toString());
                i.putExtra("cognoms",cognoms.getText().toString());
                i.putExtra("telefon",telefon.getText().toString());
                i.putExtra("mail",mail.getText().toString());
                i.putExtra("adreça",adreça.getText().toString());
                i.putExtra("genere", spinner.getSelectedItem().toString());
                i.putExtra("pais","Cuba");
                startActivity(i);
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Formulario.this,"No has acceptat la protecció de dades",Toast.LENGTH_SHORT).show();
                startActivity(i2);
            }
        });
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Has cancelat",Toast.LENGTH_SHORT).show();
            }
        });
        if(nom.getText().toString().isEmpty()){
            Toast.makeText(this,"nom buit", Toast.LENGTH_LONG).show();
        }else{
            if(cognoms.getText().toString().isEmpty()){
                Toast.makeText(this,"cognoms buit", Toast.LENGTH_LONG).show();
            }else{
                if(telefon.getText().toString().isEmpty()){
                    Toast.makeText(this,"telefon buit", Toast.LENGTH_LONG).show();
                }else{
                    if(mail.getText().toString().isEmpty()){
                        Toast.makeText(this,"mail buit", Toast.LENGTH_LONG).show();
                    }else{
                        if(adreça.getText().toString().isEmpty()){
                            Toast.makeText(this,"adreça buit", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(this,"Formulari complet!", Toast.LENGTH_LONG).show();
                            AlertDialog alertDialog = alertDialogBuilder.create();
                            alertDialog.show();
                        }
                    }
                }
            }
        }
    }
}