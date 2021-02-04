package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    public String url;
    private ArrayList<Book> bk;
    private RequestQueue rq;
    private BookAdaptor bka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String choose=getIntent().getStringExtra("choose");
        rv=findViewById(R.id.rc);

                if(choose.equals("sport"))
                {
                    url="https://run.mocky.io/v3/f393cb45-4081-4e33-a45e-c2966a90f2f8";
                }
                else if(choose.equals("life"))
                {
                    url="https://run.mocky.io/v3/b5adf54a-9e8a-47eb-a055-7ba3249aae9c";
                }
                else if(choose.equals("love"))
                {
                    url="https://run.mocky.io/v3/a1f58cce-5dc9-44e7-a5a8-1daa0824250e";
                }
                else if(choose.equals("time"))
                {
                    url="https://run.mocky.io/v3/e36cc68e-5e78-4f11-950b-fc6570bc5d03";
                }


                bk= new ArrayList<>();
                bka=new BookAdaptor(bk,getApplicationContext());
        rv.setLayoutManager(new LinearLayoutManager(this));
                rv.setAdapter(bka);

            
        rq= Volley.newRequestQueue(this);
        load();

    }
    public  void load()
    {
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                JSONArray jsonArray= null;
                try {
                    jsonArray = response.getJSONArray("items");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                for(int i=0;i<jsonArray.length();i++)
                    {

                        JSONObject iteam= null;
                        try {
                            iteam = jsonArray.getJSONObject(i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        JSONObject volume= null;
                        try {
                            volume = iteam.getJSONObject("volumeInfo");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        JSONArray authors= null;
                        try {
                            authors = volume.getJSONArray("authors");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String name="";
                        try {
                            name=authors.getString(0);
                        } catch (JSONException e) {

                        }
                        String title="";
                        try {
                            title=volume.getString("title");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        JSONObject img= null;
                        try {
                            img = volume.getJSONObject("imageLinks");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String img_url="";
                        try {
                            img_url=img.getString("thumbnail");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String desc="";
                        try {
                            desc=volume.getString("description");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        bk.add(new Book(name,title,desc,img_url,R.drawable.fav));
                        bka.notifyDataSetChanged();
                    }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        rq.add(request);
    }

}