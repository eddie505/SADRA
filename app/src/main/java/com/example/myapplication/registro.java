package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        // Referenciar el botón Cancelar
        Button cancelButton = findViewById(R.id.cancelar);
        Button registro = findViewById(R.id.registro);
        // Configurar un OnClickListener para el botón Cancelar
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear una intención para volver a la actividad de inicio de sesión
                Intent intent = new Intent(registro.this, iniciosesion.class);
                startActivity(intent);
                finish();  // Finalizar la actividad actual para que no quede en la pila
            }
        });
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear una intención para volver a la actividad de feed
                Intent intent = new Intent(registro.this, feed.class);
                startActivity(intent);
                finish();  // Finalizar la actividad actual para que no quede en la pila
            }
        });
        // Puedes agregar más lógica aquí según sea necesario
    }
}
