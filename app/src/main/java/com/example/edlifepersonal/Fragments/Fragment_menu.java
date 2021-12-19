package com.example.edlifepersonal.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.edlifepersonal.Adapter.MyAdapter;
import com.example.edlifepersonal.ItemDetailActivity;
import com.example.edlifepersonal.MainActivity;
import com.example.edlifepersonal.R;
import com.example.edlifepersonal.models.Notes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Fragment_menu  extends Fragment {
    private Button books,clothes,electronics,computers,kitchen,foodDrink,cosmetic,furniture,groceries,household,others;
    private MyAdapter myAdapter;
    private List<Notes> list;
    DatabaseReference reference;
    Notes notes;
    Notes notesClick;
    private ListView listView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.left,container,false);

        books = v.findViewById(R.id.books);
        clothes =v.findViewById(R.id.clothes);
        electronics = v.findViewById(R.id.electronics);
        computers = v.findViewById(R.id.computers);
        kitchen = v.findViewById(R.id.kitchen);
        foodDrink = v.findViewById(R.id.foodDrink);
        cosmetic = v.findViewById(R.id.cosmetic);
        furniture = v.findViewById(R.id.furniture);
        groceries = v.findViewById(R.id.groceries);
        household = v.findViewById(R.id.household);
        others = v.findViewById(R.id.other);

        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity m1 = (MainActivity) getActivity();
                FragmentManager fm = m1.getSupportFragmentManager().findFragmentById(R.id.main_page_controller).getChildFragmentManager();
                Fragment f1 = fm.findFragmentById(R.id.right);
                View v1 = f1.getView();
                listView = v1.findViewById(R.id.listview);
                reference = FirebaseDatabase.getInstance("https://edlifepersonal-default-rtdb.europe-west1.firebasedatabase.app").getReference("secondItem").child("books");

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
            }
        });

        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity m1 = (MainActivity) getActivity();
                FragmentManager fm = m1.getSupportFragmentManager().findFragmentById(R.id.main_page_controller).getChildFragmentManager();
                Fragment f1 = fm.findFragmentById(R.id.right);
                View v1 = f1.getView();
                listView = v1.findViewById(R.id.listview);
                reference = FirebaseDatabase.getInstance("https://edlifepersonal-default-rtdb.europe-west1.firebasedatabase.app").getReference("secondItem").child("clothes");
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
            }
        });

        electronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity m1 = (MainActivity) getActivity();
                FragmentManager fm = m1.getSupportFragmentManager().findFragmentById(R.id.main_page_controller).getChildFragmentManager();
                Fragment f1 = fm.findFragmentById(R.id.right);
                View v1 = f1.getView();
                listView = v1.findViewById(R.id.listview);
                reference = FirebaseDatabase.getInstance("https://edlifepersonal-default-rtdb.europe-west1.firebasedatabase.app").getReference("secondItem").child("electronics");
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
            }
        });

        computers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity m1 = (MainActivity) getActivity();
                FragmentManager fm = m1.getSupportFragmentManager().findFragmentById(R.id.main_page_controller).getChildFragmentManager();
                Fragment f1 = fm.findFragmentById(R.id.right);
                View v1 = f1.getView();
                listView = v1.findViewById(R.id.listview);
                reference = FirebaseDatabase.getInstance("https://edlifepersonal-default-rtdb.europe-west1.firebasedatabase.app").getReference("secondItem").child("computers");
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
            }
        });

        kitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity m1 = (MainActivity) getActivity();
                FragmentManager fm = m1.getSupportFragmentManager().findFragmentById(R.id.main_page_controller).getChildFragmentManager();
                Fragment f1 = fm.findFragmentById(R.id.right);
                View v1 = f1.getView();
                listView = v1.findViewById(R.id.listview);
                reference = FirebaseDatabase.getInstance("https://edlifepersonal-default-rtdb.europe-west1.firebasedatabase.app").getReference("secondItem").child("kitchen");
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
            }
        });

        foodDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity m1 = (MainActivity) getActivity();
                FragmentManager fm = m1.getSupportFragmentManager().findFragmentById(R.id.main_page_controller).getChildFragmentManager();
                Fragment f1 = fm.findFragmentById(R.id.right);
                View v1 = f1.getView();
                listView = v1.findViewById(R.id.listview);
                reference = FirebaseDatabase.getInstance("https://edlifepersonal-default-rtdb.europe-west1.firebasedatabase.app").getReference("secondItem").child("foodDrink");
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
            }
        });

        cosmetic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity m1 = (MainActivity) getActivity();
                FragmentManager fm = m1.getSupportFragmentManager().findFragmentById(R.id.main_page_controller).getChildFragmentManager();
                Fragment f1 = fm.findFragmentById(R.id.right);
                View v1 = f1.getView();
                listView = v1.findViewById(R.id.listview);
                reference = FirebaseDatabase.getInstance("https://edlifepersonal-default-rtdb.europe-west1.firebasedatabase.app").getReference("secondItem").child("cosmetic");
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
            }
        });

        furniture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity m1 = (MainActivity) getActivity();
                FragmentManager fm = m1.getSupportFragmentManager().findFragmentById(R.id.main_page_controller).getChildFragmentManager();
                Fragment f1 = fm.findFragmentById(R.id.right);
                View v1 = f1.getView();
                listView = v1.findViewById(R.id.listview);
                reference = FirebaseDatabase.getInstance("https://edlifepersonal-default-rtdb.europe-west1.firebasedatabase.app").getReference("secondItem").child("furniture");
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
            }
        });

        groceries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity m1 = (MainActivity) getActivity();
                FragmentManager fm = m1.getSupportFragmentManager().findFragmentById(R.id.main_page_controller).getChildFragmentManager();
                Fragment f1 = fm.findFragmentById(R.id.right);
                View v1 = f1.getView();
                listView = v1.findViewById(R.id.listview);
                reference = FirebaseDatabase.getInstance("https://edlifepersonal-default-rtdb.europe-west1.firebasedatabase.app").getReference("secondItem").child("groceries");
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
            }
        });

        household.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity m1 = (MainActivity) getActivity();
                FragmentManager fm = m1.getSupportFragmentManager().findFragmentById(R.id.main_page_controller).getChildFragmentManager();
                Fragment f1 = fm.findFragmentById(R.id.right);
                View v1 = f1.getView();
                listView = v1.findViewById(R.id.listview);
                reference = FirebaseDatabase.getInstance("https://edlifepersonal-default-rtdb.europe-west1.firebasedatabase.app").getReference("secondItem").child("household");
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
            }
        });

        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity m1 = (MainActivity) getActivity();
                FragmentManager fm = m1.getSupportFragmentManager().findFragmentById(R.id.main_page_controller).getChildFragmentManager();
                Fragment f1 = fm.findFragmentById(R.id.right);
                View v1 = f1.getView();
                listView = v1.findViewById(R.id.listview);
                reference = FirebaseDatabase.getInstance("https://edlifepersonal-default-rtdb.europe-west1.firebasedatabase.app").getReference("secondItem").child("other");
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
