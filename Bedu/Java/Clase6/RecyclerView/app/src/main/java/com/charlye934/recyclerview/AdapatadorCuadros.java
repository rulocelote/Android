package com.charlye934.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapatadorCuadros extends RecyclerView.Adapter<AdapatadorCuadros.ViewHolder>{

    ArrayList<Cuadros> listaCuadros;

    public AdapatadorCuadros(ArrayList<Cuadros> listaCuadros) {
        this.listaCuadros = listaCuadros;
    }

    @NonNull
    @Override
    //Enlaza el adaptador con item_list
    public AdapatadorCuadros.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new ViewHolder(view);
    }

    @Override
    //comunicacion entre nuestro adaptor y la clase viewholder
    public void onBindViewHolder(@NonNull AdapatadorCuadros.ViewHolder holder, int position) {
        holder.tvNombre.setText(listaCuadros.get(position).getNombre());
        holder.tvDescripcion.setText(listaCuadros.get(position).getDescripcion());
        holder.ivImagen.setImageResource(listaCuadros.get(position).getImagen());
        holder.ivFoto.setImageResource(listaCuadros.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaCuadros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvDescripcion;
        ImageView ivImagen,ivFoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = (TextView)itemView.findViewById(R.id.idNombre);
            tvDescripcion = (TextView)itemView.findViewById(R.id.idDescripcion);
            ivImagen = (ImageView)itemView.findViewById(R.id.idImagen);
            ivFoto = (ImageView)itemView.findViewById(R.id.idFoto);
        }
    }
}
