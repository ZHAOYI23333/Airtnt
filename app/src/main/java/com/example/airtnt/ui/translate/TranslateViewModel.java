package com.example.airtnt.ui.translate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TranslateViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TranslateViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Translate from Lang1 to Lang2");
    }

    public LiveData<String> getText() {
        return mText;
    }
}