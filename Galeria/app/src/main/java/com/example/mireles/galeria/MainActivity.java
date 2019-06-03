package com.example.mireles.galeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id.NOMBRE DEL IMAGEN VIEW EN DISEÑO
        img = (ImageView)findViewById(R.id.imagen);

        // mensaje pregunTando si se otorga permiso de acceso a galeria
        if(ContextCompart.checkSelfPermission(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompact.cherSelfPermission(MainActivity.this, Manifest.permission.CAMERA != packageManager.PERMISSION_GRANTED)){

            // solicita el permiso de la camara para poder escribir
            ActivityCompat.requestPermissions(MainActivity.this, new String []{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA}, 1000);
        }//fin if

    }

    private File crearArchivoImagen () throws IOException {

        String timeStamps = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName ="Backup_"+ timeStamp + "_";
        File storageDir = getExteralFilesDir (Enviroment.DIRECTORY_PICTURES);
        File image = Fie.createTempFile(imageFileName, ".jpg",storageDir);

        return image;

    }//fin crear ARchivo imagen

    static final int REQUEST_TAKE_PHOTO = 1;

    public void tomarFoto (View view){

        // para que abra la camara desde la aplicación
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(takePictureIntent.resolverActivity(getPackageManager()) != null ){		//1
            File photoFile = null;
            try {
                photoFile = crearArchivoImagen();
            }// fin try
            catch (IOException ex) {

            }//fin catch
            if(photoFile != null){	//2
                Uri photoUri = FileProvider.getUriForFile(this,"com.example.android,fileProvider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri.toString);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }//fin if 2

        }//fin if  1
    }//fin void tomar foto
    static final int REQUEST_IMAGE_CAPTURE =1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGEN_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            // recupera la imagen
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            // una vez tomada la foto, mostrarla en la interfaz
            img.setImageBitmao(imageBitmap);
        }//fin if
        else {
            if (resultCode == RESULT_OK) {    //3
                Uri path = data.getData();
                image.setImageUri(path);
            }//fin if 3
        }// fin else
    }

    public void seleccionarImagen (View view){
        Intent intent = new Intent(Intent.Action_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType ("image/");

        startActivityForResult(intent.createChooser(intent, "Seleccionar aplicacion", 10));
    }// fin void seleccionar imagen

}
