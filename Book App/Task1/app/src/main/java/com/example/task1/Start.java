package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Start extends AppCompatActivity {
    private Button btn,btn2;
    private RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        btn=findViewById(R.id.go_btn);
        btn2=findViewById(R.id.favourite_btn);
        rg=findViewById(R.id.rg);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rg.getCheckedRadioButtonId()==R.id.rb1)
                {
                     Intent intToHome = new Intent(getApplicationContext(),MainActivity.class);
                     intToHome.putExtra("choose","sport");
                     startActivity(intToHome);                }
                if (rg.getCheckedRadioButtonId()==R.id.rb2)
                {
                    Intent intToHome = new Intent(getApplicationContext(),MainActivity.class);
                    intToHome.putExtra("choose","life");
                    startActivity(intToHome);                }
                if (rg.getCheckedRadioButtonId()==R.id.rb3)
                {
                    Intent intToHome = new Intent(getApplicationContext(),MainActivity.class);
                    intToHome.putExtra("choose","love");
                    startActivity(intToHome);                }
                if (rg.getCheckedRadioButtonId()==R.id.rb4)
                {
                    Intent intToHome = new Intent(getApplicationContext(),MainActivity.class);
                    intToHome.putExtra("choose","time");
                    startActivity(intToHome);                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intToHome = new Intent(getApplicationContext(),Fav.class);
                startActivity(intToHome);*/
                Toast.makeText(getApplicationContext(), "i couldn't finish logic for this button", Toast.LENGTH_SHORT).show();
            }
        });
    }
}