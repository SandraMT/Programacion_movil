package com.example.micro.directorioempleados;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Acciones extends AppCompatActivity {

    static final int REQUEST_TAKE_PHOTO = 1;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_SHOW_IMAGE = 10;
    private ImageView img;
    //private String ruta;
    private EditText inpNombre, inpApellidos, inpDireccion, inpTelefono, inpCorreo, inpNacionalidad, inpEstadoCivil,
            inpEnfermedades, inpNumNomina, inpArea, inpPuesto, inpRFC, inpNSS, inpEmergencia, inpEscolaridad, inpStatus;
    private Conexion conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acciones);

        if (ContextCompat.checkSelfPermission(Acciones.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Acciones.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Acciones.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
        }
        conexion = new Conexion(this, "empleadosDB", null, 1);
        vincularElementos();
    }

    private void vincularElementos() {
        //img = (ImageView) findViewById(R.id.imagen);
        inpNombre = (EditText) findViewById(R.id.inpNombre);
        inpApellidos = (EditText) findViewById(R.id.inpApellidos);
        inpDireccion = (EditText) findViewById(R.id.inpDireccion);
        inpTelefono = (EditText) findViewById(R.id.inpTelefono);
        inpCorreo = (EditText) findViewById(R.id.inpCorreo);
        inpNacionalidad = (EditText) findViewById(R.id.inpNacionalidad);
        inpEstadoCivil = (EditText) findViewById(R.id.inpEstadoCivil);
        inpEnfermedades = (EditText) findViewById(R.id.inpEnfermedades);
        inpNumNomina = (EditText) findViewById(R.id.inpNumNomina);
        inpArea = (EditText) findViewById(R.id.inpArea);
        inpPuesto = (EditText) findViewById(R.id.inpPuesto);
        inpRFC = (EditText) findViewById(R.id.inpRFC);
        inpNSS = (EditText) findViewById(R.id.inpNSS);
        inpEmergencia = (EditText) findViewById(R.id.inpEmergencia);
        inpEscolaridad = (EditText) findViewById(R.id.inpEscolaridad);
        inpStatus = (EditText) findViewById(R.id.inpStatus);
    }

    private File crearArchivoImagen() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "Backup_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);
        return image;
    }

    public void tomarFoto(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = crearArchivoImagen();
            } catch (IOException ex) {
                Toast.makeText(this, "Error al tomar la foto", Toast.LENGTH_LONG).show();
            }
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                //ruta = "ruta";
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI.toString());
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            img.setImageBitmap(imageBitmap);
        } else {
            if (requestCode == REQUEST_SHOW_IMAGE && resultCode == RESULT_OK) {
                Uri path = data.getData();
                //ruta = "ruta";
                img.setImageURI(path);
            }
        }
    }

    public void seleccionarImagen(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent, "Seleccionar aplicación"), REQUEST_SHOW_IMAGE);
    }

    public void registrarEmpleado(View view) {
        if (validarLlenado()) {
            if (!validarExistencia()) {
                SQLiteDatabase db = conexion.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(Utilidades.CAMPO_IMAGEN, "img");
                values.put(Utilidades.CAMPO_NOMBRE, inpNombre.getText().toString());
                values.put(Utilidades.CAMPO_APELLIDOS, inpApellidos.getText().toString());
                values.put(Utilidades.CAMPO_DIRECCION, inpDireccion.getText().toString());
                values.put(Utilidades.CAMPO_TELEFONO, inpTelefono.getText().toString());
                values.put(Utilidades.CAMPO_CORREO, inpCorreo.getText().toString());
                values.put(Utilidades.CAMPO_NACIONALIDAD, inpNacionalidad.getText().toString());
                values.put(Utilidades.CAMPO_ESTADO_CIVIL, inpEstadoCivil.getText().toString());
                values.put(Utilidades.CAMPO_ENFERMEDADES, inpEnfermedades.getText().toString());
                values.put(Utilidades.CAMPO_NUM_NOMINA, inpNumNomina.getText().toString());
                values.put(Utilidades.CAMPO_AREA, inpArea.getText().toString());
                values.put(Utilidades.CAMPO_PUESTO, inpPuesto.getText().toString());
                values.put(Utilidades.CAMPO_RFC, inpRFC.getText().toString());
                values.put(Utilidades.CAMPO_NSS, inpNSS.getText().toString());
                values.put(Utilidades.CAMPO_CONTACTO_EMERGENCIA, inpEmergencia.getText().toString());
                values.put(Utilidades.CAMPO_ESCOLARIDAD, inpEscolaridad.getText().toString());
                values.put(Utilidades.CAMPO_STATUS, inpStatus.getText().toString());

                db.insert(Utilidades.TABLA_EMPLEADO, Utilidades.CAMPO_NUM_NOMINA, values);
                limpiar();
                Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_LONG).show();
                db.close();
            } else {
                Toast.makeText(this, "El número de nomina ya existe", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Debes ingresar todos los campos", Toast.LENGTH_LONG).show();
        }
    }

    public void modificarEmpleado(View view) {
        if (validarLlenado()) {
            if (validarExistencia()) {
                SQLiteDatabase db = conexion.getWritableDatabase();
                String[] parametros = {inpNumNomina.getText().toString()};

                ContentValues values = new ContentValues();
                values.put(Utilidades.CAMPO_IMAGEN, "img");
                values.put(Utilidades.CAMPO_NOMBRE, inpNombre.getText().toString());
                values.put(Utilidades.CAMPO_APELLIDOS, inpApellidos.getText().toString());
                values.put(Utilidades.CAMPO_DIRECCION, inpDireccion.getText().toString());
                values.put(Utilidades.CAMPO_TELEFONO, inpTelefono.getText().toString());
                values.put(Utilidades.CAMPO_CORREO, inpCorreo.getText().toString());
                values.put(Utilidades.CAMPO_NACIONALIDAD, inpNacionalidad.getText().toString());
                values.put(Utilidades.CAMPO_ESTADO_CIVIL, inpEstadoCivil.getText().toString());
                values.put(Utilidades.CAMPO_ENFERMEDADES, inpEnfermedades.getText().toString());
                values.put(Utilidades.CAMPO_AREA, inpArea.getText().toString());
                values.put(Utilidades.CAMPO_PUESTO, inpPuesto.getText().toString());
                values.put(Utilidades.CAMPO_RFC, inpRFC.getText().toString());
                values.put(Utilidades.CAMPO_NSS, inpNSS.getText().toString());
                values.put(Utilidades.CAMPO_CONTACTO_EMERGENCIA, inpEmergencia.getText().toString());
                values.put(Utilidades.CAMPO_ESCOLARIDAD, inpEscolaridad.getText().toString());
                values.put(Utilidades.CAMPO_STATUS, inpStatus.getText().toString());

                db.update(Utilidades.TABLA_EMPLEADO, values, Utilidades.CAMPO_NUM_NOMINA + "=?", parametros);
                limpiar();
                Toast.makeText(getApplicationContext(), "Empleado actualizado", Toast.LENGTH_LONG).show();
                db.close();
            } else {
                Toast.makeText(this, "El empleado no existe", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Debes ingresar todos los campos", Toast.LENGTH_LONG).show();
        }
    }

    public void buscarEmpleado(View view) {
        SQLiteDatabase db = conexion.getReadableDatabase();
        if (inpNumNomina.getText().toString().trim().length() > 0) {
            String consulta = "SELECT * FROM " + Utilidades.TABLA_EMPLEADO +
                    " WHERE " + Utilidades.CAMPO_NUM_NOMINA + "=?";
            String[] parametros = {inpNumNomina.getText().toString().trim()};
            Cursor cursor = db.rawQuery(consulta, parametros);
            cursor.moveToFirst();
            if (cursor.getCount() != 0) {
                inpNombre.setText(cursor.getString(1));
                inpApellidos.setText(cursor.getString(2));
                inpDireccion.setText(cursor.getString(3));
                inpTelefono.setText(cursor.getString(4));
                inpCorreo.setText(cursor.getString(5));
                inpNacionalidad.setText(cursor.getString(6));
                inpEstadoCivil.setText(cursor.getString(7));
                inpEnfermedades.setText(cursor.getString(8));
                inpNumNomina.setText(cursor.getString(9));
                inpArea.setText(cursor.getString(10));
                inpPuesto.setText(cursor.getString(11));
                inpRFC.setText(cursor.getString(12));
                inpNSS.setText(cursor.getString(13));
                inpEmergencia.setText(cursor.getString(14));
                inpEscolaridad.setText(cursor.getString(15));
                inpStatus.setText(cursor.getString(16));
            } else {
                Toast.makeText(this, "El empleado no existe", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Ingresa el numero de nomina del empleado", Toast.LENGTH_LONG).show();
        }
    }

    public void eliminarEmpleado(View view) {
        if (inpNumNomina.getText().toString().trim().length() > 0) {
            if (validarExistencia()) {
                SQLiteDatabase db = conexion.getWritableDatabase();
                String[] parametros = {inpNumNomina.getText().toString()};

                db.delete(Utilidades.TABLA_EMPLEADO, Utilidades.CAMPO_NUM_NOMINA + "=?", parametros);
                limpiar();
                Toast.makeText(getApplicationContext(), "Empleado eliminado", Toast.LENGTH_LONG).show();
                db.close();
            } else {
                Toast.makeText(this, "El empleado no existe", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Ingresa el numero de nomina del empleado", Toast.LENGTH_LONG).show();
        }
    }

    public void irInicio(View vista) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void limpiar() {
        //ruta = "";
        inpNombre.setText("");
        inpApellidos.setText("");
        inpDireccion.setText("");
        inpTelefono.setText("");
        inpCorreo.setText("");
        inpNacionalidad.setText("");
        inpEstadoCivil.setText("");
        inpEnfermedades.setText("");
        inpNumNomina.setText("");
        inpArea.setText("");
        inpPuesto.setText("");
        inpRFC.setText("");
        inpNSS.setText("");
        inpEmergencia.setText("");
        inpEscolaridad.setText("");
        inpStatus.setText("");
    }

    private boolean validarLlenado() {
        return inpNombre.getText().toString().trim().length() > 0 &&
                inpApellidos.getText().toString().trim().length() > 0 &&
                inpDireccion.getText().toString().trim().length() > 0 &&
                inpTelefono.getText().toString().trim().length() > 0 &&
                inpCorreo.getText().toString().trim().length() > 0 &&
                inpNacionalidad.getText().toString().trim().length() > 0 &&
                inpEstadoCivil.getText().toString().trim().length() > 0 &&
                inpEnfermedades.getText().toString().trim().length() > 0 &&
                inpNumNomina.getText().toString().trim().length() > 0 &&
                inpArea.getText().toString().trim().length() > 0 &&
                inpPuesto.getText().toString().trim().length() > 0 &&
                inpRFC.getText().toString().trim().length() > 0 &&
                inpNSS.getText().toString().trim().length() > 0 &&
                inpEmergencia.getText().toString().trim().length() > 0 &&
                inpEscolaridad.getText().toString().trim().length() > 0 &&
                inpStatus.getText().toString().trim().length() > 0;
    }

    private boolean validarExistencia() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        try {
            String consulta = "SELECT " + Utilidades.CAMPO_NUM_NOMINA + " FROM " + Utilidades.TABLA_EMPLEADO +
                    " WHERE " + Utilidades.CAMPO_NUM_NOMINA + "=?";
            String[] parametros = {inpNumNomina.getText().toString().trim()};
            Cursor cursor = db.rawQuery(consulta, parametros);
            if (cursor.getCount() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
