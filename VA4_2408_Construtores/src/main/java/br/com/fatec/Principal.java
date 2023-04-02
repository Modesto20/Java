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
        //criando dois objetos
        
        Produto p1, p2;
        p1 = new Produto();
        p2 = new Produto(2345, "TV LG 43\"");
        
        //mostrando os dados
        System.out.println("Código de P1: " + p1.getCodigo());
        System.out.println("Fornecedor de P1: " + p1.getFornecedor());
        
        System.out.println("Código de P2: " + p2.getCodigo());
        System.out.println("Fornecedor de P2: " + p2.getFornecedor());
    }
}
