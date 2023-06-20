package com.example.biblio_mb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText text_user, text_password;
    daoUsuario dao;
    private static final String LOG_TAG = LoginActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        text_user = findViewById(R.id.text_user);
        text_password = findViewById(R.id.text_password);
        Button btn_ingresar = findViewById(R.id.button_ingresar);
        dao = new daoUsuario(this);
        btn_ingresar.setOnClickListener(this);

        }

            public void goToMain(View view) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }

            public void goToOlvidoClave(View view) {
                Intent intent = new Intent(this, OvidoClaveActivity.class);
                startActivity(intent);
            }


            public void goToRegistro(View view) {
                Intent intent = new Intent(this, RegistroActivity.class);
                startActivity(intent);
            }

    @Override
    public void onClick(View v) {

        String u = text_user.getText().toString();
        String p = text_password.getText().toString();


        if(u.equals("") && p.equals("")){
            Toast.makeText(this, "Debe rellenar todos los datos",  Toast.LENGTH_LONG).show();
        }else if (dao.login( u, p) == 1){
            Usuario ux  = dao.getUsuario(u,p);


           Toast.makeText(this, "Credenciales correctas",  Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(this, DashboardActivity.class);
                    startActivity(intent1);


        }else{
            Toast.makeText(this, "Usuario y/o clave incorrectos",  Toast.LENGTH_LONG).show();
        }

    }

        }