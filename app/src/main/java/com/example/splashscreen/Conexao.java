package com.example.splashscreen;

import android.net.Uri;
import android.util.JsonReader;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Conexao {
private static final String LOG_TAG = Conexao.class.getSimpleName();
    // Constantes utilizadas pela API
    // URL para a API dos Produtos
    private static final String PROD_URL = "URL DA API";
    // Parametros da string de Busca
    private static final String QUERY_PARAM = "Prod_Name";

    // Limitador da qtde de resultados
    private static final String MAX_RESULTS = "maxResults";
    // Parametro do tipo de impressão
    private static final String TIPO_IMPRESSAO = "printType";

    static String BuscaInfoProd(String queryString){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String prodJSONString = null;

        try {
            Uri builtURI;
            if(queryString == null){
                builtURI = Uri.parse(PROD_URL).buildUpon()
                        .build();
            }
            else {
                String url1 = PROD_URL + queryString;
                //Construção da URI de Busca
                builtURI = Uri.parse(url1).buildUpon()
                        .build();


            }
            // Converte a URI para a URL.
            URL requestURL = new URL(builtURI.toString());
            // Abre a conexão de rede
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            // Busca o InputStream.
            InputStream inputStream = urlConnection.getInputStream();
            // Cria o buffer para o input stream
            reader = new BufferedReader(new InputStreamReader(inputStream));
            // Usa o StringBuilder para receber a resposta.
            StringBuilder builder = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Adiciona a linha a string.
                builder.append(linha);
                builder.append("\n");
            }
            if (builder.length() == 0) {
                // se o stream estiver vazio não faz nada
                return null;
            }
            prodJSONString = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // fecha a conexão e o buffer.
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // escreve o Json no log
        Log.d(LOG_TAG, prodJSONString);
        return prodJSONString;
    }

}
