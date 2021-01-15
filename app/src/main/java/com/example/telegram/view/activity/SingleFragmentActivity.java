package com.example.telegram.view.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.telegram.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fragment fragment=getSupportFragmentManager().
                findFragmentById(R.id.nav_host_fragment);

        if (fragment==null)
            getSupportFragmentManager().
                    beginTransaction().
                    add(R.id.nav_host_fragment,getFragment()).
                    commit();
    }

    public abstract Fragment getFragment();
}
