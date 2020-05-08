package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nombre, identificacion,salario;
    Button guardar, listar;
    Spinner estrato, educacion ;
    Usuario user;
    UserController uc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.txt_nombre);
        identificacion = findViewById(R.id.txt_identifi);
        salario = findViewById(R.id.txt_salario);
        guardar = findViewById(R.id.btn_guardar);
        listar = findViewById(R.id.btn_listar);
        estrato = findViewById(R.id.spinner_estrato);
        educacion = findViewById(R.id.spinner_nivel);


        uc = new UserController(getApplicationContext());

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user = new Usuario(nombre.getText().toString(),identificacion.getText().toString(),estrato.getSelectedItem().toString(),salario.getText().toString(), educacion.getSelectedItem().toString());
                Toast.makeText(getApplicationContext(), user.identificacion, Toast.LENGTH_SHORT).show();
                if(!uc.buscarUser(user.identificacion)) {
                    Log.d("Buscar", "No encontrado");
                    long id = uc.agregarUsuario(user);
                    Toast.makeText(getApplicationContext(), "Usuario registrado", Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.d("Buscar", "encontrado");
                    Toast.makeText(getApplicationContext(),"Usuario ya esta registrado",Toast.LENGTH_SHORT).show();
                }
            }
        });
        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Listado.class);
                startActivity(i);
            }
        });
    }

    /*public void checkButton_estrato(View v) {
        int est = estrato.getCheckedRadioButtonId();

        rb_estrato = findViewById(est);

        Toast.makeText(this, "Estrato: " + rb_estrato.getText(), Toast.LENGTH_SHORT).show();
    }

    public void checkButton_educacion(View v) {
        int edu = educacion.getCheckedRadioButtonId();

        rb_educacion = findViewById(edu);

        Toast.makeText(this, "Nivel educativo: " + rb_educacion.getText(), Toast.LENGTH_SHORT).show();
    }*/
}
