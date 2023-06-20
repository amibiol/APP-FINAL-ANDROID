package com.example.biblio_mb;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText usuario, clave, email;

    daoUsuario dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usuario = findViewById(R.id.text_user);
        clave = findViewById(R.id.text_password);
        email = findViewById(R.id.text_email);
        Button btn_registrarse = findViewById(R.id.button_registro);

        btn_registrarse.setOnClickListener(this);
        dao = new daoUsuario(this);


    }

    public void goToLogin(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Usuario usuario1 = new Usuario();
        usuario1.setNombre(usuario.getText().toString());
        usuario1.setClave(clave.getText().toString());
        usuario1.setEmail(email.getText().toString());



        if(usuario1.isNull()){
            Toast.makeText(this, "Debe ingresar todos los datos", Toast.LENGTH_LONG).show();
        }else if(dao.insertarUsuario(usuario1)){
            Toast.makeText(this, "Registrado con èxito", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent1 = new Intent(RegistroActivity.this, LoginActivity.class);
                    startActivity(intent1);
                }
            }, 1000); //

        }else{
            Toast.makeText(this, "Nombre de usuario ya existe", Toast.LENGTH_LONG).show();
        }


    }


}