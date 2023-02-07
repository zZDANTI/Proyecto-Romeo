package com.example.myapplication.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.myapplication.Entity.Habitaciones;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterHabitaciones extends BaseAdapter {


    Context context;

    LayoutInflater inflater;

    List<Habitaciones> listaHabitaciones;


    public AdapterHabitaciones(Context context, List<Habitaciones>listaHabitaciones) {
        this.context = context;
        this.inflater = (LayoutInflater.from(context));
        this.listaHabitaciones = listaHabitaciones;
    }

    public AdapterHabitaciones(Context context) {
        this.context = context;
        this.inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        if (listaHabitaciones !=null){
            return listaHabitaciones.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return listaHabitaciones.get(i).getId();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public void setHabitaciones(List<Habitaciones> arrayHabitacion){

        listaHabitaciones = arrayHabitacion;
        notifyDataSetChanged();

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.custom_view, viewGroup, false);
        ImageView miniImagen = view.findViewById(R.id.imageView);
        TextView txNombre = view.findViewById(R.id.textTitle);
        TextView txtDescp = view.findViewById(R.id.textDesc);
        TextView txtPrecio = view.findViewById(R.id.textPrice);
        TextView txtId = view.findViewById(R.id.textIdHabitacion);
        txNombre.setText(listaHabitaciones.get(i).getNombre());
        txtDescp.setText(listaHabitaciones.get(i).getDescrip());
        miniImagen.setImageResource(listaHabitaciones.get(i).getImagen());
        String num = String.valueOf(listaHabitaciones.get(i).getPrecio());
        txtPrecio.setText(num + "€");
        num = String.valueOf(listaHabitaciones.get(i).getId());
        txtId.setText(num);
        return view;

    }
}
