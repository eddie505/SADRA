package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class iniciosesioncomer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciosesioncomer);

        final Button registerButton = findViewById(R.id.registerButton);
        final Button iniciosesion = findViewById(R.id.iniciosesion);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear una intención para iniciar la actividad de registro
                Intent intent = new Intent(iniciosesioncomer.this, registrocomedor.class);
                startActivity(intent);
            }
        });
        iniciosesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear una intención para iniciar la actividad de registro
                Intent intent = new Intent(iniciosesioncomer.this, feedcomedor.class);
                startActivity(intent);
            }
        });
    }
}
