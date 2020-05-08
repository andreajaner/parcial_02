package com.example.parcial2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

class UsuarioCursorAdapter extends CursorAdapter {

    public UsuarioCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return LayoutInflater.from(context).inflate(R.layout.dato_user, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nombres = (TextView) view.findViewById(R.id.txtname);
        TextView identificaciones = (TextView) view.findViewById(R.id.txtid);
        TextView estratos = (TextView) view.findViewById(R.id.txtest);
        TextView salarios = (TextView) view.findViewById(R.id.txtsal);
        TextView niveles = (TextView) view.findViewById(R.id.txtniv);

        String nombre = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        String identificacion = cursor.getString(cursor.getColumnIndexOrThrow("identificacion"));
        String estrato = cursor.getString(cursor.getColumnIndexOrThrow("estrato"));
        String salario = cursor.getString(cursor.getColumnIndexOrThrow("salario"));
        String nivel = cursor.getString(cursor.getColumnIndexOrThrow("nivel"));

        nombres.setText(nombre);
        identificaciones.setText(identificacion);
        estratos.setText(estrato);
        salarios.setText(salario);
        niveles.setText(nivel);
    }
}

