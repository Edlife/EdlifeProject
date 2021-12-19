package com.example.edlifepersonal.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class HomePageFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    public HomePageFragment() {

    }

    public static HomePageFragment newInstance(String param1) {
        HomePageFragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }
}
