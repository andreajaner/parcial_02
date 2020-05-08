package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class buscar extends AppCompatActivity {

    TextView nombre,cedula,salario, estrato, nivel;
    Button buscar, volver;
    UserController c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        c = new UserController(getApplicationContext());

        final EditText buscarID = findViewById(R.id.txt_buscarId);
        nombre = (TextView) findViewById(R.id.nombresito);
        cedula = (TextView) findViewById(R.id.idesito);
        salario = (TextView) findViewById(R.id.salarito);
        estrato = (TextView) findViewById(R.id.estratico);
        nivel = (TextView) findViewById(R.id.nivelito);
        buscar  = (Button) findViewById(R.id.btn_buscar);
        volver = (Button) findViewById(R.id.btn_volversito);


        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(buscar.this,Listado.class);
                startActivity(intent);
            }
        });
    }
}
