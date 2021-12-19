package com.example.edlifepersonal.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.edlifepersonal.SigninActivity;
import com.example.edlifepersonal.databinding.FragmentSettingBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class SettingFragment extends Fragment {

    FragmentSettingBinding binding;
    FirebaseAuth mAuth;
    DatabaseReference reference;
    StorageReference storageRef;

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingBinding.inflate(inflater,container,false);
        mAuth = FirebaseAuth.getInstance();
        storageRef = FirebaseStorage.getInstance().getReference("profile");
        reference = FirebaseDatabase.getInstance("https://edlifepersonal-default-rtdb.europe-west1.firebasedatabase.app").getReference("Users");
        reference.child(mAuth.getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()){
                    if(task.getResult().exists()){
                        DataSnapshot dataSnapshot = task.getResult();
                        String email = String.valueOf(dataSnapshot.child("mail").getValue());
                        String userName = String.valueOf(dataSnapshot.child("userName").getValue());
                        String program = String.valueOf(dataSnapshot.child("program").getValue());
                        String school = String.valueOf(dataSnapshot.child("school").getValue());
                        String degree = String.valueOf(dataSnapshot.child("degree").getValue());
                        String gender = String.valueOf(dataSnapshot.child("gender").getValue());
                        storageRef.child(email).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                Picasso.get().load(uri).into(binding.image);
                            }
                        });

                        binding.gender.setText(gender);
                        binding.name.setText(userName);
                        binding.program.setText(program);
                        binding.school.setText(school);
                        binding.degree.setText(degree);
                    }else{
                        Toast.makeText(getActivity(), "User doesn't exist", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "Failed to read", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(getActivity(),SigninActivity.class));
            }
        });
        return binding.getRoot();

    }
}