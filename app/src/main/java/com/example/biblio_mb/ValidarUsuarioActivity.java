package com.example.biblio_mb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ValidarUsuarioActivity extends AppCompatActivity {

    String usuario, clave;

    EditText text_user, text_password;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validar_usuario);

        usuario = getIntent().getStringExtra("Usuario");
        clave = getIntent().getStringExtra("Clave");

        text_user = findViewById(R.id.text_user);
        text_password = findViewById(R.id.text_password);

        dao = new daoUsuario(this);

    }

    public void validarUsuario(View view){


       /* String u = text_user.getText().toString();
        String p = text_password.getText().toString();
        Usuario us = dao.getUsuario(u, p);

        if(us == null) {
            Toast.makeText(this, "Las credenciales no son válidas", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Dato actualizado con éxito", Toast.LENGTH_LONG).show();

            if(u.equals("") && u == null) {
                dao.updateClave(us, usuario);
            } else if(p.equals("") && p == null) {
                dao.updateUsuario(us, clave);
            } else if(u != null && p != null) {
                dao.updateClave(us, usuario);
                dao.updateUsuario(us, clave);
            }
        }


        */

        String u = text_user.getText().toString();
        String p = text_password.getText().toString();


        if(u.equals("") && p.equals("")){
            Toast.makeText(this, "Debe rellenar todos los datos",  Toast.LENGTH_LONG).show();
        }else if (dao.login( u, p) == 1){
            Usuario us  = dao.getUsuario(u,p);

            Toast.makeText(this, usuario,  Toast.LENGTH_LONG).show();

            if(!usuario.isEmpty() && usuario != null) {
                dao.updateUsuario(us, usuario);
                Toast.makeText(this, "Datos actualizados con exito",  Toast.LENGTH_LONG).show();

            } else{
                Toast.makeText(this, "Error al actualizar datos",  Toast.LENGTH_LONG).show();
            }

        }else{
            Toast.makeText(this, "Usuario y/o clave incorrectos",  Toast.LENGTH_LONG).show();
        }
    }



}
