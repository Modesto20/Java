/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.exerciciodeheranca;

/**
 *
 * @author Paola
 */
public class Principal {
    public static void main(String[] args) {
         //criar Diretor
        Diretor d = new Diretor("João");

        d.setNome("João");//classe pai
        d.setSalario(5600); //classe pai
        d.setBonificacao(600);
        d.setVeiculo("BMW - X6"); // diretor
        d.setPlaca("BMW - 0000"); //diretor
        d.setSecretaria("Kelly");
        d.setSalarioSecretaria(2500);
        
        
        //exibir dados
        d.listarDados(); // só chama o metodo da classe GERENTE
                         // nao da para chamar a classe FUNCIONARIO
    }
}
