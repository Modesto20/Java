/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.exerciciodeheranca;

/**
 *
 * @author Paola
 */
public class Gerente extends Funcionario{
    private String secretaria;
    private double salarioSecretaria;
    protected double bonificacao;
    

    //metodos

    @Override
    public int getProgramarFerias(){
        return this.ferias=40;
    } 
    
    @Override
    public void listarDados(){
        //chamando o método  listarDados() de FUNCIONARIO
        super.listarDados();
        System.out.println("Bonificação: " + bonificacao);
        System.out.println("Secretaria: " + secretaria);
        System.out.println("Salario Secretaria: " + salarioSecretaria);
        getNome();     
    }
    //construtor 
    public Gerente(String nome){
        super(nome); // chama o contrutor da superclasse
    }
    
    //getters e setters
    public String getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(String secretaria) {
        this.secretaria = secretaria;
    }

    public double getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(double bonificacao) {
        this.bonificacao = bonificacao;
    }

    public double getSalarioSecretaria() {
        return salarioSecretaria;
    }

    public void setSalarioSecretaria(double salarioSecretaria) {
        this.salarioSecretaria = salarioSecretaria;
    }
    
  
    
}
