package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.lifecycle.LiveData;

import com.example.myapplication.Daos.HabitacionDao;
import com.example.myapplication.Entity.Habitaciones;

import java.util.List;

public class Adapter extends BaseAdapter {


    Context context;

    LayoutInflater inflater;

    List<Habitaciones> listaHabitaciones;


    public Adapter(Context context, List<Habitaciones>listaHabitaciones) {
        this.context = context;
        this.inflater = (LayoutInflater.from(context));
        this.listaHabitaciones = listaHabitaciones;
    }

    @Override
    public int getCount() {
        return listaHabitaciones.size();
    }

    @Override
    public Object getItem(int i) {
        return listaHabitaciones.get(i).getId();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.custom_view, viewGroup, false);
        ImageView miniImagen = view.findViewById(R.id.imageView);
        miniImagen.setImageResource(listaHabitaciones.get(i).getImagen());
        TextView txNombre = view.findViewById(R.id.textTitle);
        TextView txtDescp = view.findViewById(R.id.textDesc);
        TextView txtPrecio = view.findViewById(R.id.textPrice);
        TextView txtId = view.findViewById(R.id.textIdHabitacion);
        txNombre.setText(listaHabitaciones.get(i).getNombre());
        txtDescp.setText(listaHabitaciones.get(i).getDescrip());
        String num = String.valueOf(listaHabitaciones.get(i).getPrecio());
        txtPrecio.setText(num + "DH");
        num = String.valueOf(listaHabitaciones.get(i).getId());
        txtId.setText(num);
        return view;

    }
}
