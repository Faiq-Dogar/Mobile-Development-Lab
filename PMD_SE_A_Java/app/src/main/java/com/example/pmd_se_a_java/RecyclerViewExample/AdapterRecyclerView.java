package com.example.pmd_se_a_java.RecyclerViewExample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmd_se_a_java.R;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    private List<MyMobile> mobileList;

    public AdapterRecyclerView(List<MyMobile> mobileList) {
        this.mobileList = mobileList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mobilerowexample,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyMobile myMobile = mobileList.get(position);
        holder.mobileName.setText(myMobile.getName());
        holder.MobileCompany.setText(myMobile.getCompany());
        holder.MobilePrice.setText(myMobile.getPrice());

    }

    @Override
    public int getItemCount() {
        return mobileList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mobileName,MobileCompany,MobilePrice;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            //widget bind
            mobileName = itemView.findViewById(R.id.txtmobilename);
            MobileCompany = itemView.findViewById(R.id.txtmobilecomapny);
            MobilePrice = itemView.findViewById(R.id.txtmobileprice);

        }
    }
}