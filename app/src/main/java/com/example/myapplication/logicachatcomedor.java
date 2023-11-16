package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class logicachatcomedor extends AppCompatActivity {

    private ListView listView;
    private EditText editTextMessage;
    private Button buttonSendMessage;
    private List<mensajes> messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mensajescomedor);

        // Inicializar tus vistas y lista de mensajes
        listView = findViewById(R.id.listView);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSendMessage = findViewById(R.id.buttonSendMessage);
        messageList = new ArrayList<>();

        // Aquí puedes agregar lógica adicional según sea necesario

        // Por ejemplo, agregar un Listener al botón "Enviar"
        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes agregar lógica para enviar el mensaje
            }
        });
    }

}
