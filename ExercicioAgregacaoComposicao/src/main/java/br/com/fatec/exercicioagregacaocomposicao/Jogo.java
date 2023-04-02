/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.exercicioagregacaocomposicao;

/**
 *
 * @author Paola
 */
public class Jogo {
    
    private String nome;
    private int qtdJogadores;
    private boolean online;
    
    //metodos
    public void Jogo(){
        
    }
    public Jogo(){
        this.online = false;
    }
    //construtor

    public Jogo(String nome) {
        this.nome = nome;
    }
    
    //getters e setters 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdJogadores() {
        return qtdJogadores;
    }

    public void setQtdJogadores(int qtdJogadores) {
        this.qtdJogadores = qtdJogadores;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
    
}
