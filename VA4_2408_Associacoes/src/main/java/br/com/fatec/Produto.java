/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec;

/**
 *
 * @author Aluno
 */
public class Produto {
    //atributos
    private int codigo;
    private String descricao;
    //agregação
    private Fornecedor fornecedor = new Fornecedor();
    
    //Composição
    private Transportador transportador; //deve aparecer no CONSTRUTOR
    
    //construtores
    //obriga a receber o TRANSPORTADOR para fazer a COMPOSIÇÃO
    public Produto(Transportador transp) {
        this.transportador = transp;
    }
    
    //getters e setters
    public Transportador getTransportador() {
        return transportador;
    }

    public void setTransportador(Transportador transportador) {    
        this.transportador = transportador;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
}
