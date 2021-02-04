package com.example.task1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class BookAdaptor extends RecyclerView.Adapter<BookAdaptor.BookViewHolder> {
    ArrayList<Book> books;
    Book b;
    Context c;
    database db;
    public BookAdaptor(ArrayList<Book> books,Context context) {
        this.books = books;
        c=context;
        db=new database(c);
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,null,false);
        BookViewHolder BVH=new BookViewHolder(v);
        return BVH;
    }
    @Override
    public void onBindViewHolder(@NonNull final BookViewHolder holder, int position) {
        b=books.get(position);
        final String t=b.getTitle();
        final String n=b.getAuther_name();
        final String i=b.getImg_url();
        final String d=b.getDesc();
        holder.title.setText(t);
        holder.auther_name.setText(n);
        holder.fv_btn.setImageResource(b.getImg_btn());
        Picasso.get().load(i).fit().centerInside().into(holder.image);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(c,Details.class);
                intToHome.putExtra("title",t);
                intToHome.putExtra("img",i);
                if(d.equals(""))
                {
                    intToHome.putExtra("desc","There is no available description for this book");
                }
                else
                {
                    intToHome.putExtra("desc",d);
                }
                c.startActivity(intToHome);

            }
        });
        holder.fv_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b.getImg_btn()==R.drawable.fav)
                {
                    holder.fv_btn.setImageResource(R.drawable.fav_red);
                    b.setImg_btn(R.drawable.fav_red);
                    db.insert(t, n);
                    Toast.makeText(c, "The book has been added to your favourites", Toast.LENGTH_SHORT).show();
                }
                else if (b.getImg_btn()==R.drawable.fav_red)
                {
                    holder.fv_btn.setImageResource(R.drawable.fav);
                    b.setImg_btn(R.drawable.fav);
                    db.delete(t);
                    Toast.makeText(c, "The book has been removed from your favourites", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    @Override
    public int getItemCount() {
        return books.size();
    }
    public class BookViewHolder extends RecyclerView.ViewHolder
    {
        TextView title,auther_name;
        public ImageButton fv_btn;
        ImageView image;
        Context c;
        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            auther_name=itemView.findViewById(R.id.auther_tv);
            title=itemView.findViewById(R.id.title);
            fv_btn=itemView.findViewById(R.id.imageButton);
            image=itemView.findViewById(R.id.img);
        }
    }

}
