package com.example.splashscreen;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class CarregaProduto extends AsyncTaskLoader<String> {
    private String mQueryString;
    public CarregaProduto(Context context, String queryString) {
        super(context);
        mQueryString = queryString;

    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
    @Nullable
    @Override
    public String loadInBackground() {

        return Conexao.BuscaInfoProd(mQueryString);
    }
}