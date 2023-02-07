package com.example.myapplication.ventanas.reservas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Entity.Reservas;
import com.example.myapplication.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class HacerReservas extends AppCompatActivity {

    ImageView imagenHabitacion;
    TextView nombreHabitacion, suiteCamasPrecioHabitacion, descripcionHabitacion, fechaInicioReserva, fechaFinReserva;
    Button reservarHabitacion;
    ReservasViewModel reservasViewModel;
    SharedPreferences sharedPreferences;
    String descripcion, nombreH;
    double precio;
    int numeroPersonas,imagen,dia, mes, anyo, id;
    int idCliente=1;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_max_info_reservar);
        Intent intent=getIntent();
        sharedPreferences=getSharedPreferences("datos", Context.MODE_PRIVATE);
        imagenHabitacion=findViewById(R.id.infoImagenHabitacion);
        nombreHabitacion=findViewById(R.id.infoNombreHabitacion);
        suiteCamasPrecioHabitacion=findViewById(R.id.infoSuiteCamasPrecioHabitaciones);
        descripcionHabitacion=findViewById(R.id.infoDescripcionHabitaciones);
        fechaInicioReserva=findViewById(R.id.insertarFechaInicioReservaHabitacion);
        fechaFinReserva=findViewById(R.id.insertarFechaFinReservaHabitacion);
        reservarHabitacion=findViewById(R.id.reservarHabitacion);
        id=intent.getIntExtra("id",0);
        numeroPersonas=intent.getIntExtra("numeroP",0);
        nombreH=intent.getStringExtra("nombreH");
        precio=intent.getDoubleExtra("precioH",0);
        descripcion=intent.getStringExtra("descripH");
        imagen=intent.getIntExtra("imagenH",0);
        imagenHabitacion.setImageResource(imagen);
        nombreHabitacion.setText(nombreH);
        suiteCamasPrecioHabitacion.setText("Nº Personas: "+numeroPersonas+" \nPrecio: "+precio+"€ por noche");
        descripcionHabitacion.setText(descripcion);
        reservasViewModel= new ViewModelProvider(this).get(ReservasViewModel.class);
    }

    public void InicioReserva(View view){
        final Calendar calendar= Calendar.getInstance();
        dia=calendar.get(Calendar.DAY_OF_MONTH);
        mes=calendar.get(Calendar.MONTH);
        anyo=calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int anyo, int mes, int dia) {
                String fecha=String.valueOf(anyo)+"-"+String.valueOf(mes+1)+"-"+String.valueOf(dia);
                fechaInicioReserva.setText(fecha);
            }
        }
                ,anyo,mes,dia);
        datePickerDialog.show();
    }

    public void SalidaReserva(View view){
        final Calendar calendar=Calendar.getInstance();
        dia=calendar.get(Calendar.DAY_OF_MONTH);
        mes=calendar.get(Calendar.MONTH);
        anyo=calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int anyo, int mes, int dia) {
                String fecha=String.valueOf(anyo)+"-"+String.valueOf(mes+1)+"-"+String.valueOf(dia);
                fechaFinReserva.setText(fecha);
            }
        }
                ,anyo,mes,dia);
        datePickerDialog.show();
    }

    public void Reservar(View view){
        if (fechaInicioReserva.getText().toString().equals("")||fechaFinReserva.getText().toString().equals("")){
            Toast.makeText(this,"Revise los campos, no pueden estar vacios", Toast.LENGTH_SHORT).show();
        }else {
            String fechaInicio=fechaInicioReserva.getText().toString();
            String fechaFin=fechaFinReserva.getText().toString();

            SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");

            try {
                long miliseconds = System.currentTimeMillis();
                Date hoy1 = new Date(miliseconds);
                Calendar calendar=new GregorianCalendar();
                String hoy=calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DAY_OF_MONTH);
                Date fechaInicio1 = dateFormat.parse(fechaInicio);
                Date fechaFin1 = dateFormat.parse(fechaFin);

                if(fechaInicio1.after(fechaFin1)||fechaInicio1.before(hoy1)){
                    Toast.makeText(this,"No coinciden las fechas",Toast.LENGTH_SHORT).show();
                }else {
                    reservasViewModel.todasReservas().observe(this,
                            mR->{
                                if (mR!=null){
                                    Date fechaInicioR;
                                    Date fechaFinR;
                                    int x=0;
                                    boolean reserva=true;
                                    for(Reservas valor : mR){
                                        if (valor.getIdHabitacion()==id){
                                            try {
                                                fechaInicioR=dateFormat.parse(valor.getFechaEntrada());
                                                fechaFinR=dateFormat.parse(valor.getFechaSalida());
                                                if(fechaInicio1.before(fechaFinR)&&fechaInicio1.after(fechaInicioR)){
                                                    reserva=false;
                                                }
                                                if (fechaInicio1.equals(fechaInicioR)||fechaInicio1.equals(fechaFinR)){
                                                    reserva=false;
                                                }
                                                if(fechaFin1.before(fechaFinR)&&fechaFin1.after(fechaInicioR)){
                                                    reserva=false;
                                                }
                                                if (fechaFin1.equals(fechaInicioR)||fechaFin1.equals(fechaFinR)){
                                                    reserva=false;
                                                }
                                            } catch (ParseException e) {
                                                throw new RuntimeException(e);
                                            }
                                        }
                                    }
                                    if (reserva){
                                        Toast.makeText(this,"Reserva hecha correctamente",Toast.LENGTH_SHORT).show();
                                        x++;

                                        reservasViewModel.insertarReserva(new Reservas(fechaInicio,fechaFin,id,sharedPreferences.getString("emailUsuario","")));

                                        finish();

                                    }else {
                                        if (x==0){
                                            x++;
                                            Toast.makeText(this,"Habitacion ocupada",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            }
                    );
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }



        }
    }
}