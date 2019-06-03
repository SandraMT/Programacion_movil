package com.example.mireles.arquitectura_android.adapters;
/*
 * @author Sandra Mireles
 * @version 1.0
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.mireles.arquitectura_android.model.Message;
import java.util.List;

public class RVMessageAdapter extends RecyclerView.Adapter<RVMessageAdapter.RVMessageAdapterViewHolder> {
    private Context context;
    private List<Message> messages;

    /*
    * Hace referencia a la lista
    * @return Lista
    * */
    public RVMessageAdapter(Context context, List<Message> messages){
        this.context = context;
        this.messages = this.messages;
    }

    @NonNull
    @Override
    /*
    * Crea la instancia principal , esta se recicla
    * @return class RVMessageAdapterViewHolder
    * */
    public RVMessageAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(
                                                    R.layout.item_rv_message, //falta crear algo en XML
                                                    viewGroup,
                                                    false);
        return new RVMessageAdapterViewHolder(view);
    }

    @Override
    /*
    * Instancia para cada uno de los elementos que hay.
    * @param Elementos usados en XML
    * */
    public void onBindViewHolder(@NonNull RVMessageAdapterViewHolder rvMessageAdapterViewHolder, int i) {
        Message message = messages.get(i);

        //falta crear los view en los XML
        rvMessageAdapterViewHolder.textViewUsername.set(message.getUserName());
        rvMessageAdapterViewHolder.textViewTitle.set(message.getTitle());
        rvMessageAdapterViewHolder.textViewDescription.set(message.getDescription());
        rvMessageAdapterViewHolder.textViewHour.set(message.getHour());

        // Aqui poner las cosas para que realice otro desmadre al hacer click

    }

    @Override
    /*
    * Contador de los item para mostrar
    * @return
    * 0*/
    public int getItemCount() {
        return 0;
    }

    public class RVMessageAdapterViewHolder extends RecyclerView.ViewHolder{
        TextView textViewUserName;
        TextView textViewTitle;
        TextView textViewDescription;
        TextView textViewHour;

        /*
        * Encuentra cada uno de los elementos utilizados en XML para vincularlo a la vista
        * @param Vista
        */
        public RVMessageAdapterViewHolder (View view){
            super(view);

            // no aparece el id porque no los he creado
            textViewUserName = view.findViewById(R.id.tv_username);
            textViewTitle = view.findViewById(R.id.tv_title);
            textViewDescription = view.findViewById(R.id.tv_description);
            textViewHour = view.findViewById(R.id.tv_hour);

        }
    }
}

