package com.example.biblio_mb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class daoLibro {
    Context c;
    Libro l;
    ArrayList<Libro> lista;
    SQLiteDatabase sql;
    String db="DB_Libros";
    String table = "create table if not exists  libro(id integer primary key autoincrement, nombre text unique, isbn integer, estado boolean)";


    public daoLibro(Context c){
        this.c = c;
        sql = c.openOrCreateDatabase(db, c.MODE_PRIVATE, null);
        sql.execSQL(table);
        l = new Libro();
    }


    public boolean insertarLibro(Libro l) {
        if (buscar(l.getNombre()) == 0) {
            ContentValues cv = new ContentValues();
            cv.put("nombre", l.getNombre());
            cv.put("isbn", l.getIsbn());
            cv.put("estado", l.getEstado());
            return (sql.insert("libro", null, cv) > 0);
        } else {
            return false;
        }
    }



    public int buscar(String l){
        int x = 0;
        lista =  selectLibros();
        for(Libro libro1:lista) {
            if(libro1.getNombre().equals(l)){
                x++;
            }
        }
        return x;
    }




    public ArrayList<Libro> selectLibros(){
        ArrayList<Libro> lista = new ArrayList<Libro>();

        Cursor cr = sql.rawQuery("select * from libro", null);
        if (cr != null && cr.moveToFirst()){

            do{
                Libro l = new Libro();
                l.setId(cr.getInt(0));
                l.setNombre(cr.getString(1));
                l.setIsbn(cr.getInt(2));
                l.setEstado(cr.getInt(3));
                lista.add(l);
            }while(cr.moveToNext());
        }
        return lista;
    }




    public Libro getLibroById(int id){
        lista = selectLibros();
        for (Libro lib:lista){
            if(lib.getId() == id){
                return lib;
            }
        }
        return null;
    }

    public void updateLibro(Libro libro, int estado) {
        ContentValues cv = new ContentValues();
        cv.put("estado", estado);
        sql.update("libro", cv, "id=?", new String[]{String.valueOf(libro.getId())});
    }





}
