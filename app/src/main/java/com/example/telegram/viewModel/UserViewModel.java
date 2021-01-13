package com.example.telegram.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.telegram.database.Repository.UserDBRepository;
import com.example.telegram.model.User;

import java.util.UUID;

public class UserViewModel extends AndroidViewModel {
    private UserDBRepository mRepository;
    private User mUser;

    public UserViewModel(@NonNull Application application) {
        super(application);
        mRepository=UserDBRepository.getInstance(application);
    }

    public void setUserId(UUID userId){
        mUser=mRepository.get(userId);
    }

    public User getUser() {
        return mUser;
    }
}
