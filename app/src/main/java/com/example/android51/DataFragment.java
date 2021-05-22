package com.example.android51;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android51.databinding.FragmentDataBinding;
import com.example.android51.databinding.FragmentFirstBinding;
import com.example.android51.rv_et.Model;

public class DataFragment extends Fragment {
    FragmentDataBinding binding_fr;
    private FragmentFirstBinding binding_home;
    private FragmentManager fm;
    MainActivity mainActivity;
    Model model;

    public DataFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getActivity().getSupportFragmentManager();
        mainActivity = (MainActivity) requireActivity();
        if (getArguments() != null) {
            model = (Model) getArguments().getSerializable("fa");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding_fr = FragmentDataBinding.inflate(inflater, container, false);

        if (model != null) {
            binding_fr.etName.setText(model.getName());
            binding_fr.etPhoneNum.setText(model.getPhone());
        }

        binding_fr.btnSave.setOnClickListener(v -> {

            String name = binding_fr.etName.getText().toString().trim();
            String phoneNum = binding_fr.etPhoneNum.getText().toString().trim();

            if (name.isEmpty() && phoneNum.isEmpty()) {
                binding_fr.etName.setError("Ввведите имя");
                binding_fr.etPhoneNum.setError("Ввведите номер");
            } else {
                Bundle bundle = new Bundle();
                if (model != null) {
                    model.setName(name);
                    model.setPhone(phoneNum);
                    bundle.putSerializable("update",model);
                }else{
                    model = new Model(name,phoneNum);
                    bundle.putSerializable("add",model);
                }
                mainActivity.setVisible();
                fm.setFragmentResult("res", bundle);
                fm.popBackStack();

            }
        });


        return binding_fr.getRoot();
    }


}