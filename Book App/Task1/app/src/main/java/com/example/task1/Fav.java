package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Fav extends AppCompatActivity {
    RecyclerView rv;
    private ArrayList<Book> bk;
    private FavAdaptor fa;
    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        rv=findViewById(R.id.rc1);
        bk= db.get_data();
        fa=new FavAdaptor(bk,getApplicationContext());
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(fa);
    }
}