package br.com.fatec.controllers;

import br.com.fatec.model.Cliente;
import br.com.fatec.model.Consulta;
import br.com.fatec.model.Endereco;
import br.com.fatec.model.Funcionario;
import br.com.fatec.model.Pedido;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ViewMenuController implements Initializable {

    @FXML
    private Button btn_cliente;
    @FXML
    private Button btn_endereco;
    @FXML
    private Button btn_pedido;
    @FXML
    private Button btn_consulta;
    @FXML
    private Button btn_funcionario;
    
    private Stage tela = new Stage();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void btnCliente_Click(ActionEvent event) throws IOException {
        Cliente client = new Cliente();
        client.start(new Stage());
    }

    @FXML
    private void btnEndereco_Click(ActionEvent event) throws IOException {
        Endereco end = new Endereco();
        end.start(new Stage());
    }

    @FXML
    private void btnPedido_Click(ActionEvent event) throws IOException {
        Pedido pd = new Pedido();
        pd.start(new Stage());
    }

    @FXML
    private void btnConsulta_Click(ActionEvent event) throws IOException {
        Consulta consult = new Consulta();
        consult.start(new Stage());
    }

    @FXML
    private void btnFuncionario_Click(ActionEvent event) throws IOException {
        Funcionario fun = new Funcionario();
        fun.start(new Stage());
    }
    
}
