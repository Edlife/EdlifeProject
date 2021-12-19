package com.example.edlifepersonal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.edlifepersonal.databinding.ActivitySignupBinding;
import com.example.edlifepersonal.models.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    ActivitySignupBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.txtAlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this,SigninActivity.class));
                finish();
            }
        });

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.txtUsername.getText().toString().isEmpty() && !binding.txtEmail.getText().toString().isEmpty() && !binding.txtPassword.getText().toString().isEmpty()){
                    Intent intent = new Intent();
                    intent.setClass(SignupActivity.this,DetailActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("username", binding.txtUsername.getText().toString());
                    bundle.putString("email", binding.txtEmail.getText().toString());
                    bundle.putString("pwd",binding.txtPassword.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else{
                    Toast.makeText(SignupActivity.this, "can not be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}