package com.example.parcial2;

class DefBD {

    public static final String nameDb = "Registro_user";
    public static final String tabla_user = "Usuario";
    public static final String col_name = "nombre";
    public static final String col_id = "identificacion";
    public static final String col_estrato = "estrato";
    public static final String col_salario = "salario";
    public static final String col_nivel = "nivel";

    public static final String create_tabla_user = "CREATE TABLE IF NOT EXISTS usuario(" +
            "  identificacion text primary key," +
            "  nombre text," +
            "  estrato text," +
            "  salario text," +
            "  nivel text"+
            ");";
}
