/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec;

/**
 *
 * @author professor02
 */
public class Console {
    private String nome;
    private int anoLancamento;
    private Fabricante fabricante;

    public String dados() {
        StringBuilder st = new StringBuilder();
        
        st.append("Nome: ").append(getNome());
        st.append("\nAno Lançamento: ").append(getAnoLancamento());
        st.append("\nFabricante: " + fabricante.getNome());
        
        return st.toString();
        
        //forma com desempenho ruim
        //String teste;
        //teste = "Nome:" + getNome();
        //teste += "ano:" + getAnoLancamento();
        
    }
    
    //construtor
    public Console(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

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

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
    
    
    
}
