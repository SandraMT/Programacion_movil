package com.example.micro.directorioempleados;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Laborales extends Fragment {

    private TextView txtNumNomina;
    private TextView txtArea;
    private TextView txtPuesto;
    private TextView txtRFC;
    private TextView txtNSS;
    private TextView txtEmergencia;
    private TextView txtEscolaridad;
    private TextView txtStatus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_laborales, container, false);
        asignarDatos(view);
        return view;
    }

    private void asignarDatos(View view) {
        txtNumNomina = view.findViewById(R.id.txtNumNomina);
        txtNumNomina.setText(Vistas.empleado.get(9).toString());
        txtArea = view.findViewById(R.id.txtArea);
        txtArea.setText(Vistas.empleado.get(10).toString());
        txtPuesto = view.findViewById(R.id.txtPuesto);
        txtPuesto.setText(Vistas.empleado.get(11).toString());
        txtRFC = view.findViewById(R.id.txtRFC);
        txtRFC.setText(Vistas.empleado.get(12).toString());
        txtNSS = view.findViewById(R.id.txtNSS);
        txtNSS.setText(Vistas.empleado.get(13).toString());
        txtEmergencia = view.findViewById(R.id.txtEmergencia);
        txtEmergencia.setText(Vistas.empleado.get(14).toString());
        txtEscolaridad = view.findViewById(R.id.txtEscolaridad);
        txtEscolaridad.setText(Vistas.empleado.get(15).toString());
        txtStatus = view.findViewById(R.id.txtStatus);
        txtStatus.setText(Vistas.empleado.get(16).toString());
    }
}