package com.example.splashscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.splashscreen.usuario.Usuario;
import com.google.gson.Gson;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProfileActivity extends AppCompatActivity {

    private static final String FILE_NAME = "usuarioLogado.json";
    TextView txtUsuario;
    EditText txtLogin, txtSenha;
    Button btnEditar, btnSair;
    ImageButton btnvoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();


        setContentView(R.layout.activity_profile);

        txtUsuario = findViewById(R.id.UserName);
        txtLogin = findViewById(R.id.editTextEmail);
        txtSenha = findViewById(R.id.editTextSenha);
        btnEditar = findViewById(R.id.btneditar);
        btnSair = findViewById(R.id.btnSair);
        btnvoltar = findViewById(R.id.btnvoltar);

        Gson gson = new Gson();
        String usuarioJson = lerDados();
        Usuario usuario = gson.fromJson(usuarioJson, Usuario.class);

        txtUsuario.setText(usuario.getNome());
        txtLogin.setHint(usuario.getLogin());

        btnvoltar.setOnClickListener(v ->{
            Intent main = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(main);
        });

        btnEditar.setOnClickListener(v -> {
            Intent intentEditar = new Intent(getApplicationContext(), CadastroActivity.class);
            intentEditar.putExtra("Usuario", usuario);
            startActivity(intentEditar);
        });


        btnSair.setOnClickListener(v -> {
            Intent login = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(login);
        });
    }


    private String lerDados() {
        FileInputStream fis;
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
