package br.com.fatec.controllers;

import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.DAO.EnderecoDAO;
import br.com.fatec.model.Cliente;
import br.com.fatec.model.Endereco;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class ViewClienteController implements Initializable {

    @FXML
    private TextField txt_cpf;
    @FXML
    private TextField txt_nome;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_cel;
    @FXML
    private TextField txt_cep;
    @FXML
    private TextField txt_rua;
    @FXML
    private TextField txt_bairro;
    @FXML
    private TextField txt_cidade;
    @FXML
    private TextField txt_uf;
    @FXML
    private Button btn_pesquisar;
    @FXML
    private Button btn_incluir;
    @FXML
    private Button btn_alterar;
    @FXML
    private Button btn_remover;
    @FXML
    private Button btn_menu;
    
    private Cliente cliente;
    private ClienteDAO dao = new ClienteDAO();
    
    private Endereco endereco;
    private EnderecoDAO daoE = new EnderecoDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        habilitaInclusao(); 
        
        txt_cpf.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, 
                    Boolean oldValue, Boolean newValue) {
                if(newValue) { 
                    limparCampos();
                    habilitaInclusao();
                }
             }
        });
        
        txt_cep.focusedProperty().addListener((value, velho, novo) -> {
            if (!novo) {
                endereco = new Endereco();
        
                endereco.setCep(txt_cep.getText());
        
                try {
                    endereco = daoE.buscaID(endereco);
            
                    if(endereco != null) { 
                        //move os dados para a tela
                        txt_rua.setText(endereco.getRua());
                        txt_bairro.setText(endereco.getBairro());
                        txt_cidade.setText(endereco.getCidade());
                        txt_uf.setText(endereco.getUf());
                    }
                    else {
                        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Mensagem");
                        alerta.setHeaderText("Atenção");
                        alerta.setContentText("Endereço não encontrado !");
                        alerta.showAndWait(); 
                    }
                } catch (SQLException ex) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Mensagem");
                    alerta.setHeaderText("Erro .");
                    alerta.setContentText(ex.getMessage());
                    alerta.showAndWait(); 
                }
            }
        });
    }    

    @FXML
    private void btnPesquisar_Click(ActionEvent event) {
        cliente = new Cliente();
        
        cliente.setCpf(txt_cpf.getText());
        
        try {
            cliente = dao.buscaID(cliente);
            
            if(cliente != null) { 
                //move os dados para a tela
                txt_nome.setText(cliente.getNome());
                txt_email.setText(cliente.getEmail());
                txt_cel.setText(cliente.getCelular());
                txt_cep.setText(cliente.getCep());
                txt_rua.setText(cliente.getRua());
                txt_bairro.setText(cliente.getBairro());
                txt_cidade.setText(cliente.getCidade());
                txt_uf.setText(cliente.getUf());
                
                habilitaAlteracaoRemocao();
            }
            else {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Cliente não encontrado !");
                alerta.showAndWait(); 
                
                txt_cpf.requestFocus();
            }
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensagem");
            alerta.setHeaderText("Erro .");
            alerta.setContentText(ex.getMessage());
            alerta.showAndWait(); 
            
            txt_cpf.requestFocus();
        }
    }

    @FXML
    private void btnIncluir_Click(ActionEvent event) {
        cliente = new Cliente();
        
        cliente.setCpf(txt_cpf.getText());
        cliente.setNome(txt_nome.getText());
        cliente.setEmail(txt_email.getText());
        cliente.setCelular(txt_cel.getText());
        cliente.setCep(txt_cep.getText());
        cliente.setRua(txt_rua.getText());
        cliente.setBairro(txt_bairro.getText());
        cliente.setCidade(txt_cidade.getText());
        cliente.setUf(txt_uf.getText());
        
        try {
            if(dao.insere(cliente)) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Dados incluídos com sucesso !");
                alerta.showAndWait();
                
                limparCampos();
                
                txt_cpf.requestFocus();
            }
            else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Ocorreu algum problema .");
                alerta.showAndWait(); 
            }
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensagem");
            alerta.setHeaderText("Atenção");
            alerta.setContentText(ex.getMessage());
            alerta.showAndWait(); 
        }
    }

    @FXML
    private void btnAlterar_Click(ActionEvent event) {
        cliente = new Cliente();
        
        cliente.setCpf(txt_cpf.getText());
        cliente.setNome(txt_nome.getText());
        cliente.setEmail(txt_email.getText());
        cliente.setCelular(txt_cel.getText());
        cliente.setCep(txt_cep.getText());
        cliente.setRua(txt_rua.getText());
        cliente.setBairro(txt_bairro.getText());
        cliente.setCidade(txt_cidade.getText());
        cliente.setUf(txt_uf.getText());
        
        try {
            if(dao.altera(cliente)) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Dados alterados com sucesso !");
                alerta.showAndWait(); 
                
                limparCampos();
                
                txt_cpf.requestFocus();
                
                habilitaInclusao();
            }
            else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Ocorreu algum problema .");
                alerta.showAndWait(); 
            }
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensagem");
            alerta.setHeaderText("Atenção");
            alerta.setContentText(ex.getMessage());
            alerta.showAndWait(); 
        }
    }

    @FXML
    private void btnRemover_Click(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText("Atenção");
        alerta.setContentText("Deseja realmente remover o cliente ?");

        Optional<ButtonType> resultado = alerta.showAndWait();
        
        if (resultado.get() == ButtonType.CANCEL){
            return; 
        }

        cliente = new Cliente();
        
        cliente.setCpf(txt_cpf.getText());
        cliente.setNome(txt_nome.getText());
        cliente.setEmail(txt_email.getText());
        cliente.setCelular(txt_cel.getText());
        cliente.setCep(txt_cep.getText());
        cliente.setRua(txt_rua.getText());
        cliente.setBairro(txt_bairro.getText());
        cliente.setCidade(txt_cidade.getText());
        cliente.setUf(txt_uf.getText());
        
        try {
            if(dao.remove(cliente)) {
                alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Cliente removido com sucesso !");
                alerta.showAndWait(); 
                         
                limparCampos();
                
                txt_cpf.requestFocus();
                
                habilitaInclusao();
            }
            else {
                alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Ocorreu algum problema .");
                alerta.showAndWait(); 
            }
        } catch (SQLException ex) {
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensagem");
            alerta.setHeaderText("Atenção");
            alerta.setContentText(ex.getMessage());
            alerta.showAndWait(); 
        }
    }

    private void habilitaInclusao() {
        btn_incluir.setDisable(false);
        btn_remover.setDisable(true);
        btn_alterar.setDisable(true);
    }
    
    private void habilitaAlteracaoRemocao(){
        btn_incluir.setDisable(true);
        btn_remover.setDisable(false);
        btn_alterar.setDisable(false); 
    }
    
    private void limparCampos() {
        txt_cpf.setText("");
        txt_nome.setText("");
        txt_email.setText("");
        txt_cel.setText("");
        txt_cep.setText("");
        txt_rua.setText("");
        txt_bairro.setText("");
        txt_cidade.setText("");
        txt_uf.setText("");
    }

    @FXML
    private void btnMenu_Click(ActionEvent event) {
        Cliente.tela.close();
    }
    
}
