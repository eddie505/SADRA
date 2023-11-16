package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class mispublicomedor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mispublicomedor);

        ImageButton home = findViewById(R.id.home);
        ImageButton mas = findViewById(R.id.mas);
        ImageButton mns = findViewById(R.id.mns);
        ImageButton editar = findViewById(R.id.edit);
        ImageButton usu = findViewById(R.id.usuario);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad feed
                Intent intent = new Intent(mispublicomedor.this, feedcomedor.class);
                startActivity(intent);
            }
        });

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad edit
                Intent intent = new Intent(mispublicomedor.this, editcomedor.class);
                startActivity(intent);
            }
        });

        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad agregar
                Intent intent = new Intent(mispublicomedor.this, agregarcomedor.class);
                startActivity(intent);
            }
        });

        mns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad mensajes
                Intent intent = new Intent(mispublicomedor.this, logicachatcomedor.class);
                startActivity(intent);
            }
        });

        usu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad perfil
                Intent intent = new Intent(mispublicomedor.this, perfilcomedor.class);
                startActivity(intent);
            }
        });
    }
}
