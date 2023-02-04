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
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.example.myapplication.Adapter;
import com.example.myapplication.Entity.Habitaciones;
import com.example.myapplication.R;
import com.example.myapplication.databinding.CustomViewBinding;
import com.example.myapplication.databinding.FragmentClienteBinding;
import com.example.myapplication.databinding.FragmentHabitacionesBinding;
import com.example.myapplication.ventanas.habitaciones.HabitacionesViewModel;

import java.util.List;


public class HabitacionesFragment extends Fragment {


    View v;
    GridView grid;

    private FragmentHabitacionesBinding binding;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Instancia del VIEW MODEL
        HabitacionesViewModel habitacionesViewModel = new ViewModelProvider(this).get(HabitacionesViewModel.class);
        v = inflater.inflate(R.layout.fragment_habitaciones, container, false);

        LiveData<List<Habitaciones>> habitacionList = habitacionesViewModel.listadoHabitaciones();
        grid = v.findViewById(R.id.recyclerView);

        Adapter adapter  = new Adapter(getContext(), habitacionList);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String idHab = String.valueOf(habitacionList.getValue().get(i).id);


            }
        });



        View root = binding.getRoot();
        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}