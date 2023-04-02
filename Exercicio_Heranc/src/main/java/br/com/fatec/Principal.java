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
public class Principal {
    public static void main(String[] args) {
        Secretaria sec = new Secretaria();
        Diretor dir = new Diretor(sec);
        dir.setNome("João");
        dir.setBonificacao(600);
        dir.setSalario(5600);
        
        Veiculo vei = new Veiculo();
        vei.setModelo("BMW X6");
        vei.setPlaca("BMW-0000");
        dir.setVeiculo(vei);
        
        sec.setNome("Kelly");
        sec.setSalario(2500);
        
        System.out.println("Secretária: " +
                dir.getSecretaria().getNome());
        System.out.println("Salario Diretor: " + 
                dir.getSalario());
        System.out.println("Salario Secretaria: " + 
                dir.getSecretaria().getSalario());
        System.out.println("Placa: " + 
                dir.getVeiculo().getPlaca());
        System.out.println("Salario Original Diretor: " +
                (dir.getSalario() - dir.getBonificacao()));
  
    }
}
