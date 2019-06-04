package com.example.micro.directorioempleados;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class RVEmpleadosAdapter extends RecyclerView.Adapter<RVEmpleadosAdapter.RVMessageAdapterViewHolder> {
    private Context context;
    private List<Empleados> listaEmpleados;
    private ArrayList<String> datosEmpleados;

    public RVEmpleadosAdapter(Context context, List<Empleados> listaEmpleados) {
        this.context = context;
        this.listaEmpleados = listaEmpleados;
    }

    @NonNull
    @Override
    public RVMessageAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(
                R.layout.item_rv_message,
                viewGroup,
                false);
        return new RVMessageAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVMessageAdapterViewHolder rvMessageAdapterViewHolder, int i) {
        final Empleados emp = listaEmpleados.get(i);
        rvMessageAdapterViewHolder.textViewNonima.setText(emp.getNumNomina());
        rvMessageAdapterViewHolder.textViewNombre.setText(emp.getNombre());
        rvMessageAdapterViewHolder.textViewApellidos.setText(emp.getApellidos());
        rvMessageAdapterViewHolder.textPuesto.setText(emp.getPuesto());

        rvMessageAdapterViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Vistas.class);
                asignarArreglo(emp);
                intent.putExtra("empleados",datosEmpleados);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listaEmpleados.size();
    }


    public class RVMessageAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNonima;
        TextView textViewNombre;
        TextView textViewApellidos;
        TextView textPuesto;

        public RVMessageAdapterViewHolder(View view) {
            super(view);
            textViewNonima = view.findViewById(R.id.tv_nomina);
            textViewNombre = view.findViewById(R.id.tv_nombre);
            textViewApellidos = view.findViewById(R.id.tv_apellidos);
            textPuesto = view.findViewById(R.id.tv_puesto);
        }
    }

    private void asignarArreglo(Empleados empleado) {
        datosEmpleados = new ArrayList<>();
        datosEmpleados.add(empleado.getImagen());
        datosEmpleados.add(empleado.getNombre());
        datosEmpleados.add(empleado.getApellidos());
        datosEmpleados.add(empleado.getDireccion());
        datosEmpleados.add(empleado.getTelefono());
        datosEmpleados.add(empleado.getCorreo());
        datosEmpleados.add(empleado.getNacionalidad());
        datosEmpleados.add(empleado.getEstadoCivil());
        datosEmpleados.add(empleado.getEnfermedades());
        datosEmpleados.add(empleado.getNumNomina());
        datosEmpleados.add(empleado.getArea());
        datosEmpleados.add(empleado.getPuesto());
        datosEmpleados.add(empleado.getRFC());
        datosEmpleados.add(empleado.getNSS());
        datosEmpleados.add(empleado.getContactoEmergencia());
        datosEmpleados.add(empleado.getEscolaridad());
        datosEmpleados.add(empleado.getStatus());
    }
}
