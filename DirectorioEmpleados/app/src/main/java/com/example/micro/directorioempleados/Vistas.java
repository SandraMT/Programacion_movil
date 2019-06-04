package com.example.micro.directorioempleados;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import java.util.ArrayList;

public class Vistas extends AppCompatActivity {

    public static ArrayList empleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vistas);

        empleado=(ArrayList) getIntent().getExtras().getSerializable("empleados");
        BottomNavigationView bottomBar = findViewById(R.id.bottombar);
        final Intent intent=new Intent(this,MainActivity.class);

        //Fragment fragmentSeleccionado = new Rapida();
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentSeleccionado).commit();

        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragmentSeleccionado = null;
                switch (menuItem.getItemId()){
                    //case R.id.item_rapida:
                        //fragmentSeleccionado = new Rapida();
                        //break;
                    case R.id.item_personales:
                        fragmentSeleccionado = new Personales();
                        break;
                    case R.id.item_laborales:
                        fragmentSeleccionado = new Laborales();
                        break;
                    case R.id.item_home:
                        startActivity(intent);
                        return true;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentSeleccionado).commit();
                return true;
            }
        });
    }
}
