package com.example.edlifepersonal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.example.edlifepersonal.databinding.ActivityDetailBinding;
import com.example.edlifepersonal.models.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;


public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    FirebaseFirestore fStore;
    StorageReference storageReference;
    int TAKE_IMAGE_CODE = 1001;
    Uri saveUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance("https://edlifepersonal-default-rtdb.europe-west1.firebasedatabase.app");
        fStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        progressDialog = new ProgressDialog(DetailActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We're creating your account");

        saveUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
        + getResources().getResourcePackageName(R.drawable.avatar3) + "/"
        + getResources().getResourceTypeName(R.drawable.avatar3) + "/"
        + getResources().getResourceEntryName(R.drawable.avatar3));
        Uri defaultUri = saveUri;
        binding.profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,TAKE_IMAGE_CODE);
            }
        });


        binding.txtAlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailActivity.this,SigninActivity.class));
                finish();
            }
        });

        Bundle bundle = this.getIntent().getExtras();
        String username = bundle.getString("username");
        String email = bundle.getString("email");
        String password = bundle.getString("pwd");

        String[] gender = {"Male"};
        binding.radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb = (RadioButton) DetailActivity.this.findViewById(radioGroup.getCheckedRadioButtonId());
                gender[0] = rb.getText().toString();
            }
        });

        String[] program = {"UG"};
        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb = (RadioButton)DetailActivity.this.findViewById(radioGroup.getCheckedRadioButtonId());
                program[0] = rb.getText().toString();
            }
        });

        //String[] nationality = {"Afghan","Albanian","Algerian","American","Andorran","Angolan","Anguillan","Citizen of Antigua and Barbuda","Argentine",
        //"Armenian","Australian","Austrian","Azerbaijani","Bahamian","Bahraini","Bangladeshi","Barbadian","Belarusian","Belgian",
        //"Belizean","Beninese","Bermudian","Bhutanese","Bolivian","Citizen of Bosnia and Herzegovina","Botswanan","Brazilian",
        //"British","British Virgin Islander","Bruneian","Bulgarian","Burkinan","Burmese","Burundian","Cambodian","Cameroonian"};

        String[] schools = {"Business school", "School of Divinity","School of Economics","Edinburgh College of Art","Moray House School of Education and Sport",
                "School of Health in Social Science","School of History,Classic and Archaeology","School of Law","School of Literature, Languages and Cultures",
                "School of Philosophy, Psychology, and Language Science","Center for Opening Learning","Edinburgh Medical School",
                "Royal(Dick) School of Veterinary Studies","School of Biological Sciences","School of Chemistry", "School of Engineering",
                "School of GeoScience","School of Informatics","School of Mathematics","School of Physics and Astronomy","other"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose your school");

        final String[] school = {""};
        builder.setSingleChoiceItems(schools, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                school[0] = schools[which];
                binding.school.setText(school[0]);
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();

        binding.school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });


        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!binding.degree.getText().toString().isEmpty() && !(binding.school.getText().toString().equals(" choose your school "))){
                    if(saveUri == defaultUri){
                        Toast.makeText(DetailActivity.this, "please upload your picture", Toast.LENGTH_SHORT).show();
                    }else{
                        progressDialog.show();
                        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();
                                if(task.isSuccessful()){
                                    mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(DetailActivity.this, "Sign Up Successfully, please check your email to verify", Toast.LENGTH_SHORT).show();
                                            }else{
                                                Toast.makeText(DetailActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                    ArrayList interests = new ArrayList();
                                    if(binding.movie.isChecked()){
                                        interests.add(binding.movie.getText().toString());
                                    }
                                    if(binding.game.isChecked()){
                                        interests.add(binding.game.getText().toString());
                                    }
                                    if(binding.sports.isChecked()){
                                        interests.add(binding.sports.getText().toString());
                                    }
                                    Users user = new Users(username,email,password, program[0], binding.school.getText().toString(),binding.degree.getText().toString(),interests,saveUri.toString(),gender[0]);
                                    String id = task.getResult().getUser().getUid();
                                    database.getReference().child("Users").child(id).setValue(user);
                                    uploadImageToFirebase(saveUri,email);
                                    Intent intent = new Intent();
                                    intent.setClass(DetailActivity.this,SigninActivity.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(DetailActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent();
                                    intent.setClass(DetailActivity.this,SignupActivity.class);
                                    startActivity(intent);
                                }
                            }
                        });
                    }
                }else{
                    Toast.makeText(DetailActivity.this, "can not be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TAKE_IMAGE_CODE){
            if (resultCode == Activity.RESULT_OK){
                Uri imageUri = data.getData();
                binding.profileImage.setImageURI(imageUri);
                saveUri = imageUri;
            }
        }
    }

    private void uploadImageToFirebase(Uri imageUri,String email) {
        StorageReference fileRef = storageReference.child("profile").child(email);
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(DetailActivity.this, "image uploaded successfully", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(DetailActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}