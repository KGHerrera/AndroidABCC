package com.example.androidabcc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import bd.EscuelaBD;

public class BajasActivity extends AppCompatActivity {
    EditText cajaID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajas);
    }

    public void eliminarRegistro(View v) {
        cajaID = findViewById(R.id.cajaControlBajas);

        if (!cajaID.getText().toString().equals("")) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        EscuelaBD bd = EscuelaBD.getAppDatabase(getBaseContext());
                        int resultado = bd.alumnoDAO().eliminarPorNumeroDeControl(cajaID.getText().toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (resultado == 1) {
                                    Toast.makeText(getBaseContext(), "se elimino correctamente", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getBaseContext(), "no se elimino el id no existe", Toast.LENGTH_LONG).show();
                                }
                            }
                        });

                    } catch (Exception exception) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(), "ocurrio un error", Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                }
            }).start();

        } else {
            Toast.makeText(getBaseContext(), "introduce el id", Toast.LENGTH_LONG).show();
        }
    }
}
