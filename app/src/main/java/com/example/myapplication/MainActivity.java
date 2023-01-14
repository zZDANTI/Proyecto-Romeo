package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        botonLogin = findViewById(R.id.login);
        botonRegister = findViewById(R.id.register);
        salir = findViewById(R.id.exit);
        register = new RegisterFragment();
        login = new LoginFragment();
        salir.setVisibility(View.GONE);

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().add(R.id.inicioAPP,login).commit();
                botonLogin.setVisibility(View.GONE);
                salir.setVisibility(View.VISIBLE);
            }
        });
        botonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.inicioAPP,register).commit();
                salir.setVisibility(View.VISIBLE);
                botonLogin.setVisibility(View.GONE);
                botonRegister.setVisibility(View.GONE);
            }
        });

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