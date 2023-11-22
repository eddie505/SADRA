package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        // Referenciar el botón Cancelar
        Button cancelButton = findViewById(R.id.cancelar);
        // Referenciar el botón Registro
        Button registroButton = findViewById(R.id.registro);
        EditText mercadoEditText = findViewById(R.id.usuario);

        // Configurar OnClickListener para el botón Cancelar
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear una intención para volver a la actividad de inicio de sesión
                Intent intent = new Intent(registro.this, iniciosesion.class);
                startActivity(intent);
                finish();
            }
        });

        // Configurar OnClickListener para el botón Registro
        registroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener referencias a los EditText para correo y contraseña
                EditText emailEditText = findViewById(R.id.email);
                EditText passwordEditText = findViewById(R.id.password);
                EditText mercadoEditText = findViewById(R.id.usuario);

                // Obtener el texto ingresado por el usuario
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String nombreMercado = mercadoEditText.getText().toString().trim();

                // Validar que los campos no estén vacíos
                if (!email.isEmpty() && !password.isEmpty()) {
                    // Verificar si el correo ya está registrado
                    if (!isEmailRegistered(email)) {
                        // Guardar las credenciales en SharedPreferences
                        guardarCredenciales(email, password);

                        // Mostrar mensaje de éxito
                        Toast.makeText(registro.this, "Cuenta creada con éxito", Toast.LENGTH_SHORT).show();

                        // Iniciar sesión automáticamente después de registrarse
                        iniciarSesionAutomaticamente(email, password, nombreMercado);
                    } else {
                        // Mostrar mensaje de error si el correo ya está registrado
                        Toast.makeText(registro.this, "El correo ya está registrado", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Mostrar mensaje de error si algún campo está vacío
                    Toast.makeText(registro.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Función para guardar las credenciales en SharedPreferences
    private void guardarCredenciales(String email, String password) {
        SharedPreferences sharedPreferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();

        Log.d("GuardarCredenciales", "Credenciales guardadas - Email: " + email + ", Password: " + password);
    }

    // Función para iniciar sesión automáticamente después de registrarse
    private void iniciarSesionAutomaticamente(String email, String password, String nombreMercado) {
        // Crear una intención para ir a la actividad de inicio de sesión
        Intent intent = new Intent(registro.this, feed.class);
        // Pasar las credenciales y el nombre del mercado como extras
        intent.putExtra("email", email);
        intent.putExtra("password", password);
        intent.putExtra("nombreMercado", nombreMercado);
        // Iniciar la actividad de inicio de sesión
        startActivity(intent);
        // Finalizar la actividad actual para que no quede en la pila
        finish();
    }

    // Función para verificar si el correo ya está registrado
    private boolean isEmailRegistered(String email) {
        SharedPreferences sharedPreferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        String savedEmail = sharedPreferences.getString("email", "");
        return email.equals(savedEmail);
    }
}
