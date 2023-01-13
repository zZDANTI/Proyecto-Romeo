package com.example.myapplication.ventanas.atencion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AtencionViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    

    public AtencionViewModel() {
        mText = new MutableLiveData<>();

    }

    public LiveData<String> getText() {
        return mText;
    }

}


