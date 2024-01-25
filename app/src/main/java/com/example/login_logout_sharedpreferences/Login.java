package com.example.login_logout_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText et1, et2;
    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

        SharedPreferences preferences = this.getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        findViewById(R.id.btnEntrar).setOnClickListener(v -> {
            SharedPreferences preferences1 = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences1.edit();
            editor.putString("user", et1.getText().toString());
            editor.putString("pass", et2.getText().toString());
            editor.commit();
            Toast.makeText(getApplicationContext(), "Credenciales guardadas", Toast.LENGTH_SHORT).show();

            if (et1.getText().toString().equals("") || et2.getText().toString().equals("")) {
                Toast.makeText(this, "ERROR FATAL, es obligatorio introducir credenciales", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Verificar si hay credenciales almacenadas
        if (preferences.contains("user") && preferences.contains("pass")) {
            // Si hay credenciales iniciar directamente MainActivity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }
}