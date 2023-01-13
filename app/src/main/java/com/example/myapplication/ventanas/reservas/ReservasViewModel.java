package com.example.myapplication.ventanas.reservas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


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




    }
}