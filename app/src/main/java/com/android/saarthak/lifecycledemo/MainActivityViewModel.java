package com.android.saarthak.lifecycledemo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private int clickCount=0;
    private int initialValue;

    public MainActivityViewModel(int initialValue) {
        this.initialValue = initialValue;
    }

    private MutableLiveData<Integer> mutableLiveData= new MutableLiveData<>();

    public  MutableLiveData<Integer> getCount(){

        mutableLiveData.setValue(clickCount+initialValue);
        return mutableLiveData;
    }


    public  void IncreaseCount(){
        clickCount+=1;
        mutableLiveData.setValue(clickCount+initialValue);
    }

}
