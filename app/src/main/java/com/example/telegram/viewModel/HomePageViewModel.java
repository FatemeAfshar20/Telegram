package com.example.telegram.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.telegram.database.Repository.UserDBRepository;
import com.example.telegram.model.User;

import java.util.List;

public class HomePageViewModel extends AndroidViewModel {
    private UserDBRepository mRepository;

    public HomePageViewModel(@NonNull Application application) {
        super(application);
        mRepository=UserDBRepository.getInstance(application);
    }

    public List<User> getUserList(){
        return mRepository.getList();
    }
}
