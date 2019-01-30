package com.example.fragmentprova;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentOne extends Fragment{

    ImageView imageView;
    ImageView imageView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        imageView = view.findViewById(R.id.imageView);
        imageView2 = view.findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.t_shirt_maschio);
        imageView2.setImageResource(R.drawable.pantaloni_sigaretta_tasconi);

        return view;
    }
}
