package com.example.androidabcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirAltas(View v){
        Intent intent = new Intent(MainActivity.this, AltasActivity.class);
        startActivity(intent);
    }

    public void abrirBajas(View v){
        Intent intent = new Intent(MainActivity.this, BajasActivity.class);
        startActivity(intent);
    }
    public void abrirCambios(View v){
        Intent intent = new Intent(MainActivity.this, CambiosActivity.class);
        startActivity(intent);
    }
    public void abrirConsultas(View v){
        Intent intent = new Intent(MainActivity.this, ConsultasActivity.class);
        startActivity(intent);
    }
}