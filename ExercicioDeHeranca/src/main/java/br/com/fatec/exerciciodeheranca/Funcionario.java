/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.exerciciodeheranca;

/**
 *
 * @author Paola
 */
public class Funcionario {
    private String nome;
    protected double salario;
    private int registro;
    protected int ferias;
    
    //metodos
    public void listarDados(){
        System.out.println("Nome: " + nome);
        System.out.println("Salario: " + salario);
    }
    
    public int getProgramarFerias(){
        return this.ferias = 30;
    }

    public int getFerias() {
        return ferias;
    }

    public void setFerias(int ferias) {
        this.ferias = ferias;
    }
    
    //construtores
    public Funcionario(String nome) {
        this.nome = nome;
    } 

    public Funcionario(double salario, int ferias) {
        this.salario = salario;
        this.ferias = ferias;
    }
    
    
    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }
    
}
