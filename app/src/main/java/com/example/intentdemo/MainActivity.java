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

        etUrl = findViewById(R.id.etUrl);
        btnVisit = findViewById(R.id.btnVisit);
        btnCallSecond = findViewById(R.id.btnCallSecond);

        btnVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = etUrl.getText().toString().trim();
                
                if (!url.isEmpty()) {
                    if (!url.startsWith("http://") && !url.startsWith("https://")) {
                        url = "https://" + url;
                    }
                    
                    Intent implicitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(implicitIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, ingresa una URL", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCallSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicitIntent = new Intent(MainActivity.this, SecondActivity.class);
                explicitIntent.putExtra("Value1", "Android By Javatpoint");
                explicitIntent.putExtra("Value2", "Simple Tutorial");
                startActivity(explicitIntent);
            }
        });
    }
}