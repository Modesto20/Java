/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.exercicioagregacaocomposicao;

import java.util.Scanner;
/**
 *
 * @author Paola
 */
public class Principal {
    public static void main(String[] args) {
        
        //cria uma entrada via teclado
        Scanner teclado = new Scanner(System.in);
        
         //cria novo objeto
        Jogo j1 = new Jogo();
        System.out.println("Digite o nome do jogo: ");
        j1.setNome(teclado.nextLine());
       // teclado.nextLine();//limpa o teclado (antigo fflush())
        System.out.println("Digite a quantidade de jogadores: ");
        j1.setQtdJogadores(teclado.nextInt());
        teclado.nextLine();
        Fabricante f1 = new Fabricante();
        System.out.println("Digite o nome do fabricante: ");
        f1.setNome(teclado.nextLine());
        Console c1 = new Console();
        System.out.println("Digite o nome do console: ");
        c1.setNome(teclado.nextLine());
        System.out.println("Digite o ano de laçamento: ");
        c1.setAnoLancamento(teclado.nextInt());
        //j1.Jogo();
        c1.Dados(f1);
    }
}
