package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {
    ImageView iv;
    TextView title,desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        iv=findViewById(R.id.imageView);
        title=findViewById(R.id.title_d);
        desc=findViewById(R.id.desc);
        title.setText(getIntent().getStringExtra("title"));
        Picasso.get().load(getIntent().getStringExtra("img")).fit().centerInside().into(iv);
        desc.setText(getIntent().getStringExtra("desc"));

    }
}