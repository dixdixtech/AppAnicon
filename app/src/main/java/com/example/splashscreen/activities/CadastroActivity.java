package com.example.splashscreen.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splashscreen.R;
import com.example.splashscreen.usuario.Usuario;
import com.example.splashscreen.usuario.UsuarioDAO;

public class CadastroActivity extends AppCompatActivity {

    Button btnConcluir;
    EditText txtNome, txtLogin, txtSenha;
    String UsuarioNome, UsuarioLogin, UsuarioSenha;
    TextView txtTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cadastro);

        btnConcluir = findViewById(R.id.btnCadastrar);
        txtNome = findViewById(R.id.editTextNome);
        txtLogin = findViewById(R.id.editTextEmail);
        txtSenha = findViewById(R.id.editTextSenha);
        txtTitulo = findViewById(R.id.UserName);

        Intent intent = getIntent();

        // EDITAR
        if (intent.hasExtra("Usuario")) {
            txtTitulo.setText(getString(R.string.editar));

            Usuario usuario = ((Usuario) intent.getSerializableExtra("Usuario"));

            txtNome.setText(usuario.getNome());
            txtLogin.setText(usuario.getLogin());

            btnConcluir.setOnClickListener(v -> {
                UsuarioNome = txtNome.getText().toString();
                UsuarioLogin = txtLogin.getText().toString();
                UsuarioSenha = txtSenha.getText().toString();

                txtSenha.setHint("Confirme sua senha");
                Usuario usuarioUpdate = new Usuario(
                        usuario.getId(),
                        UsuarioLogin,
                        UsuarioSenha,
                        UsuarioNome);

                UsuarioDAO usuarioDAO = new UsuarioDAO(CadastroActivity.this);

                try{
                    usuarioDAO.updateUsuario(usuarioUpdate);
                    Toast.makeText(getApplicationContext(), "Alteração efetuada.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getBaseContext(), ProfileActivity.class));
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            });
        }

        //CADASTRAR
        btnConcluir.setOnClickListener(v -> {
            UsuarioNome = txtNome.getText().toString();
            UsuarioLogin = txtLogin.getText().toString();
            UsuarioSenha = txtSenha.getText().toString();

            Usuario usuario = new Usuario(UsuarioLogin, UsuarioSenha, UsuarioNome);

            UsuarioDAO usuarioDAO = new UsuarioDAO(CadastroActivity.this);

            try {
                usuarioDAO.cadastrarUsuario(usuario);
                Toast.makeText(getApplicationContext(), "Cadastro efetuado com sucesso", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}