package com.example.intentdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private Button btnCallFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnCallFirst = findViewById(R.id.btnCallFirst);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value1 = extras.getString("Value1");
            String value2 = extras.getString("Value2");
            
            String message = "Recibido:\n" + value1 + "\n" + value2;
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }

        btnCallFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}