package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Entity.Cliente;
import com.example.myapplication.Repositorios.ClientesRepositorio;
import com.example.myapplication.ventanas.login.LoginFragment;
import com.example.myapplication.ventanas.register.RegisterFragment;

public class MainActivity extends AppCompatActivity {

    Button botonLogin, botonRegister, salir;
    Fragment login,register;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonLogin = findViewById(R.id.inicioLogin);
        botonRegister = findViewById(R.id.registerBoton);
        salir = findViewById(R.id.exit);
        register = new RegisterFragment();
        login = new LoginFragment();
        salir.setVisibility(View.GONE);


        // Te lleva al login

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().add(R.id.inicioAPP,login).commit();
                botonLogin.setVisibility(View.GONE);
                salir.setVisibility(View.VISIBLE);
            }
        });



        //Te lleva al registro
        botonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.inicioAPP,register).commit();
                salir.setVisibility(View.VISIBLE);
                botonLogin.setVisibility(View.GONE);
                botonRegister.setVisibility(View.GONE);
            }
        });

        // Te lleva al inicio del login

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSupportFragmentManager().beginTransaction().remove(register).commit();
                getSupportFragmentManager().beginTransaction().remove(login).commit();
                salir.setVisibility(View.GONE);
                botonLogin.setVisibility(View.VISIBLE);
                botonRegister.setVisibility(View.VISIBLE);


            }
        });



    }
}