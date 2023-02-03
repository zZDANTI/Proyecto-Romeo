package com.example.myapplication.ventanas.cliente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentClienteBinding;
import com.example.myapplication.Entity.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteFragment extends Fragment {


    TextView textView;
    ClienteViewModel clienteViewModel;
    Button button;
    List<Cliente> listado= new ArrayList<Cliente>();;

    private FragmentClienteBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentClienteBinding.inflate(inflater, container, false);
        clienteViewModel=new ViewModelProvider(this).get(ClienteViewModel.class);




        return binding.getRoot();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}