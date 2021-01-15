package com.example.telegram.view.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

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
    public static final String ARG_USER_ID = "UserId";
    private ContainerBinding mBinding;
    private NavController mNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this,R.layout.container);
        setListener();

        mNavController= Navigation.findNavController(this,R.id.nav_host_fragment);
    }

    public static final String HOME_FRAGMENT_TAG = "HomeFragmentTag";

    @Override
    public Fragment getFragment() {
        getSupportFragmentManager().
                beginTransaction().
                add(R.id.nav_host_fragment,
                        HomeFragment.newInstance(),
                        HOME_FRAGMENT_TAG);
        return HomeFragment.newInstance();
    }

    @Override
    public void onItemSelectedListener(UUID userId) {
        Bundle bundle=new Bundle();
        bundle.putSerializable(ARG_USER_ID,userId);

        NavDirections navDirections=new NavDirections() {
            @Override
            public int getActionId() {
                return R.id.action_des_home_fragment_to_des_contact_page_fragment;
            }

            @NonNull
            @Override
            public Bundle getArguments() {
                return bundle;
            }
        };

        mNavController.navigate(navDirections);
    }

    private void setListener(){
        mBinding.btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().
                        beginTransaction().
                        add(R.id.nav_host_fragment,
                                HomeFragment.newInstance()).
                        commit();
            }
        });

        mBinding.btnGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavOptions optionBuilder=
                        new NavOptions.Builder().
                                setEnterAnim(android.R.anim.fade_in).
                                setExitAnim(android.R.anim.fade_out).
                                setPopExitAnim(android.R.anim.slide_out_right).
                                build();

                mNavController.navigate(R.id.des_group_fragment,null,optionBuilder);
            }
        });

        mBinding.btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().
                        beginTransaction().
                        addToBackStack(HOME_FRAGMENT_TAG).
                        add(R.id.nav_host_fragment,
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
                        add(R.id.nav_host_fragment,
                                ChannelFragment.newInstance()).
                        commit();
            }
        });
    }
}