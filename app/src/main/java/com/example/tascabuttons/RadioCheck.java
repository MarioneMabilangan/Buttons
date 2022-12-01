package com.example.tascabuttons;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RadioCheck extends AppCompatActivity {
    Button button;
    RadioButton genderradioButton;
    RadioGroup radioGroup;
    CheckBox cb1, cb2,cb3;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_check);
        radioGroup=(RadioGroup)findViewById(R.id.grbGrup1);
        cb1=(CheckBox)findViewById(R.id.checkBox);
        cb2=(CheckBox)findViewById(R.id.checkBox2);
        cb3=(CheckBox)findViewById(R.id.checkBox3);
        text=(TextView) findViewById(R.id.textView);
    }
    public void onclickbuttonMethod(View v){
        int selectedId = radioGroup.getCheckedRadioButtonId();
        genderradioButton = (RadioButton) findViewById(selectedId);
        Intent i = new Intent(RadioCheck.this, Resumen.class);

        if(selectedId==-1){
            i.putExtra("resumenradio","No radio");
            Toast.makeText(RadioCheck.this,"No radio", Toast.LENGTH_SHORT).show();
            if(cb1.isChecked() && cb2.isChecked() && cb3.isChecked()){
                i.putExtra("resumencheck","opcio 1, 2 i 3");
                startActivity(i);
                text.setText("opcio 1, 2 i 3");
            }else if(cb1.isChecked() && cb2.isChecked()){
                i.putExtra("resumencheck","opcio 1 i 2");
                startActivity(i);
                text.setText("opcio 1 i 2");
            }else if(cb1.isChecked() && cb3.isChecked()){
                i.putExtra("resumencheck","opcio 1 i 3");
                startActivity(i);
                text.setText("opcio 1 i 3");
            }else if(cb2.isChecked() && cb3.isChecked()){
                i.putExtra("resumencheck","opcio 2 i 3");
                startActivity(i);
                text.setText("opcio 2 i 3");
            }
            else if(cb1.isChecked()){
                i.putExtra("resumencheck","opcio 1");
                startActivity(i);
                text.setText("opcio 1");
            }else if(cb2.isChecked()){
                i.putExtra("resumencheck","opcio 2");
                startActivity(i);
                text.setText("opcio 2");
            }else if(cb3.isChecked()){
                i.putExtra("resumencheck","opcio 3");
                startActivity(i);
                text.setText("opcio 3");
            }else{
                i.putExtra("resumencheck","No opcions");
                startActivity(i);
                text.setText("No opcions");
            }
        }
        else{
            i.putExtra("resumenradio", genderradioButton.getText());
           Toast.makeText(RadioCheck.this,genderradioButton.getText(), Toast.LENGTH_SHORT).show();
            if(cb1.isChecked() && cb2.isChecked() && cb3.isChecked()){
                i.putExtra("resumencheck","opcio 1, 2 i 3");
                startActivity(i);
                text.setText("opcio 1, 2 i 3");
            }else if(cb1.isChecked() && cb2.isChecked()){
                i.putExtra("resumencheck","opcio 1 i 2");
                startActivity(i);
                text.setText("opcio 1 i 2");
            }else if(cb1.isChecked() && cb3.isChecked()){
                i.putExtra("resumencheck","opcio 1 i 3");
                startActivity(i);
                text.setText("opcio 1 i 3");
            }else if(cb2.isChecked() && cb3.isChecked()){
                i.putExtra("resumencheck","opcio 2 i 3");
                startActivity(i);
                text.setText("opcio 2 i 3");
            }
            else if(cb1.isChecked()){
                i.putExtra("resumencheck","opcio 1");
                startActivity(i);
                text.setText("opcio 1");
            }else if(cb2.isChecked()){
                i.putExtra("resumencheck","opcio 2");
                startActivity(i);
                text.setText("opcio 2");
            }else if(cb3.isChecked()){
                i.putExtra("resumencheck","opcio 3");
                startActivity(i);
                text.setText("opcio 3");
            }else{
                i.putExtra("resumencheck","No opcions");
                startActivity(i);
                text.setText("No opcions");
            }
        }
    }
}