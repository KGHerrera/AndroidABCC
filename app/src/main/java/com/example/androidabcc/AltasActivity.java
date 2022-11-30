package com.example.androidabcc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import bd.EscuelaBD;
import entidades.Alumno;

public class AltasActivity extends AppCompatActivity {
    Alumno alumno = new Alumno();
    EditText cajaID, cajaNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altas);
    }

    public void agregarRegistro(View v) {

        cajaID = findViewById(R.id.cajaControlAltas);
        cajaNombre = findViewById(R.id.cajaNombreAltas);


        boolean isCajaID = !cajaID.getText().toString().equals("");
        boolean isCajaNombre = !cajaNombre.getText().toString().equals("");

        if(isCajaID && isCajaNombre){

            alumno.setNombre(cajaNombre.getText().toString());
            alumno.setNunControl(cajaID.getText().toString());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        EscuelaBD bd = EscuelaBD.getAppDatabase(getBaseContext());
                        bd.alumnoDAO().agregarAlumno(alumno);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(), "agregado correctamente", Toast.LENGTH_LONG).show();
                            }
                        });
                    } catch (Exception exception){
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
            Toast.makeText(getBaseContext(), "faltan datos", Toast.LENGTH_LONG).show();
        }
    }
}
