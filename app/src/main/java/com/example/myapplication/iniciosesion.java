package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class iniciosesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciosesion);

        final Button registerButton = findViewById(R.id.registerButton);
        final Button iniciosesionButton = findViewById(R.id.iniciosesion);

        iniciosesionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener referencias a los EditText para correo y contraseña
                EditText emailEditText = findViewById(R.id.emailEditText);
                EditText passwordEditText = findViewById(R.id.passwordEditText);

                // Obtener el texto ingresado por el usuario
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Realizar la validación
                String validationMessage = validateCredentials(email, password);

                if ("OK".equals(validationMessage)) {
                    // Verificar si las credenciales están registradas antes de permitir el inicio de sesión
                    if (credencialesRegistradas(email, password)) {
                        // Las credenciales son válidas, iniciar la actividad 'feed'
                        Intent intent = new Intent(iniciosesion.this, feed.class);
                        intent.putExtra("nombreMercado", "Nombre del Mercado");
                        startActivity(intent);

                    } else {
                        Toast.makeText(iniciosesion.this, "La cuenta no está registrada", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Mostrar un mensaje de error en caso de datos no válidos
                    Toast.makeText(iniciosesion.this, validationMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear una intención para iniciar la actividad de registro
                Intent intent = new Intent(iniciosesion.this, registro.class);
                startActivity(intent);
            }
        });
    }

    // Función para validar el formato del correo electrónico
    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    // Función para validar la contraseña (con requisitos adicionales)
    private String validateCredentials(String email, String password) {
        // Realizar la validación del correo electrónico
        if (!isValidEmail(email)) {
            return "Correo no válido";
        }

        // Realizar la validación de la contraseña
        return isValidPassword(password);
    }

    // Función para validar la contraseña (con requisitos adicionales)
    private String isValidPassword(String password) {
        // Requerir una longitud mínima de 8 caracteres
        if (password.length() < 8) {
            return "La contraseña debe tener al menos 8 caracteres.";
        }

        // Requerir al menos una mayúscula
        if (!password.matches(".*[A-Z].*")) {
            return "La contraseña debe contener al menos una letra mayúscula.";
        }

        // Requerir al menos un carácter especial
        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            return "La contraseña debe contener al menos un carácter especial.";
        }

        // Requerir al menos un número y no permitir cadenas de números (por ejemplo, "123")
        if (!password.matches(".*\\d.*") || password.matches(".*\\d{3,}.*")) {
            return "La contraseña debe contener al menos un número y no puede tener cadenas de números.";
        }

        // No permitir caracteres especiales en la contraseña
        if (!password.matches("[a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+")) {
            return "La contraseña solo puede contener letras, números y los siguientes caracteres especiales: !@#$%^&*()_+-=[]{};':\"\\|,.<>/?";
        }

        // Todas las condiciones cumplidas, la contraseña es válida
        return "OK";
    }

    // Función para verificar si las credenciales ya están registradas
    private boolean credencialesRegistradas(String email, String password) {
        // Obtener referencias a las credenciales almacenadas en SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        // Verificar si el email ya está registrado y la contraseña coincide
        return email.equals(sharedPreferences.getString("email", ""))
                && password.equals(sharedPreferences.getString("password", ""));
    }
}
