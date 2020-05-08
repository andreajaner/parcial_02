package com.example.parcial2;

import androidx.annotation.NonNull;

class Usuario {

    public String nombre;
    public String identificacion;
    public String estrato;
    public String salario;
    public String nivel;

    public Usuario(String nombre, String identificacion, String estrato, String salario, String nivel) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.estrato = estrato;
        this.salario = salario;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @NonNull
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", estrato='" + estrato + '\'' +
                ", salario='" + salario + '\'' +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}
