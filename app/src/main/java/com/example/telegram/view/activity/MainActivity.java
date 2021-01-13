package com.example.telegram.view.activity;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.telegram.R;
import com.example.telegram.databinding.ContainerBinding;
import com.example.telegram.view.fragment.AddContactFragment;
import com.example.telegram.view.fragment.ChannelFragment;
import com.example.telegram.view.fragment.ContactPageFragment;
import com.example.telegram.view.fragment.GroupFragment;
import com.example.telegram.view.fragment.HomeFragment;

import java.util.UUID;

public class MainActivity extends SingleFragmentActivity
        implements HomeFragment.HomePageFragmentCallback {
    private ContainerBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this,R.layout.container);
        setListener();
    }

    public static final String HOME_FRAGMENT_TAG = "HomeFragmentTag";

    @Override
    public Fragment getFragment() {
        getSupportFragmentManager().
                beginTransaction().
                add(R.id.fragment_container,
                        HomeFragment.newInstance(),
                        HOME_FRAGMENT_TAG);
        return HomeFragment.newInstance();
    }

    @Override
    public void onItemSelectedListener(UUID userId) {
        getSupportFragmentManager().
                beginTransaction().
                addToBackStack(HOME_FRAGMENT_TAG).
                add(R.id.fragment_container,
                        ContactPageFragment.newInstance(userId)).
                commit();
    }

    private void setListener(){
        mBinding.btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().
                        beginTransaction().
                        add(R.id.fragment_container,
                                HomeFragment.newInstance()).
                        commit();
            }
        });

        mBinding.btnGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().
                        beginTransaction().
                        addToBackStack(HOME_FRAGMENT_TAG).
                        add(R.id.fragment_container,
                                GroupFragment.newInstance()).
                        commit();
            }
        });

        mBinding.btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().
                        beginTransaction().
                        addToBackStack(HOME_FRAGMENT_TAG).
                        add(R.id.fragment_container,
                                AddContactFragment.newInstance()).
                        commit();
            }
        });

        mBinding.btnChannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().
                        beginTransaction().
                        addToBackStack(HOME_FRAGMENT_TAG).
                        add(R.id.fragment_container,
                                ChannelFragment.newInstance()).
                        commit();
            }
        });
    }
}