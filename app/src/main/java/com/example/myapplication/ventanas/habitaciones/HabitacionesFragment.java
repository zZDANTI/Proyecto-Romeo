package com.example.myapplication.ventanas.habitaciones;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.myapplication.adaptadores.AdapterHabitaciones;
import com.example.myapplication.Entity.Habitaciones;
import com.example.myapplication.databinding.FragmentClienteBinding;
import com.example.myapplication.databinding.FragmentHabitacionesBinding;
import com.example.myapplication.ventanas.reservas.HacerReservas;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;


public class HabitacionesFragment extends Fragment {


    //View v;
    GridView grid;
    TextView textoPrueba;

    HabitacionesViewModel habitacionesViewModel;
    ArrayList<Habitaciones> habitacionList = new ArrayList<>();

    private FragmentHabitacionesBinding binding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        habitacionesViewModel = new ViewModelProvider(this).get(HabitacionesViewModel.class);

    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Instancia del VIEW MODEL
        //v = inflater.inflate(R.layout.fragment_habitaciones, container, false);

        AdapterHabitaciones adapterHabitaciones = new AdapterHabitaciones(getContext());

         binding = FragmentHabitacionesBinding.inflate(inflater, container, false);
         habitacionesViewModel.listadoHabitaciones().observe(getViewLifecycleOwner(),adapterHabitaciones::setHabitaciones);


        grid = binding.recyclerView;

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




        return binding.getRoot();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}