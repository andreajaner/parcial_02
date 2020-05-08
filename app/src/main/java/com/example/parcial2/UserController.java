package com.example.parcial2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import  static com.example.parcial2.DefBD.tabla_user;
class UserController {

    private BaseDatos db;

    public UserController(Context context) {
        this.db = new BaseDatos(context);
    }

    public long agregarUsuario (Usuario u) {
        try {
            SQLiteDatabase database = db.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(DefBD.col_id, u.identificacion);
            values.put(DefBD.col_name, u.nombre);
            values.put(DefBD.col_estrato, u.estrato);
            values.put(DefBD.col_salario, u.salario);
            values.put(DefBD.col_nivel, u.nivel);

            long idd= database.insert(tabla_user, null, values);
            return idd;
        } catch (Exception e) {
            System.out.println("Error al insertar");
            return 0;
        }

    }

    public  Boolean buscarUser(String cod){
        String[] args = new String[]{cod};
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor c = database.query(tabla_user, null, "identificacion=?", args,null, null, null);
        if (c.getCount()>0){
            database.close();
            return true;
        }else{
            database.close();
            return false;
        }
    }

    public Cursor allUsers(){
        try {
            SQLiteDatabase database = db.getWritableDatabase();
            Cursor cur = database.rawQuery("select nombre as _id , identificacion, estrato, salario, nivel from usuario",null);
            return cur;
        }catch (Exception e){
            System.out.println("Error de consulta");
            return null;
        }

    }

    public boolean actualizar(String nombre, String identificacion, String estrato, String salario, String nivel){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DefBD.col_id, identificacion);
        values.put(DefBD.col_name, nombre);
        values.put(DefBD.col_estrato, estrato);
        values.put(DefBD.col_salario, salario);
        values.put(DefBD.col_nivel,nivel);
        database.update(tabla_user, values,"identificacion=?", new String[]{identificacion});
        return true;
    }

    public Integer eliminar(String id){
        SQLiteDatabase database = db.getWritableDatabase();
        return  database.delete(tabla_user, "identificacion=?", new String[]{id});
    }



}
