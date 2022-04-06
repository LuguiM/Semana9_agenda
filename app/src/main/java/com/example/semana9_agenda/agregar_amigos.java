package com.example.semana9_agenda;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;



import android.view.View;

import android.widget.Button;
import android.widget.TextView;

import android.widget.Toast;


public class agregar_amigos extends AppCompatActivity {
    BD usuarios;

    String accion="nuevo";

    String id="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_amigos);
        mostrardatos();


        Button info = findViewById(R.id.btBase2);
        info.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), vista.class);
                startActivityForResult(intent, 0);
            }
        });

    }
    public void mostrardatos(){

        try {

            Bundle bundle = getIntent().getExtras();

            accion = bundle.getString("accion");

            if (accion.equals("modificar")) {

                id = String.valueOf(bundle.getInt("id"));



                String[] user = bundle.getStringArray("user");



                TextView tempVal = (TextView) findViewById(R.id.txtnombre);

                tempVal.setText(user[0]);



                tempVal = (TextView) findViewById(R.id.txtdireccion);

                tempVal.setText(user[1]);



                tempVal = (TextView) findViewById(R.id.txtTelefono);

                tempVal.setText(user[2]);

            }

        }catch (Exception e){

            Toast.makeText(agregar_amigos.this, "Error:12 "+ e.getMessage(), Toast.LENGTH_LONG).show();

        }

    }



    public void guardar_amigo(View v){

        try{

            TextView tempVal = (TextView)findViewById(R.id.txtnombre);

            String nom = tempVal.getText().toString();



            tempVal = (TextView)findViewById(R.id.txtdireccion);

            String dir = tempVal.getText().toString();



            tempVal = (TextView)findViewById(R.id.txtTelefono);

            String tel = tempVal.getText().toString();



            usuarios = new BD(agregar_amigos.this, "",null,1);

            usuarios.guardarUsuarios(nom, dir, tel, accion, id);



            Toast.makeText(agregar_amigos.this, "Listo, amigo registrado con exito", Toast.LENGTH_LONG).show();



                    Intent imostrar= new Intent(agregar_amigos.this, MainActivity.class);

            startActivity(imostrar);

        }catch(Exception ex){

            Toast.makeText(agregar_amigos.this, "Error1: "+

                    ex.getMessage(), Toast.LENGTH_LONG).show();

        }

    }

}
