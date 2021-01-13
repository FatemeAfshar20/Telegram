package com.example.telegram.viewModel;

import android.app.Application;
import android.text.Editable;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.telegram.database.Repository.UserDBRepository;
import com.example.telegram.model.User;

public class AddUserViewModel extends AndroidViewModel {
    private UserDBRepository mRepository;
    private User mUser=new User();

    public AddUserViewModel(@NonNull Application application) {
        super(application);

        mRepository=UserDBRepository.getInstance(application);
    }

    public void afterTextNameChanged(Editable editable){
        mUser.setName(editable.toString());
    }

    public void afterTextPhoneNumberChanged(Editable editable){
        mUser.setPhoneNumber(editable.toString());
    }

    public void onAddContactClickListener(){
        mRepository.insert(mUser);
    }
}
