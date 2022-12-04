package com.example.splashscreen.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.widget.ImageButton;


import com.example.splashscreen.BancodeDados;
import com.example.splashscreen.CarregaProduto;
import com.example.splashscreen.fragments.InicioFragment;
import com.example.splashscreen.Produto;
import com.example.splashscreen.R;
import com.example.splashscreen.fragments.AcessoriosFragment;
import com.example.splashscreen.fragments.ColecionaveisFragment;
import com.example.splashscreen.fragments.DecoracoesFragment;
import com.example.splashscreen.fragments.LivrosFragment;
import com.example.splashscreen.fragments.VestuarioFragment;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private ImageButton btnPerfil, btnVestuario, btnAcessorios, btnColecionaveis, btnLivros, btnDecoracoes;
    private EditText nm_produto;
    private AcessoriosFragment acessoriosFragment;
    private VestuarioFragment vestuarioFragment;
    private ColecionaveisFragment colecionaveisFragment;
    private LivrosFragment livrosFragment;
    private DecoracoesFragment decoracoesFragment;
    private InicioFragment inicioFragment;

    private TextView txtnmproduto, txtprecoproduto;


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

        /*
        txtnmproduto = findViewById(R.id.txtnmproduto);
        txtprecoproduto = findViewById(R.id.txtprecoproduto);
         */

        if (getSupportLoaderManager().getLoader(0) != null) {
            getSupportLoaderManager().initLoader(0, null, this);
        }


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
    }



        public void buscaProdutos(View view) {
            // Recupera a string de busca.
            String queryString = nm_produto.getText().toString();
            // esconde o teclado qdo o botão é clicado
            InputMethodManager inputManager = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            if (inputManager != null) {
                inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }

            // Verifica o status da conexão de rede
            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = null;
            if (connMgr != null) {
                networkInfo = connMgr.getActiveNetworkInfo();
            }
            /* Se a rede estiver disponivel e o campo de busca não estiver vazio
            iniciar o Loader CarregaProdutos */

            if (networkInfo != null && networkInfo.isConnected()
                    && queryString.length() != 0) {
                Bundle queryBundle = new Bundle();
                queryBundle.putString("queryString", queryString);
                getSupportLoaderManager().restartLoader(0, queryBundle, this);
                txtnmproduto.setText(R.string.str_empty);
                txtnmproduto.setText(R.string.loading);
            }

            // atualiza a textview para informar que não há conexão ou termo de busca
            else {
                if (queryString.length() == 0) {
                    txtnmproduto.setText(R.string.str_empty);
                    txtnmproduto.setText(R.string.no_search_term);
                } else {
                    txtnmproduto.setText(" ");
                    txtnmproduto.setText(R.string.no_network);
                }
            }
        }

        @NonNull
        @Override
        public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
            String queryString = "";
            if (args != null) {
                queryString = args.getString("queryString");
            }
            return new CarregaProduto(this, queryString);
        }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            // Converte a resposta em Json
            JSONObject jsonObject = new JSONObject(data);
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            // inicializa o contador
            int i = 0;
            String nome = null;
            String preco = null;
            // Procura pro resultados nos itens do array
            while (i < itemsArray.length() &&
                    (preco == null && nome == null)) {
                // Obtem a informação
                JSONObject prod = itemsArray.getJSONObject(i);
                JSONObject prodInfo = prod.getJSONObject("prodInfo");


                try {
                    nome = prodInfo.getString("nome");
                    preco = prodInfo.getString("preco");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // move para a proxima linha
                i++;
            }
            //mostra o resultado qdo possivel.
            if (nome != null && preco != null) {
                txtnmproduto.setText(nome);
                txtprecoproduto.setText(preco);
                //nmLivro.setText(R.string.str_empty);
            } else {
                // If none are found, update the UI to show failed results.
                txtnmproduto.setText(R.string.no_results);
                txtprecoproduto.setText(R.string.str_empty);
            }
        } catch (Exception e) {
            // Se não receber um JSOn valido, informa ao usuário
            txtnmproduto.setText(R.string.no_results);
            txtprecoproduto.setText(R.string.str_empty);
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }


}
