package com.abhinandan.mvvm_example;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<Places>> places;
    private DataRepository dataRepository;

    public LiveData<List<Places>> getPlaces(Context context){

        if(places == null){
            places = new MutableLiveData<>();
            dataRepository =  DataRepository.getInstance();
            places =  dataRepository.fetchData(context);
        }
        return places;
    }
}
