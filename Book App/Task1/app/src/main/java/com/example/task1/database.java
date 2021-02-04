package com.example.task1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {
    static  final String DBname="dbase.dp";
    public database(@Nullable Context context)
    {
        super(context, DBname, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE mytable(title TEXT PRIMARY KEY,auther TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS mytable");
    }
    public boolean insert(String title,String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("title",title);
        cv.put("auther",name);
        int r=(int) db.insert("mytable",null,cv);
        if (r==-1)
            return false;
        else
            return true;
    }
    public ArrayList<Book> get_data()
    {
        ArrayList<Book> arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("SELECT title,name FROM mytable",null);
        while (res.moveToNext())
        {
            String t=res.getString(0);
            String n=res.getString(1);
            arrayList.add(new Book(n,t));
        }
        return arrayList;
    }
    public Integer delete(String title)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("mytable","title = ?",new String[]{title});
    }

}
