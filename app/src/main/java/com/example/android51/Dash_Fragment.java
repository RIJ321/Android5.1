package com.example.android51;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.android51.databinding.FragmentDashBinding;

public class Dash_Fragment extends Fragment {

    private FragmentDashBinding binding;
    public Dash_Fragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDashBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}