package com.example.intentdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etUrl;
    private Button btnVisit;
    private Button btnCallSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización de las vistas desde el layout XML
        etUrl = findViewById(R.id.etUrl);
        btnVisit = findViewById(R.id.btnVisit);
        btnCallSecond = findViewById(R.id.btnCallSecond);

        // Configuración del botón para el Intent Implícito (Navegador Web)
        btnVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = etUrl.getText().toString().trim();
                
                if (!url.isEmpty()) {
                    // Verificamos que la URL contenga un protocolo HTTP válido
                    if (!url.startsWith("http://") && !url.startsWith("https://")) {
                        url = "https://" + url;
                    }
                    
                    // Creamos un Intent Implícito para que el sistema abra un navegador web
                    Intent implicitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(implicitIntent);
                } else {
                    // Mostramos un mensaje de advertencia sacado de strings.xml
                    Toast.makeText(MainActivity.this, getString(R.string.empty_url_warning), Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configuración del botón para el Intent Explícito (Pasar a otra Activity)
        btnCallSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creamos un Intent Explícito apuntando directamente a SecondActivity
                Intent explicitIntent = new Intent(MainActivity.this, SecondActivity.class);
                
                // Pasamos parámetros (extras) hacia la nueva actividad
                explicitIntent.putExtra("Value1", "Android By Javatpoint");
                explicitIntent.putExtra("Value2", "Simple Tutorial");
                
                startActivity(explicitIntent);
            }
        });
    }
}