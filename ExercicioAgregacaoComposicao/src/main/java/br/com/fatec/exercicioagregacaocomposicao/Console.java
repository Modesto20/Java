/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.exercicioagregacaocomposicao;

/**
 *
 * @author Paola
 */
public class Console {
    //Atributos
    private String nome;
    private int anoLancamento;
    //private Fabricante nomeFabricante;
    
    //metodos
    public void Dados(Fabricante f1){
        System.out.println("Nome do Console: " + nome);
        System.out.println("Ano do Lançamento: " + anoLancamento);
        System.out.println("Nome do Fabricante:  " + f1.getNome());
    }
    //getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    
}
