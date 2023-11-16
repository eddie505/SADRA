package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class feedcomedor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedcomedor);

        // Referenciar los elementos de la interfaz
        ImageButton enviar = findViewById(R.id.env);
        ImageButton mns = findViewById(R.id.mns);
        ImageButton info = findViewById(R.id.frutaimg);
        TextView nom = findViewById(R.id.nombre);
        ImageButton usu = findViewById(R.id.usuario);
        ImageButton mas = findViewById(R.id.mas);
        ImageButton like = findViewById(R.id.apar);

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar un mensaje indicando que los datos se han guardado
                showToast("¡Me gusta dado!");
            }
        });

        // Configurar OnClickListener para el botón Cancelar
        mns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad Mensajes
                Intent intent = new Intent(feedcomedor.this, logicachatcomedor.class);
                startActivity(intent);
            }
        });

        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad Agregar
                Intent intent = new Intent(feedcomedor.this, agregarcomedor.class);
                startActivity(intent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad Detalles
                Intent intent = new Intent(feedcomedor.this, detallescomedor.class);
                startActivity(intent);
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad Mensajes
                Intent intent = new Intent(feedcomedor.this, logicachatcomedor.class);
                startActivity(intent);
            }
        });

        nom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad MisPubli
                Intent intent = new Intent(feedcomedor.this, mispublicomedor.class);
                startActivity(intent);
            }
        });

        usu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad Perfil
                Intent intent = new Intent(feedcomedor.this, perfilcomedor.class);
                startActivity(intent);
            }
        });
    }

    // Método para mostrar un mensaje Toast
    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
