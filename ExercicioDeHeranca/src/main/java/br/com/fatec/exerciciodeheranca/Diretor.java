/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.exerciciodeheranca;

/**
 *
 * @author Paola
 */
public class Diretor extends Gerente{
    private String veiculo;
    private String placa;
    
    //metodos
    
    @Override
    public void listarDados(){
        //chamando o método  listarDados() de GERENTE
        super.listarDados();
        System.out.println("Veiculo: " + veiculo + " - Placa: " + placa);
        System.out.println("Salario Original: " +  (salario - bonificacao));
        getNome(); 
    }
    
    //construtor
    public Diretor (String nome){
        super(nome); // chama o contrutor da superclasse
    }
    
    //getters e setters
    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    
    
}
