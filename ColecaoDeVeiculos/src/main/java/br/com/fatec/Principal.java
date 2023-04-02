/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec;

import java.util.HashSet;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Paola
 */
public class Principal {
    public static void main(String[] args) {
        
        
        Scanner teclado = new Scanner(System.in);
        
        //cria Proprietario
        Proprietario p1 = new Proprietario();
        p1.setNome("Jonas");
        p1.setCpf("504.789.564-09");
        
        //colocar veiculos
        for(int i=0;i<5;i++){
            Veiculo veic = new Veiculo();
            System.out.println("Placa: ");
            veic.setPlaca(teclado.nextLine());
            System.out.println("Valor: ");
            veic.setValor(teclado.nextFloat());
            teclado.nextLine();
            p1.addVeiculo(veic);
        }
        
        String[] options = {"Sim", "Não"};
        
        int x = JOptionPane.showOptionDialog(null, "Deseja adicionar novos veiculos? ",
                "Adicionar Veiculos",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        System.out.println(x);
        if(x==0){
            Veiculo veic = new Veiculo();
            System.out.println("Placa: ");
            veic.setPlaca(teclado.nextLine());
            System.out.println("Valor: ");
            veic.setValor(teclado.nextFloat());
            p1.addVeiculo(veic);
        }
        
        
        //
        //Listando os veiculos
        for (Veiculo v : p1.getVeiculos()) {
            System.out.println("========================================================");
            System.out.println("Veiculo: ");
            System.out.println("Placa: " + v.getPlaca());
            System.out.println("Valor: " + v.getValor());
            System.out.println("========================================================");
        }
        //Veiculo ve;
        //ve :p1.valorBens();

    }
}
