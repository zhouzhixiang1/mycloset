package com.example.fragmentprova;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class FragmentLogin extends Fragment {

    EditText email;
    EditText password;

    ImageButton btnLogin;
    ImageButton btnRegistrati;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);

        btnLogin = view.findViewById(R.id.btnLogin);
        btnRegistrati = view.findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailInserita = email.getText().toString();
                String passwordInserita = password.getText().toString();

            }
        });

        btnRegistrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentRegistrati = new FragmentRegistrati();
                getFragmentManager().beginTransaction().replace(R.id.container, fragmentRegistrati).commit();
            }
        });



        return view;
    }
}
