package com.example.splashscreen;

public class Produto {

    private String id;
    private String cat;
    private String name;
    private String preco;
    private String garantia;
    private String validade;
    private String qtdestoque;
    private String desc;
    private String img;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getCat() {
        return cat;
    }
    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPreco() {
        return preco;
    }
    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getGarantia() {return garantia;}
    public void setGarantia(String garantia) {this.garantia = garantia;}

    public String getValidade() {return validade;}
    public void setValidade(String validade) {this.validade = validade;}

    public String getQtdestoque() {return qtdestoque;}
    public void setQtdestoque(String qtdestoque) {this.qtdestoque = qtdestoque;}

    public String getDesc() {return desc;}
    public void setDesc(String desc) {this.desc = desc;}

    public String getImg() {return img;}
    public void setImg(String img) {this.img = img;}
}

