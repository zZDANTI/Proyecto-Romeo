package com.example.myapplication.ventanas.atencion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentAtencionBinding;
import com.example.myapplication.ventanas.login.LoginFragment;
import com.example.myapplication.ventanas.register.RegisterFragment;


public class AtencionFragment extends Fragment {



    private FragmentAtencionBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        AtencionViewModel atencionViewModel =
                new ViewModelProvider(this).get(AtencionViewModel.class);

        binding = FragmentAtencionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        final TextView textView = binding.mensajeCorreo;
        atencionViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}