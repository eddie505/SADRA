package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        Button mercadoButton = findViewById(R.id.merca);
        Button comedor = findViewById(R.id.come);

        mercadoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cuando se hace clic en el botón, iniciar la actividad iniciosesion
                Intent intent = new Intent(inicio.this, iniciosesion.class);
                startActivity(intent);
            }
        });
        comedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cuando se hace clic en el botón, iniciar la actividad iniciosesion
                Intent intent = new Intent(inicio.this, iniciosesioncomer.class);
                startActivity(intent);
            }
        });
    }
}
