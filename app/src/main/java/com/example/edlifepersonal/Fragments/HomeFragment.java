package com.example.edlifepersonal.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edlifepersonal.Adapter.HomePagerAdapter;
import com.example.edlifepersonal.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    private List<String> mData = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        initData();
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        mTabLayout = rootView.findViewById(R.id.home_indicator);
        mViewPager2 = rootView.findViewById(R.id.home_pager);
        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(getActivity(), mData);
        mViewPager2.setAdapter(homePagerAdapter);
        new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(mData.get(position));
            }
        }).attach();
    }

    private void initData() {
        mData.add("tag1");
        mData.add("tag2");
        mData.add("tag3");
        mData.add("tag4");
        mData.add("tag5");
    }

}
