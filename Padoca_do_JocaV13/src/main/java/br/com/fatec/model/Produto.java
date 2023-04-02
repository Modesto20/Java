package br.com.fatec.model;

public class Produto {
    private int id_Produto;
    private float preco;
    private String descricao;

    //Construtor
    public Produto() {
        
    }
    
    @Override
    public String toString() {
        return descricao;
    }
    
    public int getId_Produto() {
        return id_Produto;
    }

    public void setId_Produto(int id_Produto) {
        this.id_Produto = id_Produto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
