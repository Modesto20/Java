package br.com.fatec.model;

import br.com.fatec.App;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Cliente extends Application {
    public static Stage tela;
    
    @Override
    public void start(Stage tela) throws IOException {
        setStage(tela);
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ViewCliente.fxml"));
        Parent root = fxmlLoader.load();
        
        Scene scene = new Scene(root);
        
        tela.setScene(scene);
        tela.show();        
    }
    
    public static void setStage(Stage t) {
        tela = t;
    }
    
    private String cpf,nome,email,celular,cep,rua,bairro,cidade,uf;

    //Construtor
    public Cliente() {
        
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
