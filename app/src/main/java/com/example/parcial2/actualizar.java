package com.example.parcial2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class actualizar extends AppCompatActivity {
    Spinner estrato, educacion ;

    UserController c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);


        c = new UserController(getApplicationContext());

        Button btnActualizar = (Button)findViewById(R.id.btn_actualizar);
        final Button btnDevolver = (Button)findViewById(R.id.btn_volver);
        final EditText edtNombre = findViewById(R.id.edtnombree);
        final EditText edtId = findViewById(R.id.edtidd);
        final EditText edtSalario = findViewById(R.id.edtsalarioo);
        estrato = findViewById(R.id.spinner_estrato);
        educacion = findViewById(R.id.spinner_nivel);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean actualizar = c.actualizar(edtNombre.getText().toString(), edtId.getText().toString(),
                        estrato.getSelectedItem().toString(),edtSalario.getText().toString(),educacion.getSelectedItem().toString());
                if (actualizar == true) {
                    Toast.makeText(actualizar.this, "Se actualizo correctamente", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(actualizar.this,Listado.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(actualizar.this, "ha ocurrido un error, intentalo mas tarde", Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnDevolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(actualizar.this,Listado.class);
                startActivity(intent);
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

    /*@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }*/
}
