package com.example.telegram.view.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.telegram.R;
import com.example.telegram.databinding.ContainerBinding;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fragment fragment=getSupportFragmentManager().
                findFragmentById(R.id.fragment_container);

        if (fragment==null)
            getSupportFragmentManager().
                    beginTransaction().
                    add(R.id.fragment_container,getFragment()).
                    commit();
    }

    public abstract Fragment getFragment();
}
