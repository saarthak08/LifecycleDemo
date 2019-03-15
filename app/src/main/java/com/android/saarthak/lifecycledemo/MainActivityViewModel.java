package com.android.saarthak.lifecycledemo;

import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private int clickCount=0;

    public  int getCurrentCount(){

        clickCount+=1;
        return clickCount;
    }


    public  int getInitialCount(){
        return clickCount;
    }

}
