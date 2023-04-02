/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec;

import java.util.Scanner;
import java.io.IOException;
import br.com.fatec.exception.PrecoException;

/**
 *
 * @author Paola
 */
public class Principal {
    public static void main(String[] args) {
        Produto produto = new Produto();
        Scanner teclado = new Scanner(System.in);
        
        //entrada de dados
        
        try{
           System.out.println("Digite o nome do produto: ");
           produto.setNome(teclado.nextLine()); 
           System.out.println("Digite o preço de custo: ");
           produto.setPrecoCusto(teclado.nextFloat());
           System.out.println("Digite o preço de venda: ");
           produto.setPrecoVenda(teclado.nextFloat());
        } catch (IOException ex) {
            System.out.println("Erro de IO:" + ex.getMessage());
        } catch(PrecoException ex){
            System.out.println("Erro de Preço: " + ex.getMessage());
        }
        try{
            produto.calculaLucro();
        }   
        catch(IOException ex){
            System.out.println("Erro de IO:" + ex.getMessage());
        }
        
        
    }
}
