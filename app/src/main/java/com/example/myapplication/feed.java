package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class feed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);

        // Obtener el nombre del extra
        String nombreMercado = getIntent().getStringExtra("nombreMercado");

        // Referenciar el TextView
        TextView nombreTextView = findViewById(R.id.nombre);

        // Verificar si el nombre del mercado no es nulo
        if (nombreMercado != null) {
            // Establecer el nombre en el TextView
            nombreTextView.setText("Comedor '" + nombreMercado + "'");
        }

        // Referenciar los elementos de la interfaz
        ImageButton enviar = findViewById(R.id.env);
        ImageButton mns = findViewById(R.id.mns);
        ImageButton info = findViewById(R.id.frutaimg);
        ImageButton usu = findViewById(R.id.usuarioimg);
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
                Intent intent = new Intent(feed.this, logicachatcomedor.class);
                startActivity(intent);
            }
        });

        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad Agregar
                Intent intent = new Intent(feed.this, agregar.class);
                startActivity(intent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad Detalles
                Intent intent = new Intent(feed.this, detalles.class);
                startActivity(intent);
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad Mensajes
                Intent intent = new Intent(feed.this, logicachat.class);
                startActivity(intent);
            }
        });

        usu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad Perfil
                Intent intent = new Intent(feed.this, perfil.class);
                startActivity(intent);
            }
        });
    }

    // Método para mostrar un mensaje Toast
    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
