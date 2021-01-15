package com.example.telegram.view.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.telegram.R;
import com.example.telegram.adapter.UserAdapter;
import com.example.telegram.databinding.FragmentHomeBinding;
import com.example.telegram.viewModel.HomePageViewModel;

import java.util.UUID;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding mBinding;
    private UserAdapter mAdapter;

    private HomePageViewModel mViewModel;

    private HomePageFragmentCallback mCallback;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof HomePageFragmentCallback)
            mCallback=(HomePageFragmentCallback) context;
        else
            throw new ClassCastException
                    ("Must Implement HomePageFragmentCallback interface");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel=new ViewModelProvider(this).get(HomePageViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding= DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_home,
                container,
                false);
        setupAdapter();
        return mBinding.getRoot();
    }

    private void setupAdapter() {
        mAdapter=new UserAdapter(mViewModel, new UserAdapter.UserAdapterCallback() {
            @Override
            public void onItemSelectedListener(UUID userId) {
                mCallback.onItemSelectedListener(userId);
            }
        });

        mBinding.recyclerView.setAdapter(mAdapter);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public interface HomePageFragmentCallback{
        void onItemSelectedListener(UUID userId);
    }
}