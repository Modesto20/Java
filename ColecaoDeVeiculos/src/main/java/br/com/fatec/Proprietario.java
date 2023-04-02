/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Paola
 */
public class Proprietario {
    private String nome;
    private String cpf;
    private Veiculo valor;
   
    
    //coleção
    //private Set<Veiculo> veiculos = new HashSet<>();
    HashSet<Veiculo> veiculos = new HashSet<>();
    //HashSet<Corrente> contas = new HashSet<>();
     //  HashSet<String> placa = new HashSet<>();
    
    
    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Set<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Set<Veiculo> veiculos) {
        this.veiculos = (HashSet<Veiculo>) veiculos;
    }
    
    //metodos 
    public void addVeiculo(Veiculo veiculo){
        //adiciona na coleção
        veiculos.add(veiculo);
    }
    
    public void valorBens(){
        float total=0;
        Iterator it = valor.iterator(); //cria um obj iterador
        while(it.hasNext()) { //verifica se tem prx elmt
            Object aux = it.next(); //lê o prx elemento
            System.out.println("Valor: " + aux);
            //aux = aux.astype(float);
            //total=total+aux;
        }
        //return total;
    }
    
    public Veiculo removeVeiculo(String placa){
        //cria um obj auxiliar para conter somente a placa
        Veiculo procura = new Veiculo();
        
        //coloca a placa dentro deste objeto
        procura.setPlaca(placa);
        
        //vamos remover o veiculo da coleção
        for (Veiculo aux : veiculos) {
            //verifica se o objeto dentro da coleção
            //é igual a placa do parametro
            if(procura.equals(aux)) {
                veiculos.remove(procura);
                return aux; //devolve o objeto encontrado
            }
        }
        
        return null; //não achou ninguem
    }
}
