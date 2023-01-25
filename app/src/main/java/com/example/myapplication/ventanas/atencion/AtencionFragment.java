package com.example.myapplication.ventanas.atencion;

import android.content.Intent;
import android.net.Uri;
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

        binding.numeroHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number= Uri.parse("tel:682924866");
                Intent callIntent = new Intent(Intent.ACTION_DIAL,number);
                startActivity(callIntent);
            }
        });

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}