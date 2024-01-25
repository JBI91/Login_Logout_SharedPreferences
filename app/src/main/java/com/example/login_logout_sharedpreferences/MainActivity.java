package com.example.login_logout_sharedpreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {

    private MaterialToolbar mtool;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(findViewById(R.id.mtool));

        tv1 = findViewById(R.id.tv1);

        // Recuperar las credenciales almacenadas en SharedPreferences
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String usuario = preferences.getString("user", "");
        String pass = preferences.getString("pass", "");

        tv1.setText("Bienvenido, " + usuario);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_out) {
            // Eliminar las credenciales almacenadas
            SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.apply();

            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}