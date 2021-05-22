package com.example.android51;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android51.databinding.ActivityMainBinding;
import com.example.android51.databinding.FragmentDataBinding;
import com.example.android51.databinding.FragmentFirstBinding;
import com.example.android51.databinding.ItemBinding;
import com.example.android51.rv_et.Adapter;
import com.example.android51.rv_et.Model;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding_fr;
    private Adapter data_adapter;
    MainActivity mainActivity;
    int pos;
    private FragmentManager fm;


    public FirstFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getActivity().getSupportFragmentManager();
        data_adapter = new Adapter(new Adapter.Listener() {
            @Override
            public void onItemClick(Model model, int position) {
                pos = position;
                Log.d("TAG", "onItemClick:  "+pos);
                DataFragment dataFragment = new DataFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("fa",model);
                dataFragment.setArguments(bundle);
                fm.beginTransaction().replace(R.id.container2,dataFragment).addToBackStack(null).commit();
            }
        });
        mainActivity = (MainActivity) requireActivity();

//        if (getArguments() != null) {
//            String name = getArguments().getString("name");
//            String phoneNum = getArguments().getString("phone");
//            data_adapter.adds(new Model(name,phoneNum));
//            Log.d("TAG", "onCreate: "+name);
//        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding_fr = FragmentFirstBinding.inflate(inflater, container, false);

        binding_fr.rvTarget.setAdapter(data_adapter);

        binding_fr.btnFab.setOnClickListener(v -> {
            fm.beginTransaction().replace(R.id.container2, new DataFragment()).addToBackStack(null).commit();
            mainActivity.hide();
        });

        fm.setFragmentResultListener("res", this, (requestKey, result) -> {
            Model model;
            if (result.getSerializable("update") != null) {
                model = (Model) result.getSerializable("update");
                data_adapter.update(model, pos);
            } else {
                model = (Model) result.getSerializable("add");
                data_adapter.adds(model);
            }
        });

        return binding_fr.getRoot();

    }


}