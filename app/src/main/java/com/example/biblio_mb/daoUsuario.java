package com.example.biblio_mb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoUsuario {
    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String db="DB_Usuarios";
    String table = "create table if not exists  usuario(id integer primary key autoincrement, nombre text unique, clave text, email text)";


    public daoUsuario(Context c){
        this.c = c;
        sql = c.openOrCreateDatabase(db, c.MODE_PRIVATE, null);
        sql.execSQL(table);
        u=new Usuario();
    }


    public boolean insertarUsuario(Usuario u) {
        if (buscar(u.getNombre()) == 0) {
            ContentValues cv = new ContentValues();
            cv.put("nombre", u.getNombre());
            cv.put("email", u.getEmail());
            cv.put("clave", u.getClave());
            return (sql.insert("usuario", null, cv) > 0);
        } else {
            return false;
        }
    }



    public int buscar(String u){
        int x = 0;
        lista =  selectUsuarios();
        for(Usuario us:lista) {
            if(us.getNombre().equals(u)){
                x++;
            }
        }
        return x;
    }




    public ArrayList<Usuario> selectUsuarios(){
        ArrayList<Usuario> lista = new ArrayList<Usuario>();

        Cursor cr = sql.rawQuery("select * from usuario", null);
        if (cr != null && cr.moveToFirst()){

            do{
                Usuario u = new Usuario();
                u.setId(cr.getInt(0));
                u.setNombre(cr.getString(1));
                u.setEmail(cr.getString(2));
                u.setClave(cr.getString(3));
                lista.add(u);
            }while(cr.moveToNext());
        }
        return lista;
    }



    public int login(String u, String p){
        int a = 0;
        Cursor cr1 = sql.rawQuery("select * from usuario", null);

        if (cr1  != null && cr1.moveToFirst()){
            do{
                if(cr1.getString(1).equals(u) && cr1.getString(2).equals(p)){
                    a++;
                }
            }while(cr1.moveToNext());
        }
        return a;
    }


    public Usuario getUsuario(String u, String p){
        lista = selectUsuarios();
        for (Usuario us:lista){
            if(us.getNombre().equals(u) && us.getClave().equals(p)){
                return us;
            }
        }
        return null;
    }


    public Usuario getUsuarioById(int id){
        lista = selectUsuarios();
        for (Usuario us:lista){
            if(us.getId() == id){
                return us;
            }
        }
        return null;
    }
    public void updateUsuario(Usuario usuario, String dato) {
        ContentValues cv = new ContentValues();
        cv.put("nombre", dato);
        sql.update("usuario", cv, "nombre=?", new String[]{String.valueOf(usuario.getNombre())});
    }

    public void updateClave(Usuario usuario, String dato) {
        ContentValues cv = new ContentValues();
        cv.put("clave", dato);
        sql.update("usuario", cv, "nombre=?", new String[]{String.valueOf(usuario.getNombre())});
    }


}
