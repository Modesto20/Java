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
        //criando um transportador
        Transportador t = new Transportador();
        //colocando dado para ele
        t.setRazaoSocial("Julio Simões");
        t.setCusto(3500);
        
        //passando o TRANSPORTADOR para o Produto //1º forma
        //tenho acesso ao transportador de duas maneira pelo objeto
        //p1 e também pelo objeto t
        Produto p1 = new Produto(t);
        //alterando o custo do transporte
        //1ªmaneira
        p1.getTransportador().setCusto(2000);
        //2ª maneira
        t.setCusto(2000);
        
        p1.setCodigo(1);
        p1.setDescricao("Regua");
        //colocar dados do fornecedor
        p1.getFornecedor().setNome("Faber Castel");
        
        //criando P2 com um objeto TRANSPORTADOR ANONIMO
        Produto p2 = new Produto(new Transportador());
        //colocando dados para o Transportador
        //só existe uma forma de acessar o Transportador, que é pelo
        //obejto P2
        p2.getTransportador().setRazaoSocial("Grenero");
        p2.getTransportador().setCusto(3400);
        
        Fornecedor f = new Fornecedor();
        f.setNome("Pilot");
        p2.setCodigo(2);
        p2.setDescricao("Caneta para Quadro branco");
        //fazendo a agregacao
        p2.setFornecedor(f);
        
        f.setNome("BIC");
    }
}
