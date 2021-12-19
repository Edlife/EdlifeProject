package com.example.edlifepersonal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.example.edlifepersonal.Fragments.BuyFragment;
import com.example.edlifepersonal.databinding.ActivityRecordBinding;
import com.example.edlifepersonal.models.Records;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RecordActivity extends AppCompatActivity {

    ActivityRecordBinding binding;
    Uri saveUri;
    int TAKE_IMAGE_CODE = 1001;
    StorageReference storageRef;
    StorageReference storageReference;
    DatabaseReference reference;
    FirebaseDatabase database;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance("https://edlifepersonal-default-rtdb.europe-west1.firebasedatabase.app");
        storageReference = FirebaseStorage.getInstance().getReference();
        storageRef = FirebaseStorage.getInstance().getReference("profile");
        reference = FirebaseDatabase.getInstance("https://edlifepersonal-default-rtdb.europe-west1.firebasedatabase.app").getReference("Users");

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Uri defaultUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + getResources().getResourcePackageName(R.drawable.avatar3) + "/"
                + getResources().getResourceTypeName(R.drawable.avatar3) + "/"
                + getResources().getResourceEntryName(R.drawable.avatar3));
        saveUri = defaultUri;
        binding.profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,TAKE_IMAGE_CODE);
            }
        });

        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!binding.title.getText().toString().isEmpty() && !binding.content.getText().toString().isEmpty() && !binding.content.getText().toString().isEmpty()){
                    if(saveUri == defaultUri){
                        Toast.makeText(RecordActivity.this, "please upload a picture", Toast.LENGTH_SHORT).show();
                    }else if(!binding.books.isChecked() && !binding.clothes.isChecked() && !binding.electronics.isChecked() && !binding.computers.isChecked() && !binding.kitchen.isChecked()
                    && !binding.foodDrink.isChecked() && !binding.cosmetic.isChecked() && !binding.furniture.isChecked() && !binding.groceries.isChecked() && !binding.household.isChecked() && !binding.other.isChecked()){
                        Toast.makeText(RecordActivity.this, "please choose at least one category", Toast.LENGTH_SHORT).show();
                    }else{
                        reference.child(mAuth.getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                if (task.isSuccessful()){
                                    if (task.getResult().exists()){
                                        DataSnapshot dataSnapshot = task.getResult();
                                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" yyyy MM dd");
                                        Date date = new Date(System.currentTimeMillis());
                                        String time = simpleDateFormat.format(date);
                                        String email = String.valueOf(dataSnapshot.child("mail").getValue());
                                        String userName = String.valueOf(dataSnapshot.child("userName").getValue());
                                        storageRef.child(email).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                            @Override
                                            public void onSuccess(Uri uri) {
                                                String picUri = uri.toString();
                                                ArrayList<String> category= new ArrayList<>();
                                                Records records = new Records(binding.title.getText().toString(),picUri,userName,binding.content.getText().toString(),time,email,binding.price.getText().toString(),saveUri.toString());
                                                if (binding.books.isChecked()){
                                                    database.getReference().child("secondItem").child("books").child(mAuth.getCurrentUser().getUid()+binding.title.getText().toString()+time).setValue(records);
                                                    category.add("books");
                                                }
                                                if (binding.clothes.isChecked()){
                                                    database.getReference().child("secondItem").child("clothes").child(mAuth.getCurrentUser().getUid()+binding.title.getText().toString()+time).setValue(records);
                                                    category.add("clothes");

                                                }
                                                if (binding.electronics.isChecked()){
                                                    database.getReference().child("secondItem").child("electronics").child(mAuth.getCurrentUser().getUid()+binding.title.getText().toString()+time).setValue(records);
                                                    category.add("electronics");

                                                }
                                                if(binding.computers.isChecked()){
                                                    database.getReference().child("secondItem").child("computers").child(mAuth.getCurrentUser().getUid()+binding.title.getText().toString()+time).setValue(records);
                                                    category.add("computers");

                                                }
                                                if(binding.kitchen.isChecked()){
                                                    database.getReference().child("secondItem").child("kitchen").child(mAuth.getCurrentUser().getUid()+binding.title.getText().toString()+time).setValue(records);
                                                    category.add("kitchen");

                                                }
                                                if(binding.foodDrink.isChecked()){
                                                    database.getReference().child("secondItem").child("foodDrink").child(mAuth.getCurrentUser().getUid()+binding.title.getText().toString()+time).setValue(records);
                                                    category.add("foodDrink");

                                                }
                                                if (binding.cosmetic.isChecked()){
                                                    database.getReference().child("secondItem").child("cosmetic").child(mAuth.getCurrentUser().getUid()+binding.title.getText().toString()+time).setValue(records);
                                                    category.add("cosmetic");

                                                }
                                                if (binding.furniture.isChecked()){
                                                    database.getReference().child("secondItem").child("furniture").child(mAuth.getCurrentUser().getUid()+binding.title.getText().toString()+time).setValue(records);
                                                    category.add("furniture");

                                                }
                                                if (binding.groceries.isChecked()){
                                                    database.getReference().child("secondItem").child("groceries").child(mAuth.getCurrentUser().getUid()+binding.title.getText().toString()+time).setValue(records);
                                                    category.add("groceries");

                                                }
                                                if (binding.household.isChecked()){
                                                    database.getReference().child("secondItem").child("household").child(mAuth.getCurrentUser().getUid()+binding.title.getText().toString()+time).setValue(records);
                                                    category.add("household");

                                                }
                                                if (binding.other.isChecked()){
                                                    database.getReference().child("secondItem").child("other").child(mAuth.getCurrentUser().getUid()+binding.title.getText().toString()+time).setValue(records);
                                                    category.add("other");

                                                }
                                                uploadImageToFirebase(saveUri,email,time,binding.title.getText().toString(),category);
                                                finish();
                                            }
                                        });
                                    }else{
                                        Toast.makeText(RecordActivity.this, "User doesn't exist", Toast.LENGTH_SHORT).show();
                                    }
                                }else{
                                    Toast.makeText(RecordActivity.this, "Failed to read", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }else{
                    Toast.makeText(RecordActivity.this, "can not be empty", Toast.LENGTH_SHORT).show();
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
    private void uploadImageToFirebase(Uri imageUri,String email,String time,String title,ArrayList<String> category) {
        StorageReference fileRef = storageReference.child("secondItem").child(email).child(title+time);
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(RecordActivity.this, "image uploaded successfully", Toast.LENGTH_SHORT).show();
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        for (String i : category){
                            database.getReference().child("secondItem").child(i).child(mAuth.getCurrentUser().getUid()+binding.title.getText().toString()+time).child("itemPicUri").setValue(uri.toString());
                        }
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RecordActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}