package com.example.android51;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.android51.databinding.FragmentFirstBinding;
import com.example.android51.databinding.FragmentNotBinding;

public class NotificationFragment extends Fragment {

    private FragmentNotBinding binding;
    public NotificationFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}