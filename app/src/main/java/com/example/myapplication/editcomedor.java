package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class editcomedor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editcomedor);

        Button listo = findViewById(R.id.terminar);
        Button cancel = findViewById(R.id.cancelar);

        listo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad MisPubliActivity
                Intent intent = new Intent(editcomedor.this, mispublicomedor.class);
                startActivity(intent);

                // Mostrar un mensaje indicando que los datos se han guardado
                showToast("Datos guardados");
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad MisPubliActivity
                Intent intent = new Intent(editcomedor.this, mispublicomedor.class);
                startActivity(intent);
            }
        });
    }

    // Método para mostrar un mensaje Toast
    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
