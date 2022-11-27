package com.example.splashscreen.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.splashscreen.InicioFragment;
import com.example.splashscreen.R;
import com.example.splashscreen.fragments.AcessoriosFragment;
import com.example.splashscreen.fragments.VestuarioFragment;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnPerfil, btnVestuario, btnAcessorios;
    private AcessoriosFragment acessoriosFragment;
    private VestuarioFragment vestuarioFragment;
    private InicioFragment inicioFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        btnVestuario = findViewById(R.id.ButtonVestuario);
        btnAcessorios = findViewById(R.id.ButtonAcessorios);


        inicioFragment = new InicioFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameConteudo, inicioFragment);
        transaction.commit();

        btnVestuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vestuarioFragment = new VestuarioFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, vestuarioFragment);
                transaction.commit();
            }
        });

        btnAcessorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acessoriosFragment = new AcessoriosFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, acessoriosFragment);
                transaction.commit();

            }
        });




        btnPerfil = findViewById(R.id.imageButtonPerfil);
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(a);
            }
        });

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent b = new Intent(getApplicationContext(), Activity_detalhes.class);
//                startActivity(b);
//            }
//        });
    }
}