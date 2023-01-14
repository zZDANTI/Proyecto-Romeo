package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.ventanas.login.LoginFragment;
import com.example.myapplication.ventanas.register.RegisterFragment;

public class MainActivity extends AppCompatActivity {

    Button botonLogin, botonRegister;
    Fragment login,register;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonLogin = findViewById(R.id.login);
        botonRegister = findViewById(R.id.register);

        register = new RegisterFragment();
        login = new LoginFragment();

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().add(R.id.inicioAPP,login).commit();
                botonLogin.setVisibility(View.GONE);
                botonRegister.setVisibility(View.GONE);
            }
        });
        botonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().add(R.id.inicioAPP,register).commit();
                botonLogin.setVisibility(View.GONE);
                botonRegister.setVisibility(View.GONE);
            }
        });









    }
}