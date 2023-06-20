package com.example.biblio_mb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goToLogin(View view) {

        //Evento onClick -  Muestra string en consola LOGCAT
        Log.d(LOG_TAG, "¡Botón presionado!");

        //Creamos el intent y le decimos de donde partimos y a donde vamos.
        Intent intent = new Intent(this, LoginActivity.class);

        //Llamamos al mètodo que inicia la otra actividad.
        startActivity(intent);
    }


    public void goToInfo(View view) {

        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }
}