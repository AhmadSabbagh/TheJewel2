package com.am.engsabbagh.thejewel.UI.navigation.offers;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OffersViewModel extends ViewModel {
    private MutableLiveData<String> mText;


    public OffersViewModel()
    {
       mText=new MutableLiveData<>();
       mText.setValue("This is Offers Fragment");
      }

    public LiveData<String>getText()
    {
        return mText;
    }
}