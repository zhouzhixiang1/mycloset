package com.example.fragmentprova;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.style.IconMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class FragmentOne extends Fragment{

    ImageView imageView;
    ImageView imageView2;
    ImageButton btnConferma;
    ImageButton btnRifiuta;
    ImageButton btnModifica;
    ImageButton btnCrea;
    ImageButton btnArmadio;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        final DBAdapterLogin db = new DBAdapterLogin(view.getContext());

        imageView = view.findViewById(R.id.imageView);
        imageView2 = view.findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.t_shirt_maschio);
        imageView2.setImageResource(R.drawable.pantaloni_sigaretta_tasconi);

        btnConferma = view.findViewById(R.id.btnConferma);
        btnRifiuta = view.findViewById(R.id.btnRifiuta);
        btnModifica = view.findViewById(R.id.btnModifica);
        btnCrea = view.findViewById(R.id.btnCrea);
        btnArmadio = view.findViewById(R.id.btnArmadio);

        btnConferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnConferma.setBackgroundResource(R.mipmap.rifiuta);
            }
        });

        btnModifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentModificaOutfit = new FragmentModificaOutfit();
                getFragmentManager().beginTransaction().replace(R.id.container, fragmentModificaOutfit).commit();
            }
        });

        btnCrea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentAddOutfit = new FragmentAddOutfit();
                getFragmentManager().beginTransaction().replace(R.id.container, fragmentAddOutfit).commit();
                db.addVestito("rosso", 1, "calcestruzzo", 0);
            }
        });

        btnArmadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentArmadioOutfit = new FragmentArmadioOutfit();
                getFragmentManager().beginTransaction().replace(R.id.container, fragmentArmadioOutfit).commit();
            }
        });

        return view;
    }
}
