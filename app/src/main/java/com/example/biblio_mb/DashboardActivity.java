package com.example.biblio_mb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {

    Button btnLibros;
    Usuario u;
    daoUsuario dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btnLibros = findViewById(R.id.button_libros);


     //   String user = getIntent().getStringExtra("USUARIO");
      //  Toast.makeText(this, "Ha iniciado, user Nª " + user,  Toast.LENGTH_LONG).show();

    }

    public void logout(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void goToLibros(View view) {
        Intent intent = new Intent(this, LibrosActivity.class);
        startActivity(intent);
    }


    public void goToReservas(View view) {
        Intent intent = new Intent(this, ReservasActivity.class);
        startActivity(intent);
    }

    public void goToPerfil(View view) {
        Intent intent = new Intent(this, PerfilActivity.class);
        startActivity(intent);
    }


}