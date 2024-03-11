package com.example.pmd_se_a_java.cardViewExample;

public class My_Model {
    public String Name;
    public static int total_downloads;
    public int thumbnail;

    public My_Model(String name, int total_downloads, int thumbnail) {
        Name = name;
        this.total_downloads = total_downloads;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public static int getTotal_downloads() {
        return total_downloads;
    }

    public void setTotal_downloads(int total_downloads) {
        this.total_downloads = total_downloads;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
