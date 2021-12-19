package com.example.edlifepersonal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.edlifepersonal.databinding.ActivityItemDetailBinding;
import com.squareup.picasso.Picasso;

public class ItemDetailActivity extends AppCompatActivity {
    ActivityItemDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityItemDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        Bundle bundle = this.getIntent().getExtras();
        String profilePicUri = bundle.getString("profilePicUri");
        String name = bundle.getString("name");
        String title = bundle.getString("title");
        String itemPicUri = bundle.getString("itemPicUri");
        String price = bundle.getString("price");
        String content = bundle.getString("content");
        String date = bundle.getString("date");

        Picasso.get().load(profilePicUri).into(binding.profileImage);
        binding.name.setText(name);
        binding.title.setText(title);
        Picasso.get().load(itemPicUri).into(binding.itemPic);
        binding.price.setText(price);
        binding.content.setText(content);
        binding.date.setText(date);

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}