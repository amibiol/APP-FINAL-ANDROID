package com.example.biblio_mb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class LibrosActivity extends AppCompatActivity {

    daoLibro dao;

    private TextView text_libro;
    private ListView lv1;

    private ArrayList<Libro> lista_libros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros);
        dao = new daoLibro(this);
        guardarLibros();

        lv1 = findViewById(R.id.lista);
        lista_libros = dao.selectLibros();

        // Lista solo con los nombres de los libros
        List<String> nombres_libros = new ArrayList<>();
        for (Libro libro : lista_libros) {
            nombres_libros.add(libro.getNombre());
        }

        CustomAdapter adapter = new CustomAdapter(this, R.layout.list_view, lista_libros);
        lv1.setAdapter(adapter);


        /*
        // Adaptador con la lista de nombres de los libros
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view, nombres_libros);
        lv1.setAdapter(adapter);
*/

        /*
        // Adaptador con la lista y sus registros completos.
        ArrayAdapter<Libro> adapter = new ArrayAdapter<Libro>(this, R.layout.list_view,lista_libros);
        lv1.setAdapter(adapter);*/
    }

    public void goToDashboard(View view) {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);

    }

    public void guardarLibros(){
        Libro libro = new Libro();
        libro.setNombre("Harry potter y la piedra filosofal");
        libro.setIsbn(12345);
        libro.setEstado(0);
        dao.insertarLibro(libro);


        Libro libro1 = new Libro();
        libro1.setNombre("Harry potter y la camara secreta");
        libro1.setIsbn(13579);
        libro1.setEstado(0);
        dao.insertarLibro(libro1);


        Libro libro2 = new Libro();
        libro2.setNombre("Harry potter y el prisionero de Azcaban");
        libro2.setIsbn(14710);
        libro2.setEstado(0);
        dao.insertarLibro(libro2);


        Libro libro3 = new Libro();
        libro3.setNombre("Harry potter y el caliz de fuego");
        libro3.setIsbn(15879);
        libro3.setEstado(0);
        dao.insertarLibro(libro3);


        Libro libro4 = new Libro();
        libro4.setNombre("Harry potter y el principe mestizo");
        libro4.setIsbn(14734);
        libro4.setEstado(0);
        dao.insertarLibro(libro4);



        Libro libro5 = new Libro();
        libro5.setNombre("Harry potter y la orden del fenix");
        libro5.setIsbn(12567);
        libro5.setEstado(0);
        dao.insertarLibro(libro5);


        Libro libro6 = new Libro();
        libro6.setNombre("Harry potter y las reliquias de la muerte parte 1");
        libro6.setIsbn(16789);
        libro6.setEstado(0);
        dao.insertarLibro(libro6);


        Libro libro7 = new Libro();
        libro7.setNombre("Harry potter y las reliquias de la muerte parte 2");
        libro7.setIsbn(16790);
        libro7.setEstado(0);
        dao.insertarLibro(libro7);
}


}