package com.example.telegram.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.telegram.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactPageFragment extends Fragment {

    public ContactPageFragment() {
        // Required empty public constructor
    }

    public static ContactPageFragment newInstance() {
        ContactPageFragment fragment = new ContactPageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }
}