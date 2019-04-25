package com.android.saarthak.lifecycledemo;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainActivityViewModelFactory implements ViewModelProvider.Factory {
    private int initialValue;

    public MainActivityViewModelFactory(int initialValue) {
        this.initialValue = initialValue;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new MainActivityViewModel(initialValue);
    }
}
