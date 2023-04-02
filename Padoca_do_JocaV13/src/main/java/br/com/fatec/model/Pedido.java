package br.com.fatec.model;

import br.com.fatec.App;

import java.io.IOException;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Pedido extends Application {
    public static Stage tela;
    
    @Override
    public void start(Stage tela) throws IOException {
        setStage(tela);
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ViewPedido.fxml"));
        Parent root = fxmlLoader.load();
        
        Scene scene = new Scene(root);
        
        tela.setScene(scene);
        tela.show();        
    }
    
    public static void setStage(Stage t) {
        tela = t;
    }
    
    private final SimpleIntegerProperty id_Pedido,qtd_Pedido,id_Produto;
    private final SimpleFloatProperty valor_Total;
    private final SimpleStringProperty nome_Cliente,nome_Produto,cpf;
    private final SimpleBooleanProperty selecionado;

    //Construtor
    public Pedido() {
        this.id_Pedido = new SimpleIntegerProperty(0);
        this.qtd_Pedido = new SimpleIntegerProperty(0);
        this.id_Produto = new SimpleIntegerProperty(0);
        this.valor_Total = new SimpleFloatProperty(0);
        this.nome_Cliente = new SimpleStringProperty("");
        this.nome_Produto = new SimpleStringProperty("");
        this.cpf = new SimpleStringProperty("");
        this.selecionado = new SimpleBooleanProperty(false);
    }
    
    public Pedido(int id_Pedido, int qtd_Pedido, int id_Produto, float valor_Total, float valor_Unit, 
                  String nome_Cliente, String nome_Produto, String cpf) {
        this.id_Pedido = new SimpleIntegerProperty(id_Pedido);
        this.qtd_Pedido = new SimpleIntegerProperty(qtd_Pedido);
        this.id_Produto = new SimpleIntegerProperty(id_Produto);
        this.valor_Total = new SimpleFloatProperty(valor_Total);
        this.nome_Cliente = new SimpleStringProperty(nome_Cliente);
        this.nome_Produto = new SimpleStringProperty(nome_Produto);
        this.cpf = new SimpleStringProperty(cpf);
        this.selecionado = new SimpleBooleanProperty(false);
    }
    
    //retorna as propriedades
    public SimpleIntegerProperty id_PedidoProperty() {
        return id_Pedido;
    }

    public SimpleIntegerProperty qtd_PedidoProperty() {
        return qtd_Pedido;
    }
    
    public SimpleIntegerProperty id_ProdutoProperty() {
        return id_Produto;
    }
    
    public SimpleFloatProperty valor_TotalProperty() {
        return valor_Total;
    }
    
    public SimpleStringProperty nome_ClienteProperty() {
        return nome_Cliente;
    }
    
    public SimpleStringProperty nome_ProdutoProperty() {
        return nome_Produto;
    }
    
    public SimpleStringProperty cpfProperty() {
        return cpf;
    }
    
    public SimpleBooleanProperty selecionadoProperty() {
        return selecionado;
    }
    
    //getters e setters
    public int getId_Pedido() {
        return id_Pedido.get();
    }

    public void setId_Pedido(int id_Pedido) {
        this.id_Pedido.set(id_Pedido);
    }
    
    public int getQtd_Pedido() {
        return qtd_Pedido.get();
    }

    public void setQtd_Pedido(int qtd_Pedido) {
        this.qtd_Pedido.set(qtd_Pedido);
    }
    
    public int getId_Produto() {
        return id_Produto.get();
    }

    public void setId_Produto(int id_Produto) {
        this.id_Produto.set(id_Produto);
    }
    
    public float getValor_Total() {
        return valor_Total.get();
    }

    public void setValor_Total(float valor_Total) {
        this.valor_Total.set(valor_Total);
    }
    
    public String getNome_Cliente() {
        return nome_Cliente.get();
    }
    
    public void setNome_Cliente(String nome_Cliente) {
        this.nome_Cliente.set(nome_Cliente);
    }
    
    public String getNome_Produto() {
        return nome_Produto.get();
    }
    
    public void setNome_Produto(String nome_Produto) {
        this.nome_Produto.set(nome_Produto);
    }
    
    public String getCpf() {
        return cpf.get();
    }
    
    public void setCpf(String cpf) {
        this.cpf.set(cpf);
    }
    
    public boolean isSelecionado() {
        return selecionado.get();
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado.set(selecionado);
    }
}
