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
public class Gerente extends Funcionario {
    private double bonificacao;
    private Secretaria secretaria; //composição

    /**
     * Todo Gerente DEVE possui uma secretaria
     * @param secretaria 
     */
    public Gerente(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }
        
    /**
     * Retorna salario + bonificacao
     * @return 
     */
    public double getSalario() {
        return super.getSalario() + getBonificacao();
    }
    
    /**
     * Retorna as ferias do funcionario + 10 dias
     * @return 
     */
    @Override
    public int ferias() {
        return super.ferias() + 10;
    }
    
    public double getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(double bonificacao) {
        this.bonificacao = bonificacao;
    }
    
    
}
