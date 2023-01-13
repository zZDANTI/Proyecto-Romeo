package com.example.myapplication.ventanas.reservas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentReservasBinding;


public class ReservasFragment extends Fragment {

    private FragmentReservasBinding binding;





    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //Instancia del VIEW MODEL
        ReservasViewModel reservasViewModel = new ViewModelProvider(this).get(ReservasViewModel.class);


        //Fragment
        binding = FragmentReservasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView usuario = container.findViewById(R.id.usuarioPrueba);



        //LLAMA AL TEXTO DE RESERVASVIEW MODEL
        TextView textView = binding.usuarioPrueba;
        reservasViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);























        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}