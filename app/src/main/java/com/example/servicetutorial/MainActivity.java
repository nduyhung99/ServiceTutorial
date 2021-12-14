package com.example.servicetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnStartService, btnStopService;
    EditText edtDataIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStartService = findViewById(R.id.btnStartService);
        btnStopService = findViewById(R.id.btnStopService);
        edtDataIntent = findViewById(R.id.edtDataIntent);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStartService();
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStopService();
            }
        });
    }

    private void clickStopService() {
        Intent intent = new Intent(MainActivity.this,MyService.class);
        stopService(intent);
    }

    private void clickStartService() {
        Intent intent = new Intent(MainActivity.this,MyService.class);
        intent.putExtra("key data intent", edtDataIntent.getText().toString().trim());
        startService(intent);
    }
}