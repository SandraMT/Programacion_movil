package com.example.micro.directorioempleados;

public class Utilidades {
    public static final String TABLA_EMPLEADO = "empleado";
    public static final String CAMPO_IMAGEN = "imagen";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_APELLIDOS = "apellidos";
    public static final String CAMPO_DIRECCION = "direccion";
    public static final String CAMPO_TELEFONO = "telefono";
    public static final String CAMPO_CORREO = "correo";
    public static final String CAMPO_NACIONALIDAD = "nacionalidad";
    public static final String CAMPO_ESTADO_CIVIL = "estadoCivil";
    public static final String CAMPO_ENFERMEDADES = "enfermedades";
    public static final String CAMPO_NUM_NOMINA = "numNomina";
    public static final String CAMPO_AREA = "area";
    public static final String CAMPO_PUESTO = "puesto";
    public static final String CAMPO_RFC = "RFC";
    public static final String CAMPO_NSS = "NSS";
    public static final String CAMPO_CONTACTO_EMERGENCIA = "contactoEmergencia";
    public static final String CAMPO_ESCOLARIDAD = "escolaridad";
    public static final String CAMPO_STATUS = "status";

    public static final String CREAR_TABLA_EMPLEADOS =
            "CREATE TABLE " + TABLA_EMPLEADO + "(" +
                    CAMPO_IMAGEN + " TEXT," +
                    CAMPO_NOMBRE + " TEXT," +
                    CAMPO_APELLIDOS + " TEXT," +
                    CAMPO_DIRECCION + " TEXT," +
                    CAMPO_TELEFONO + " TEXT," +
                    CAMPO_CORREO + " TEXT," +
                    CAMPO_NACIONALIDAD + " TEXT," +
                    CAMPO_ESTADO_CIVIL + " TEXT," +
                    CAMPO_ENFERMEDADES + " TEXT," +
                    CAMPO_NUM_NOMINA + " TEXT," +
                    CAMPO_AREA + " TEXT," +
                    CAMPO_PUESTO + " TEXT," +
                    CAMPO_RFC + " TEXT," +
                    CAMPO_NSS + " TEXT," +
                    CAMPO_CONTACTO_EMERGENCIA + " TEXT," +
                    CAMPO_ESCOLARIDAD + " TEXT," +
                    CAMPO_STATUS + " TEXT)";
}
