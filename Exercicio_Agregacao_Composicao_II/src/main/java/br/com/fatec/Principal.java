/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec;

import java.util.Scanner;

/**
 *
 * @author professor02
 */
public class Principal {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        Fabricante fabricante = new Fabricante();
        Console console = new Console(fabricante);
        
        jogo.setConsole(console);
        
        Scanner teclado = new Scanner(System.in);
        
        //entrada de dados
        System.out.println("Nome Jogo:");
        jogo.setNome(teclado.nextLine());
        System.out.println("Quantos Jogadores? ");
        jogo.setQtdJogadores(teclado.nextInt());

        //limpa o buffer
        teclado.nextLine();

        System.out.println("É onLine (S/N)?");
        char resp;
        resp = teclado.nextLine().charAt(0);
        if(resp == 'S' || resp == 's')
            jogo.setOnLine(true);
        else
            jogo.setOnLine(false);

        System.out.println("Nome do Console: ");
        console.setNome(teclado.nextLine());
        
        System.out.println("Ano Lançamento: ");
        console.setAnoLancamento(teclado.nextInt());
        
        //limpar o buffer, sempre depois de ler numero
        //e o próximo a ler é texto
        teclado.nextLine();
        
        System.out.println("Nome do Fabricante:");
        fabricante.setNome(teclado.nextLine());
        
        //exibir dados
        System.out.println("Dados do Jogo:");
        System.out.println("Jogo: " + jogo.getNome());
        System.out.println("Quantidade Jogadores: " +
                jogo.getQtdJogadores());
        System.out.println("É on line? " + 
                jogo.isOnLine());
        
        System.out.println("Dados: \n" + console.dados());
        
    }
}
