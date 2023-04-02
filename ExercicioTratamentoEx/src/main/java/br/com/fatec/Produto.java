/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec;
import br.com.fatec.exception.PrecoException;
import java.io.IOException;

/**
 *
 * @author Paola
 */
public class Produto {
    
    private String nome;
    private float lucro, precoCusto, precoVenda;
    
    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IOException{
        if(nome.length() < 5){
            throw new IOException("Nome Inválido...");
        }
        this.nome = nome;
    }

    public float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(float precoCusto) {
        this.precoCusto = precoCusto;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) throws PrecoException{
        if(precoVenda < this.precoCusto){
            throw new PrecoException("O preço de Venda deve ser maior que o de custo...");
        }
        this.precoVenda = precoVenda;
    }
    

    //metodos
    public void calculaLucro() throws IOException{
          this.lucro = this.precoVenda-this.precoCusto;  
            if(this.lucro < 150) {
                throw new IOException("Inválido! Menos de 150 de lucro...");
            }
            System.out.println("O lucro é de: " + this.lucro);
        
        
    }
}
