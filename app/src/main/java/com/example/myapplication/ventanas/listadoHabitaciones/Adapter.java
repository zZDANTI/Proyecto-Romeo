package com.example.myapplication.ventanas.listadoHabitaciones;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.myapplication.Entity.Habitaciones;

import java.util.List;

public class Adapter extends BaseAdapter {


    Context context;

    LayoutInflater inflater;

    List<Habitaciones> listaHabitaciones;


    public Adapter(Context context, List<Habitaciones> listaHabitaciones) {
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
        return listaHabitaciones.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.custom_view, viewGroup, false);

        return view;

    }
}
