package com.example.biblio_mb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class OvidoClaveActivity extends AppCompatActivity {

    private EditText email;

    private TextView confirmacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovido_clave);
        confirmacion = findViewById(R.id.confirmacionPasos);
    }


    public void goToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void enviaPasos(View view) {
        confirmacion.setVisibility(View.VISIBLE);


    }





}