package com.example.splashscreen;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "db_anicon.db";
    private static final int version = 1;

    public Conexao(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tbUsuario(" +
                "idUsuario INTEGER PRIMARY KEY AUTOINCREMENT," +
                "login TEXT NOT NULL," +
                "senha TEXT NOT NULL," +
                "nome TEXT NOT NULL)");
        db.execSQL("CREATE TABLE tbProduto(" +
                "cdProd INTEGER," +
                "nomeProd TEXT NOT NULL," +
                "animeProd TEXT," +
                "precoProd TEXT NOT NULL)");
        db.execSQL("CREATE TABLE tbFavoritos(" +
                "fkUsuario INTEGER," +
                "fkProd TEXT," +
                "FOREIGN KEY (fkUsuario) REFERENCES tbUsuario (idUsuario), " +
                "FOREIGN KEY (fkProd) REFERENCES tbProduto (cdProd))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbProduto");
        db.execSQL("DROP TABLE IF EXISTS tbFavoritos");

        onCreate(db);
    }

    public Cursor getNovaQuery(String sql)
    {
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        return cursor;
    }
}
