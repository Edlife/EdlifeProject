package com.example.edlifepersonal.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edlifepersonal.R;
import com.example.edlifepersonal.databinding.FragmentBuyBinding;
import com.example.edlifepersonal.databinding.FragmentSettingBinding;
import com.example.edlifepersonal.models.Notes;

import java.util.List;

public class BuyFragment extends Fragment {
    FragmentBuyBinding binding;

    public BuyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBuyBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }

}