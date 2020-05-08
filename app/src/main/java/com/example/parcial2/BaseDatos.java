package com.example.parcial2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class BaseDatos extends SQLiteOpenHelper {

    public BaseDatos(Context context) {
        super(context, DefBD.nameDb, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DefBD.create_tabla_user);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
