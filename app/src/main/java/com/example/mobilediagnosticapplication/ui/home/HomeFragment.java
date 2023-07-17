package com.example.mobilediagnosticapplication.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.mobilediagnosticapplication.BatteryInfo;
import com.example.mobilediagnosticapplication.R;
import com.example.mobilediagnosticapplication.databinding.FragmentHomeBinding;
import com.example.mobilediagnosticapplication.ui.DashboardFragment;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TextView tip;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

      /*  HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.tip;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;*/



        return inflater.inflate(R.layout.fragment_home,container,false);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}