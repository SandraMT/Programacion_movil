package com.example.micro.directorioempleados;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Personales extends Fragment {

    private TextView txtNombre;
    private TextView txtApellidos;
    private TextView txtDireccion;
    private TextView txtTelefono;
    private TextView txtCorreo;
    private TextView txtNacionalidad;
    private TextView txtEstadoCivil;
    private TextView txtEnfermedades;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personales, container, false);
        asignarDatos(view);
        return view;
    }

    private void asignarDatos(View view) {
        txtNombre = view.findViewById(R.id.txtNombre);
        txtNombre.setText(Vistas.empleado.get(1).toString());
        txtApellidos = view.findViewById(R.id.txtApellidos);
        txtApellidos.setText(Vistas.empleado.get(2).toString());
        txtDireccion = view.findViewById(R.id.txtDireccion);
        txtDireccion.setText(Vistas.empleado.get(3).toString());
        txtTelefono = view.findViewById(R.id.txtTelefono);
        txtTelefono.setText(Vistas.empleado.get(4).toString());
        txtCorreo = view.findViewById(R.id.txtCorreo);
        txtCorreo.setText(Vistas.empleado.get(5).toString());
        txtNacionalidad = view.findViewById(R.id.txtNacionalidad);
        txtNacionalidad.setText(Vistas.empleado.get(6).toString());
        txtEstadoCivil = view.findViewById(R.id.txtEstadoCivil);
        txtEstadoCivil.setText(Vistas.empleado.get(7).toString());
        txtEnfermedades = view.findViewById(R.id.txtEnfermedades);
        txtEnfermedades.setText(Vistas.empleado.get(8).toString());


    }
}