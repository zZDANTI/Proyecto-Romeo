package com.example.myapplication.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.Entity.Habitaciones;
import com.example.myapplication.Entity.Reservas;
import com.example.myapplication.R;
import java.util.List;

public class AdapterReservas extends BaseAdapter {

    Context context;

    LayoutInflater inflater;

    List<Reservas> listadoReservas;


    public AdapterReservas(Context context, List<Reservas>listadoReservas) {
        this.context = context;
        this.inflater = (LayoutInflater.from(context));
        this.listadoReservas = listadoReservas;
    }

    @Override
    public int getCount() {
        return listadoReservas.size();
    }

    @Override
    public Object getItem(int i) {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.custom_reservas_view, viewGroup, false);
        TextView precio= view.findViewById(R.id.precio);
        ImageView imageView = view.findViewById(R.id.imagenReserva);
        TextView txNombre = view.findViewById(R.id.titulo);
        TextView txtDescp = view.findViewById(R.id.descripcion);
        txNombre.setText(listadoReservas.get(i).getFechaEntrada());
        txtDescp.setText(listadoReservas.get(i).getFechaSalida());
        if (listadoReservas.get(i).getIdHabitacion()==1){
            imageView.setImageResource(R.drawable.habitacion1);
            precio.setText("50€");
        }
        if (listadoReservas.get(i).getIdHabitacion()==2){
            imageView.setImageResource(R.drawable.habitacion2);
            precio.setText("55€");
        }
        if (listadoReservas.get(i).getIdHabitacion()==3){
            imageView.setImageResource(R.drawable.habitacion3);
            precio.setText("80€");
        }
        if (listadoReservas.get(i).getIdHabitacion()==4){
            imageView.setImageResource(R.drawable.habitacion4);
            precio.setText("40€");
        }
        if (listadoReservas.get(i).getIdHabitacion()==5){
            imageView.setImageResource(R.drawable.habitacion5);
            precio.setText("150€");
        }
        if (listadoReservas.get(i).getIdHabitacion()==6){
            imageView.setImageResource(R.drawable.habitacion6);
            precio.setText("130€");
        }
        if (listadoReservas.get(i).getIdHabitacion()==7){
            imageView.setImageResource(R.drawable.habitacion7);
            precio.setText("140€");
        }

        return view;

    }
}
