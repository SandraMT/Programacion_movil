package com.example.micro.directorioempleados;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText inpBuscar;
    private Conexion conexion;
    private List<Empleados> emp;
    private RecyclerView recyclerView;
    private RVEmpleadosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inpBuscar = (EditText) findViewById(R.id.inpBuscar);
        conexion = new Conexion(this, "empleadosDB", null, 1);

        datosInicio();
        recyclerView = findViewById(R.id.rv_empleados);
        adapter = new RVEmpleadosAdapter(this, emp);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    private void datosInicio() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        emp = new ArrayList<>();
        try {
            String consulta = "SELECT * FROM " + Utilidades.TABLA_EMPLEADO + " WHERE '1'=?";
            String[] parametros = {"1"};

            Cursor cursor = db.rawQuery(consulta, parametros);
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                if (i != 0) {
                    cursor.moveToNext();
                }
                Empleados regEmp = new Empleados();
                regEmp.setImagen(cursor.getString(0));
                regEmp.setNombre(cursor.getString(1));
                regEmp.setApellidos(cursor.getString(2));
                regEmp.setDireccion(cursor.getString(3));
                regEmp.setTelefono(cursor.getString(4));
                regEmp.setCorreo(cursor.getString(5));
                regEmp.setNacionalidad(cursor.getString(6));
                regEmp.setEstadoCivil(cursor.getString(7));
                regEmp.setEnfermedades(cursor.getString(8));
                regEmp.setNumNomina(cursor.getString(9));
                regEmp.setArea(cursor.getString(10));
                regEmp.setPuesto(cursor.getString(11));
                regEmp.setRFC(cursor.getString(12));
                regEmp.setNSS(cursor.getString(13));
                regEmp.setContactoEmergencia(cursor.getString(14));
                regEmp.setEscolaridad(cursor.getString(15));
                regEmp.setStatus(cursor.getString(16));
                emp.add(regEmp);
            }
            adapter = new RVEmpleadosAdapter(this, emp);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
            cursor.close();
        } catch (Exception e) {
        }
    }

    public void consultar(View vista) {
        SQLiteDatabase db = conexion.getReadableDatabase();
        emp = new ArrayList<>();
        try {
            String consulta = "SELECT * FROM " + Utilidades.TABLA_EMPLEADO +
                    " WHERE " + Utilidades.CAMPO_NOMBRE + "=? OR " + Utilidades.CAMPO_APELLIDOS + "=? OR " +
                    Utilidades.CAMPO_DIRECCION + "=? OR " + Utilidades.CAMPO_TELEFONO + "=? OR " + Utilidades.CAMPO_CORREO +
                    "=? OR " + Utilidades.CAMPO_NACIONALIDAD + "=? OR " + Utilidades.CAMPO_ESTADO_CIVIL + "=? OR " +
                    Utilidades.CAMPO_ENFERMEDADES + "=? OR " + Utilidades.CAMPO_NUM_NOMINA + "=? OR " + Utilidades.CAMPO_AREA +
                    "=? OR " + Utilidades.CAMPO_PUESTO + "=? OR " + Utilidades.CAMPO_RFC + "=? OR " + Utilidades.CAMPO_NSS +
                    "=? OR " + Utilidades.CAMPO_CONTACTO_EMERGENCIA + "=? OR " + Utilidades.CAMPO_ESCOLARIDAD +
                    "=? OR " + Utilidades.CAMPO_STATUS + "=?";
            String[] parametros = {inpBuscar.getText().toString().trim(), inpBuscar.getText().toString().trim(),
                    inpBuscar.getText().toString().trim(), inpBuscar.getText().toString().trim(),
                    inpBuscar.getText().toString().trim(), inpBuscar.getText().toString().trim(),
                    inpBuscar.getText().toString().trim(), inpBuscar.getText().toString().trim(),
                    inpBuscar.getText().toString().trim(), inpBuscar.getText().toString().trim(),
                    inpBuscar.getText().toString().trim(), inpBuscar.getText().toString().trim(),
                    inpBuscar.getText().toString().trim(), inpBuscar.getText().toString().trim(),
                    inpBuscar.getText().toString().trim(), inpBuscar.getText().toString().trim()};

            Cursor cursor = db.rawQuery(consulta, parametros);
            cursor.moveToFirst();
            if (cursor.getCount() != 0) {
                for (int i = 0; i < cursor.getCount(); i++) {
                    if (i != 0) {
                        cursor.moveToNext();
                    }
                    Empleados regEmp = new Empleados();
                    regEmp.setImagen(cursor.getString(0));
                    regEmp.setNombre(cursor.getString(1));
                    regEmp.setApellidos(cursor.getString(2));
                    regEmp.setDireccion(cursor.getString(3));
                    regEmp.setTelefono(cursor.getString(4));
                    regEmp.setCorreo(cursor.getString(5));
                    regEmp.setNacionalidad(cursor.getString(6));
                    regEmp.setEstadoCivil(cursor.getString(7));
                    regEmp.setEnfermedades(cursor.getString(8));
                    regEmp.setNumNomina(cursor.getString(9));
                    regEmp.setArea(cursor.getString(10));
                    regEmp.setPuesto(cursor.getString(11));
                    regEmp.setRFC(cursor.getString(12));
                    regEmp.setNSS(cursor.getString(13));
                    regEmp.setContactoEmergencia(cursor.getString(14));
                    regEmp.setEscolaridad(cursor.getString(15));
                    regEmp.setStatus(cursor.getString(16));
                    emp.add(regEmp);
                }
                adapter = new RVEmpleadosAdapter(this, emp);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                cursor.close();
            } else {
                Toast.makeText(this, "No se encontraron coincidencias", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "No se encontraron coincidencias", Toast.LENGTH_LONG).show();
        }
    }

    public void irAdministrar(View vista) {
        Intent intent = new Intent(this, Acciones.class);
        startActivity(intent);
    }
}
