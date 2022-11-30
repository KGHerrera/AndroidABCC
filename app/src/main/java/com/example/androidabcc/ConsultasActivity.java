package com.example.androidabcc;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bd.EscuelaBD;
import entidades.Alumno;

public class ConsultasActivity extends AppCompatActivity {
    List<Alumno> elementos;
    EditText cajaNombre, cajaID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);


        new Thread(new Runnable() {
            @Override
            public void run() {
                EscuelaBD bd = EscuelaBD.getAppDatabase(getBaseContext());
                elementos = bd.alumnoDAO().obtenerTodos();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ListAdapter listAdapter = new ListAdapter(elementos, getBaseContext());
                        RecyclerView recyclerView = findViewById(R.id.listaAlumnos);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                        recyclerView.setAdapter(listAdapter);
                    }
                });
            }
        }).start();

        cajaNombre = findViewById(R.id.cajaNombreConsultas);

        cajaNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        EscuelaBD bd = EscuelaBD.getAppDatabase(getBaseContext());
                        elementos = bd.alumnoDAO().findByNombre("%"+ cajaNombre.getText().toString() + "%");

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ListAdapter listAdapter = new ListAdapter(elementos, getBaseContext());
                                RecyclerView recyclerView = findViewById(R.id.listaAlumnos);
                                recyclerView.setHasFixedSize(true);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                                recyclerView.setAdapter(listAdapter);
                            }
                        });
                    }
                }).start();

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        cajaID = findViewById(R.id.cajaControlConsultas);

        cajaID.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        EscuelaBD bd = EscuelaBD.getAppDatabase(getBaseContext());
                        elementos = bd.alumnoDAO().findByNumControl("%"+ cajaID.getText().toString() + "%");

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ListAdapter listAdapter = new ListAdapter(elementos, getBaseContext());
                                RecyclerView recyclerView = findViewById(R.id.listaAlumnos);
                                recyclerView.setHasFixedSize(true);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                                recyclerView.setAdapter(listAdapter);
                            }
                        });
                    }
                }).start();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


}
