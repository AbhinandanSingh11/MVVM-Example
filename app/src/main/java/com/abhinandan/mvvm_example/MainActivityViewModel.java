package com.abhinandan.mvvm_example;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<Places>> places;

    public LiveData<List<Places>> getPlaces(){

        if(places == null){
            places = new MutableLiveData<>();
        }
        return places;
    }

    public void init(){

    }
}
