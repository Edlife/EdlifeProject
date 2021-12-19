package com.example.edlifepersonal.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.edlifepersonal.Adapter.MyAdapter;
import com.example.edlifepersonal.DetailActivity;
import com.example.edlifepersonal.ItemDetailActivity;
import com.example.edlifepersonal.MainActivity;
import com.example.edlifepersonal.R;
import com.example.edlifepersonal.RecordActivity;
import com.example.edlifepersonal.SignupActivity;
import com.example.edlifepersonal.models.Notes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Fragment_post extends Fragment {
    private ListView listView;
    private ImageView add;
    private MyAdapter myAdapter;
    private List<Notes> list;
    DatabaseReference reference;
    Notes notes;
    Notes notesClick;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.right,container,false);
        reference = FirebaseDatabase.getInstance("https://edlifepersonal-default-rtdb.europe-west1.firebasedatabase.app").getReference("secondItem").child("books");

        listView = v.findViewById(R.id.listview);
        add= v.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RecordActivity.class));
            }
        });

        init();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                notesClick = new Notes();
                notesClick = list.get(i);
                String title = notesClick.getTitle();
                String price = notesClick.getPrice();
                String date = notesClick.getDate();
                String content = notesClick.getContent();
                String itemPicUri = notesClick.getItemPicUri();
                String profilePicUri = notesClick.getProfilePicUri();
                String name = notesClick.getName();

                Intent intent = new Intent();
                intent.setClass(getActivity(), ItemDetailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("title", title);
                bundle.putString("price", price);
                bundle.putString("date",date);
                bundle.putString("content",content);
                bundle.putString("itemPicUri",itemPicUri);
                bundle.putString("profilePicUri",profilePicUri);
                bundle.putString("name",name);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        return v;
    }

    private void init() {
        list = new ArrayList<>();
        notes = new Notes();
        myAdapter = new MyAdapter(list,getActivity());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot ds:snapshot.getChildren()){
                    notes = ds.getValue(Notes.class);
                    list.add(notes);
                }
                listView.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
