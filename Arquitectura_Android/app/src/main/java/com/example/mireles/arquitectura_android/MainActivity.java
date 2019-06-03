package com.example.mireles.arquitectura_android;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mireles.arquitectura_android.adapters.RVMessageAdapter;

import java.util.ArrayList;
import java.util.List;

// R E C Y C L E   V I E W
    //recicla la vista generada
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RVMessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<com.example.mireles.arquitectura_android.model.Message> messages = new ArrayList<>();

        messages.add(new com.example.mireles.arquitectura_android.model.Message(
                "Juan Jose", "Examen", "Aqui", "10:30"
        ));
        messages.add(new com.example.mireles.arquitectura_android.model.Message(
                "Sandra", "Codigo", "Checa errores", "10:14"
        ));

        recyclerView = findViewById(R.id.rv_messages);
        adapter = new RVMessageAdapter(this, messages);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                                                                LinearLayoutManager.VERTICAL,
                                                                false));

    }
}
