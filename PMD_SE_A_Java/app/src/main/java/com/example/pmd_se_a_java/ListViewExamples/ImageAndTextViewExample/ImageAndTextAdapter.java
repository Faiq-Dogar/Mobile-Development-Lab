package com.example.pmd_se_a_java.ListViewExamples.ImageAndTextViewExample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.pmd_se_a_java.R;

import java.util.List;


public class ImageAndTextAdapter extends ArrayAdapter<String> {
    private Activity activity;
    private String[] Name;
    private String[] Text;
    private Integer[] Image;

    public ImageAndTextAdapter(@NonNull Activity activity,String[] name, String[] text, Integer[] image) {
        super(activity, R.layout.mylistlayout, name);
        this.activity = activity;
        Name = name;
        Text = text;
        Image = image;
    }
    public View getView(int position, View view, ViewGroup viewGroup){
        LayoutInflater inflater = activity.getLayoutInflater();    //activity = this
        View viewholder = inflater.inflate(R.layout.mylistlayout, null);
        TextView textview1 = viewholder.findViewById(R.id.txtandimage1);
        TextView textview12 = viewholder.findViewById(R.id.txtandimage2);
        ImageView imageview = viewholder.findViewById(R.id.imgandtext);
        textview1.setText(Name[position]);
        textview12.setText(Text[position]);
        imageview.setImageResource(Image[position]);
        return viewholder;
    }
}
