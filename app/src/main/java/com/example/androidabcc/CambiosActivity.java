package com.example.androidabcc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import bd.EscuelaBD;
import entidades.Alumno;

public class CambiosActivity extends AppCompatActivity {
    Alumno alumno = new Alumno();
    EditText cajaID, cajaNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambios);
    }

    public void modificarRegistro(View v) {

        cajaID = findViewById(R.id.cajaControlCambios);
        cajaNombre = findViewById(R.id.cajaNombreCambios);


        boolean isCajaID = !cajaID.getText().toString().equals("");
        boolean isCajaNombre = !cajaNombre.getText().toString().equals("");


        if (isCajaID && isCajaNombre) {

            alumno.setNunControl(cajaID.getText().toString());
            alumno.setNombre(cajaNombre.getText().toString());


            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        EscuelaBD bd = EscuelaBD.getAppDatabase(getBaseContext());
                        int resultado = bd.alumnoDAO().modificarPorNumeroDeControl(alumno.getNunControl(), alumno.getNombre());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (resultado == 1) {
                                    Toast.makeText(getBaseContext(), "se modifico correctamente", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getBaseContext(), "no se modifico el id no existe", Toast.LENGTH_LONG).show();
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
            Toast.makeText(getBaseContext(), "faltan datos", Toast.LENGTH_LONG).show();
        }
    }

}
