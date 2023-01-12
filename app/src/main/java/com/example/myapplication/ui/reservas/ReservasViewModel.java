package com.example.myapplication.ui.reservas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Database;
import androidx.room.Room;

import com.example.myapplication.basedatos.Usuario;

import java.util.List;

public class ReservasViewModel extends ViewModel {

    private final MutableLiveData<String> mText;


    public ReservasViewModel() {
        this.mText = new MutableLiveData<>();
    }




    public LiveData<String> getText() {


        mText.setValue("This is resebfgbnertgbnrvas fragment");
        return mText;
    }
    public void usuarios(){

        List<Usuario> listaUsuario;
        Database database = Room.databaseBuilder(gey)


    }
}