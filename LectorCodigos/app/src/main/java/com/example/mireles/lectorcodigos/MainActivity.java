package com.example.mireles.lectorcodigos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_resultado = (TextView) findViewById(R.id.tv_resultado);
    }
    public void scanner (View v){
        new IntentIntegrator (MainActivity.this).initiateScan();
    }

    protected void onActivityResult
}
