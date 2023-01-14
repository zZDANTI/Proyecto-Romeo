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


        //listado.add(new Cliente("s","w"));

        try {

            binding.botonInsertar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clienteViewModel.getOneCliente("2").observe(getViewLifecycleOwner(),cliente->{
                        System.out.println(cliente.getNombre());
                    });

                    clienteViewModel.getListadoCliente().observe(getViewLifecycleOwner(),listaCli->{
                        System.out.println("NUM CLIENTES: "+listaCli.size());

                        for (Cliente c: listaCli
                             ) {
                            binding.cliente.append("\n"+c.getId()+"  "+c.getNombre());
                        }

                    });
                      if(listado!=null){
                          Toast.makeText(getContext(), "CLIC NO NULL", Toast.LENGTH_SHORT).show();

                      }
                    else{
                          Toast.makeText(getContext(), "CLIC NULL", Toast.LENGTH_SHORT).show();

                      }


                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }












        return binding.getRoot();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}