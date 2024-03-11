package com.example.pmd_se_a_java.CommunicationBwFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pmd_se_a_java.R;

public class FirstFragment extends Fragment {
    ButtonPressListener.OnButtonPressListener buttonPressListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.firstfragment, container,false);
        myfunction(root);
        return root;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        buttonPressListener = (ButtonPressListener.OnButtonPressListener) getActivity();
    }

    void myfunction(ViewGroup root){
        TextView textview = root.findViewById(R.id.txtcmfragment);
        textview.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //textview.setText("Message aya he first Fragment se...");
                buttonPressListener.onButtonPressed("Message aya he first Fragment se...");
            }
        });
    }
}
