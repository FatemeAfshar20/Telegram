package com.example.telegram.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.telegram.database.Repository.UserDBRepository;
import com.example.telegram.model.User;

import java.util.UUID;

public class ContactPageViewModel extends AndroidViewModel {
    private UserDBRepository mRepository;
    private UUID mUserId;

    public ContactPageViewModel(@NonNull Application application) {
        super(application);
        mRepository=UserDBRepository.getInstance(application);
    }

    public void setUserId(UUID userId) {
        mUserId = userId;
    }

    public User getUser(){
        return mRepository.get(mUserId);
    }
}
