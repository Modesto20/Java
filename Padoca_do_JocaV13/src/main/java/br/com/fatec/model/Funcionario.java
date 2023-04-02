package br.com.fatec.model;

import br.com.fatec.App;

import java.io.IOException;
import java.util.Objects;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Funcionario extends Application {
    public static Stage tela;
    
    @Override
    public void start(Stage tela) throws IOException {
        setStage(tela);
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ViewFuncionario.fxml"));
        Parent root = fxmlLoader.load();
        
        Scene scene = new Scene(root);
        
        tela.setScene(scene);
        tela.show();        
    }
    
    public static void setStage(Stage t) {
        tela = t;
    }
    
    private String cpf,nome,data_Admissao,cargo,data_Nascimento;

    //Construtor
    public Funcionario() {
        
    }
    
    public Funcionario(String cpf, String nome, String data_Admissao, String cargo, String data_Nascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.data_Admissao = data_Admissao;
        this.cargo = cargo;
        this.data_Nascimento = data_Nascimento;
    }
    
    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        return Objects.equals(this.cpf, other.cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_Admissao() {
        return data_Admissao;
    }

    public void setData_Admissao(String data_Admissao) {
        this.data_Admissao = data_Admissao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getData_Nascimento() {
        return data_Nascimento;
    }

    public void setData_Nascimento(String data_Nascimento) {
        this.data_Nascimento = data_Nascimento;
    }
}
