package com.example.myapplication.ventanas.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.BaseDatos.BaseDatos;
import com.example.myapplication.MainActivity;
import com.example.myapplication.Menu;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.databinding.FragmentLoginBinding;
import com.example.myapplication.ventanas.cliente.ClienteViewModel;
import com.example.myapplication.ventanas.register.RegisterFragment;


public class LoginFragment extends Fragment {

    SharedPreferences sharedPreferences;
    String emailCliente;
    CheckBox recordarContra;
    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        LoginViewModel loginViewModel=new ViewModelProvider(this).get(LoginViewModel.class);

        sharedPreferences=getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);

        recordarContra=(CheckBox) binding.recordarContrasenya;

        binding.emailLogin.setText(sharedPreferences.getString("email",""));
        binding.contrasenyaLogin.setText(sharedPreferences.getString("contrasenya",""));
        recordarContra.setChecked(false);
        if (!(sharedPreferences.getString("email","").length()==0)){
            recordarContra.setChecked(true);
        }


        try {
            binding.loginInicio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(!(binding.emailLogin.getText().toString().isEmpty()|| binding.contrasenyaLogin.getText().toString().isEmpty())){

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {

                                        loginViewModel.validarUsuario(binding.emailLogin.getText().toString()).observe(getActivity(),ec->{

                                            if (ec==null){

                                                Toast.makeText(getContext(),"Usuario no encontrado", Toast.LENGTH_SHORT).show();
                                            }else {

                                                if (ec.getPassword().equals(binding.contrasenyaLogin.getText().toString())) {
                                                    SharedPreferences.Editor editor=sharedPreferences.edit();
                                                    if (recordarContra.isChecked()){
                                                        editor.putString("email",binding.emailLogin.getText().toString());
                                                        editor.putString("contrasenya",binding.contrasenyaLogin.getText().toString());
                                                    }else {
                                                        editor.putString("email","");
                                                        editor.putString("contrasenya","");
                                                    }
                                                    editor.putString("emailUsuario",binding.emailLogin.getText().toString());
                                                    editor.commit();
                                                    startActivity(new Intent(getActivity(), Menu.class));
                                                    getActivity().onBackPressed();
                                                } else {
                                                    Toast.makeText(getContext(), "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                                                }

                                            }

                                        });
                                    }
                                });


                                


                            }
                        }).start();



                    }else{
                        Toast.makeText(getContext(),"La contraseña o el email es incorrecto", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }catch (NullPointerException e){
            e.getMessage();
        }




        return binding.getRoot();
    }



}