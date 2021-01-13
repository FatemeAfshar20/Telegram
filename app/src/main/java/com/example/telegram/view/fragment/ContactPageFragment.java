package com.example.telegram.view.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.telegram.R;
import com.example.telegram.databinding.FragmentUserBinding;
import com.example.telegram.viewModel.ContactPageViewModel;

import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactPageFragment extends Fragment {
    public static final String ARG_USER_ID = "UserId";
    private FragmentUserBinding mBinding;
    private ContactPageViewModel mViewModel;

    public ContactPageFragment() {
        // Required empty public constructor
    }

    public static ContactPageFragment newInstance(UUID userId) {
        ContactPageFragment fragment = new ContactPageFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_USER_ID,userId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel=new ViewModelProvider(this).get(ContactPageViewModel.class);
        mViewModel.setUserId((UUID) getArguments().getSerializable(ARG_USER_ID));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding= DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_user,
                container,
                false);
        mBinding.setViewModel(mViewModel);
        return mBinding.getRoot();
    }
}