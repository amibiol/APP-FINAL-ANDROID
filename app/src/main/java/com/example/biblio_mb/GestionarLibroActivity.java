package com.example.biblio_mb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GestionarLibroActivity extends AppCompatActivity {
    private int libroId;
    private TextView  textViewLibro;

    Libro libroAgestionar;

    private Button boton_reservar, boton_eliminarReserva;
    daoLibro dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionar_libro);

        dao = new daoLibro(this);

        // Obtener el ID del libro de los extras del Intent
        libroId = getIntent().getIntExtra("LIBRO_ID", 0);

        // Ejemplo: Mostrar el ID del libro en un TextView
        textViewLibro = findViewById(R.id.text_view_libro);

        libroAgestionar = dao.getLibroById(libroId);

        textViewLibro.setText("Has seleccionado: " + libroAgestionar.getNombre());


    }

    public void reservar(View view) {
        libroAgestionar = dao.getLibroById(libroId); // Obtener el libro actualizado desde la base de datos

        switch (libroAgestionar.getEstado()) {
            case 0:
                dao.updateLibro(libroAgestionar, 1);
                Toast.makeText(this, "Reservado con éxito", Toast.LENGTH_LONG).show();
                break;
            case 1:
                Toast.makeText(this, "El libro ya se encuentra reservado, prueba nuevamente en los próximos días", Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(this, "El libro se encuentra prestado, reservamos tu libro desde el Domingo 25", Toast.LENGTH_LONG).show();
                break;
        }
    }

    public void eliminarReserva(View view) {



    }

    public void goToLibros(View view) {
        Intent intent = new Intent(this, LibrosActivity.class);
        startActivity(intent);
    }


}