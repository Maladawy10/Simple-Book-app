package com.example.task1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavAdaptor extends RecyclerView.Adapter<FavAdaptor.FavViewHolder> {

    Book b;
    Context c;
    ArrayList<Book> books;
    public FavAdaptor(ArrayList<Book> books,Context context) {
        this.books = books;
        c=context;
    }
    @NonNull
    @Override
    public FavAdaptor.FavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,null,false);
        FavAdaptor.FavViewHolder FVH=new FavAdaptor.FavViewHolder(v);
        return FVH;
    }

    @Override
    public void onBindViewHolder(@NonNull FavAdaptor.FavViewHolder holder, int position) {
        b=books.get(position);
        String t=b.getTitle();
        String n=b.getAuther_name();
        holder.title.setText(t);
        holder.auther_name.setText(n);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class FavViewHolder extends RecyclerView.ViewHolder
    {
        TextView title,auther_name;
        public FavViewHolder(@NonNull View itemView) {
            super(itemView);
            auther_name=itemView.findViewById(R.id.auther_fav);
            title=itemView.findViewById(R.id.title_fav);
        }
    }
}
