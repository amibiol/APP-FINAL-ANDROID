package com.example.biblio_mb;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Libro> {
    private int layoutResource;

    daoLibro dao;
    public CustomAdapter(Context context, int resource, List<Libro> items) {
        super(context, resource, items);
        layoutResource = resource;

        dao = new daoLibro(context.getApplicationContext());

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(layoutResource, parent, false);
        }

        Libro libro = getItem(position);

        TextView textNombre = convertView.findViewById(R.id.text_libro);
        Button btnReservar = convertView.findViewById(R.id.btn_reservar);
        textNombre.setText(libro.getNombre());


        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Obtenemos el libro seleccionado
                Libro libroSeleccionado = getItem(position);

                // Obtenemos el ID del libro seleccionado
                int libroId = libroSeleccionado.getId();

                Toast.makeText(getContext(), "ID del libro seleccionado: " + libroId, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), GestionarLibroActivity.class);
                intent.putExtra("LIBRO_ID", libroId);
                getContext().startActivity(intent);

            }
        });

        return convertView;
    }



}
