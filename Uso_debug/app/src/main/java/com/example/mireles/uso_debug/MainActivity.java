package com.example.mireles.uso_debug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Suma de dos números
    /*
    private int numero_1;
    private int numero_2;
    private int resultado;
    */

    //Manejo de listas
    private List<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // suma de dos números
        /*
        numero_1 = 10;
        numero_2 = 4;
        resultado = numero_1 + numero_2;
        */

        //manejo de listas
        lista = new ArrayList<String>();

            // Agrega los datos a la lista
            lista.add("Sandra");
            lista.add("Erika");
            lista.add("Roberto");

            // Mostrar datos de la lista
            Iterator imp = lista.iterator();
                while (imp.hasNext())
                System.out.println(imp.next());
    }
}
