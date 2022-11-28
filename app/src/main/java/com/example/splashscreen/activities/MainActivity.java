package com.example.splashscreen.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.splashscreen.BancodeDados;
import com.example.splashscreen.fragments.InicioFragment;
import com.example.splashscreen.Produto;
import com.example.splashscreen.R;
import com.example.splashscreen.fragments.AcessoriosFragment;
import com.example.splashscreen.fragments.ColecionaveisFragment;
import com.example.splashscreen.fragments.DecoracoesFragment;
import com.example.splashscreen.fragments.LivrosFragment;
import com.example.splashscreen.fragments.VestuarioFragment;

public class MainActivity extends AppCompatActivity{

    private ImageButton btnPerfil, btnVestuario, btnAcessorios, btnColecionaveis, btnLivros, btnDecoracoes;
    private EditText nm_produto;
    private AcessoriosFragment acessoriosFragment;
    private VestuarioFragment vestuarioFragment;
    private ColecionaveisFragment colecionaveisFragment;
    private LivrosFragment livrosFragment;
    private DecoracoesFragment decoracoesFragment;
    private InicioFragment inicioFragment;


    Produto produto = new Produto();
    BancodeDados db=new BancodeDados(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        nm_produto = findViewById(R.id.input);
        btnVestuario = findViewById(R.id.ButtonVestuario);
        btnAcessorios = findViewById(R.id.ButtonAcessorios);
        btnColecionaveis = findViewById(R.id.ButtonColecionaveis);
        btnLivros = findViewById(R.id.ButtonLivros);
        btnDecoracoes = findViewById(R.id.ButtonDecoracoes);


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

        btnColecionaveis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colecionaveisFragment = new ColecionaveisFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, colecionaveisFragment);
                transaction.commit();

            }
        });

        btnColecionaveis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colecionaveisFragment = new ColecionaveisFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, colecionaveisFragment);
                transaction.commit();

            }
        });

        btnLivros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                livrosFragment = new LivrosFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, livrosFragment);
                transaction.commit();

            }
        });

        btnDecoracoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decoracoesFragment = new DecoracoesFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, decoracoesFragment);
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