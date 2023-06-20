package com.example.biblio_mb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    TextView cambiarUsuario, cambiarClave;
    Button actualizarUsuario, actualizarCLave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        cambiarUsuario = findViewById(R.id.editText_usuario);
        cambiarClave = findViewById(R.id.editText_clave);

    }

    public void goToDashboard(View view) {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }

    public void actualizarUsuario(View view) {
        String u = cambiarUsuario.getText().toString();

        Intent intent = new Intent(this, ValidarUsuarioActivity.class);

        intent.putExtra("Usuario", u);

        startActivity(intent);

    }


    public void actualizarClave(View view) {
        String p = cambiarClave.getText().toString();

        Intent intent = new Intent(this, ValidarUsuarioActivity.class);

        intent.putExtra("Clave", p);

        startActivity(intent);

    }

}