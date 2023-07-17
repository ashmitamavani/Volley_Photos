package com.example.volley_photos;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Recyclerview_Adapter extends RecyclerView.Adapter<Recyclerview_Adapter.Holder> {
    MainActivity mainActivity;
    ArrayList<Model> list;
    public Recyclerview_Adapter(MainActivity mainActivity, ArrayList<Model> list) {
        this.mainActivity=mainActivity;
        this.list=list;
    }

    @NonNull
    @Override
    public Recyclerview_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mainActivity).inflate(R.layout.recyclerview__item_layout,parent,false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerview_Adapter.Holder holder, int position) {
        holder.textView.setText(list.get(position).getTitle());
//        Glide
//                .with(mainActivity)
//                .load(list.get(position).getUrl())
//                .centerCrop()
//                .placeholder(R.drawable.baseline_refresh_24)
//                .into(holder.imageView1);

        Picasso.get()
                .load(list.get(position).getUrl())
                .placeholder(R.drawable.rotation)
                .into(holder.imageView1);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView1,imageView2;
        public Holder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.title);
            imageView1=itemView.findViewById(R.id.img1);
            imageView2=itemView.findViewById(R.id.img2);
        }
    }
}
