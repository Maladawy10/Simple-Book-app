package com.example.task1;

public class Book {
    private String  auther_name,title,desc,img_url;
    private  int img_btn;

    public Book(String auther_name, String title) {
    }

    public Book(String auther_name, String title, String desc, String img_url, int img_btn) {
        this.auther_name = auther_name;
        this.title = title;
        this.desc = desc;
        this.img_url = img_url;
        this.img_btn = img_btn;
    }

    public String getAuther_name() {
        return auther_name;
    }

    public void setAuther_name(String auther_name) {
        this.auther_name = auther_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getImg_btn() {
        return img_btn;
    }

    public void setImg_btn(int img_btn) {
        this.img_btn = img_btn;
    }
}
