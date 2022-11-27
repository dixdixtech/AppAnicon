package com.example.splashscreen;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    public class BancodeDados extends SQLiteOpenHelper {
    public static final String PROD_TABLE_NAME = "tb_produto";

    public static final String COLUMN_ID_PROD = "id";
    public static final String COLUMN_NAME_PROD = "name";
    public static final String COLUMN_CAT_PROD = "categoria";
    public static final String COLUMN_PRECO_PROD = "preco";
    public static final String COLUMN_GARANTIA = "garantia";
    public static final String COLUMN_VALIDADE = "validade";
    public static final String COLUMN_QTDESTOQUE = "qtdestoque";
    public static final String COLUM_DESC_PROD = "descprod";
    public static final String COLUM_IMG_PROD = "imgprod";



    private static final String name = "db_anicon.db";
    private static final int version = 1;


    public BancodeDados(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tbUsuario(" +
                "idUsuario INTEGER PRIMARY KEY AUTOINCREMENT," +
                "login TEXT NOT NULL," +
                "senha TEXT NOT NULL," +
                "nome TEXT NOT NULL)");

        String CriaProduto = "create table " + PROD_TABLE_NAME + "( "
                + COLUMN_ID_PROD + " text primary key, "
                + COLUMN_NAME_PROD + " text not null, "
                + COLUMN_CAT_PROD + " text not null, "
                + COLUMN_PRECO_PROD + " text, "
                + COLUMN_GARANTIA + " text, "
                + COLUMN_VALIDADE + " text, "
                + COLUMN_QTDESTOQUE + " text, "
                + COLUM_DESC_PROD + "text, "
                + COLUM_IMG_PROD + "text)";
        db.execSQL(CriaProduto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    public String addProd(Produto produto){
        long resultado;
        produto = new Produto();
        //estancia para escrita no banco
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(COLUMN_ID_PROD, produto.getId());
        values.put(COLUMN_NAME_PROD, produto.getName());
        values.put(COLUMN_CAT_PROD, produto.getCat());
        values.put(COLUMN_PRECO_PROD, produto.getPreco());
        values.put(COLUMN_GARANTIA, produto.getGarantia());
        values.put(COLUMN_VALIDADE, produto.getValidade());
        values.put(COLUMN_QTDESTOQUE, produto.getQtdestoque());
        values.put(COLUM_DESC_PROD, produto.getDesc());
        values.put(COLUM_IMG_PROD, produto.getImg());

        //insere no banco
        resultado = db.insert(PROD_TABLE_NAME, null, values);
        db.close();

        if (resultado ==-1) {
            return "Erro ao inserir registro";
        }else{
            return "Registro Inserido com sucesso";
        }
    }

    public Cursor getNovaQuery(String sql)
    {
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        return cursor;
    }
}
