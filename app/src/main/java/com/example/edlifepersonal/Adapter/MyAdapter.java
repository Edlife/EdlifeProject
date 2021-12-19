package com.example.edlifepersonal.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.edlifepersonal.R;
import com.example.edlifepersonal.models.Notes;
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

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<Notes> list;
    private LayoutInflater layoutInflater;

    public MyAdapter(List<Notes> list, Context context){
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            view = layoutInflater.inflate(R.layout.item_layout,null,false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }


        Notes notes = (Notes) getItem(i);
        viewHolder.title.setText(notes.getTitle());
        viewHolder.name.setText(notes.getName());
        viewHolder.content.setText(notes.getContent());
        viewHolder.date.setText(notes.getDate());
        viewHolder.price.setText(notes.getPrice());

        Picasso.get().load(notes.getProfilePicUri()).into(viewHolder.profilePic);
        Picasso.get().load(notes.getItemPicUri()).into(viewHolder.itemPic);

        return view;
    }

    class ViewHolder{
        TextView title,name,content,date,price;
        de.hdodenhof.circleimageview.CircleImageView itemPic;
        de.hdodenhof.circleimageview.CircleImageView profilePic;

        public ViewHolder(View view){
            title = view.findViewById(R.id.title);
            name = view.findViewById(R.id.name);
            content = view.findViewById(R.id.content);
            date = view.findViewById(R.id.date);
            itemPic = view.findViewById(R.id.itemPic);
            profilePic = view.findViewById(R.id.profile_image);
            price = view.findViewById(R.id.price);

        }
    }
}
