package com.example.myapplication.ventanas.habitaciones;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.myapplication.adaptadores.AdapterHabitaciones;
import com.example.myapplication.Entity.Habitaciones;
import com.example.myapplication.databinding.FragmentHabitacionesBinding;
import com.example.myapplication.ventanas.reservas.HacerReservas;
import com.example.myapplication.R;

import java.util.ArrayList;


public class HabitacionesFragment extends Fragment {


    View v;
    GridView grid;

    private FragmentHabitacionesBinding binding;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Instancia del VIEW MODEL
        HabitacionesViewModel habitacionesViewModel = new ViewModelProvider(this).get(HabitacionesViewModel.class);
        v = inflater.inflate(R.layout.fragment_habitaciones, container, false);
        
        ArrayList<Habitaciones> habitacionList = new ArrayList<>();
        habitacionesViewModel.listadoHabitaciones().observe(getViewLifecycleOwner(),lh ->{

            for (Habitaciones habitacion : lh){

                int id = habitacion.getId();
                String nombreH=habitacion.getNombre();
                int numPersonasH=habitacion.getNumPersonas();
                String descripcionH=habitacion.getDescrip();
                double precioH = habitacion.getPrecio();
                int imagenH=habitacion.getImagen();
                habitacionList.add(new Habitaciones(id,nombreH,numPersonasH,descripcionH,precioH,imagenH));
            }
        });
        grid = v.findViewById(R.id.recyclerView);

        AdapterHabitaciones adapterHabitaciones = new AdapterHabitaciones(getContext(), habitacionList);
        grid.setAdapter(adapterHabitaciones);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                startActivity(new Intent(getContext(), HacerReservas.class)
                        .putExtra("id",habitacionList.get(i).getId())
                        .putExtra("nombreH",habitacionList.get(i).getNombre())
                        .putExtra("numeroP",habitacionList.get(i).getNumPersonas())
                        .putExtra("descripH",habitacionList.get(i).getDescrip())
                        .putExtra("precioH",habitacionList.get(i).getPrecio())
                        .putExtra("imagenH",habitacionList.get(i).getImagen()));

            }
        });




        return v;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}