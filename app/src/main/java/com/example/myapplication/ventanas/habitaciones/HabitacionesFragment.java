package com.example.myapplication.ventanas.habitaciones;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.myapplication.databinding.FragmentHabitacionesBinding;



public class HabitacionesFragment extends Fragment {

    private FragmentHabitacionesBinding binding;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //Instancia del VIEW MODEL
        HabitacionesViewModel habitacionesViewModel = new ViewModelProvider(this).get(HabitacionesViewModel.class);








        //Fragment
        binding = FragmentHabitacionesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}