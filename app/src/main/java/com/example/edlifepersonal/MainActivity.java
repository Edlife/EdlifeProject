package com.example.edlifepersonal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.edlifepersonal.Fragments.BuyFragment;
import com.example.edlifepersonal.Fragments.ChatFragment;
import com.example.edlifepersonal.Fragments.HomeFragment;
import com.example.edlifepersonal.Fragments.SettingFragment;
import com.example.edlifepersonal.Fragments.SocietyFragment;
import com.example.edlifepersonal.databinding.ActivityMainBinding;
import com.example.edlifepersonal.models.Notes;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    List<Notes> list;

    private BottomNavigationView mNavigationView;

    private FragmentManager mFragmentManager;

    private Fragment[] fragments;
    private int lastFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();


        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance("https://edlifepersonal-default-rtdb.europe-west1.firebasedatabase.app");

        mNavigationView = findViewById(R.id.main_navigation_bar);
        initFragment();
        initListener();
    }

    private void initListener() {
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        if (lastFragment != 0) {
                            MainActivity.this.switchFragment(lastFragment, 0);
                            lastFragment = 0;
                        }
                        return true;
                    case R.id.buy:
                        if (lastFragment != 1) {
                            MainActivity.this.switchFragment(lastFragment, 1);
                            lastFragment = 1;
                        }
                        return true;
                    case R.id.society:
                        if (lastFragment != 2) {
                            MainActivity.this.switchFragment(lastFragment, 2);
                            lastFragment = 2;
                        }
                        return true;
                    case R.id.chat:
                        if (lastFragment != 3) {
                            MainActivity.this.switchFragment(lastFragment, 3);
                            lastFragment = 3;
                        }
                        return true;
                    case R.id.setting:
                        if (lastFragment != 4) {
                            MainActivity.this.switchFragment(lastFragment, 4);
                            lastFragment = 4;
                        }
                        return true;
                }
                return false;
            }
        });
    }

    private void initFragment() {
        HomeFragment mHomeFragment = new HomeFragment();
        BuyFragment mBuyFragment = new BuyFragment();
        SocietyFragment mSocietyFragment = new SocietyFragment();
        ChatFragment mChatFragment = new ChatFragment();
        SettingFragment mSettingFragment = new SettingFragment();
        fragments = new Fragment[]{mHomeFragment, mBuyFragment,mSocietyFragment ,mChatFragment, mSettingFragment};
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction()
                .replace(R.id.main_page_controller, mHomeFragment)
                .show(mHomeFragment)
                .commit();
    }

    private void switchFragment(int lastFragment, int index) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.hide(fragments[lastFragment]);
        if (!fragments[index].isAdded()){
            transaction.add(R.id.main_page_controller,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }

}