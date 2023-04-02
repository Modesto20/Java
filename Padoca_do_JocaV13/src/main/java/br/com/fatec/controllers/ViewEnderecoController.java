package br.com.fatec.controllers;

import br.com.fatec.DAO.EnderecoDAO;
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

public class ViewEnderecoController implements Initializable {

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

    private Endereco endereco;
    private EnderecoDAO dao = new EnderecoDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        habilitaInclusao(); 
        
        txt_cep.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, 
                    Boolean oldValue, Boolean newValue) {
                if(newValue) { 
                    limparCampos();
                    habilitaInclusao();
                }
             }
        });
    }    

    @FXML
    private void btnIncluir_Click(ActionEvent event) {
        endereco = new Endereco();
        
        endereco.setCep(txt_cep.getText());
        endereco.setRua(txt_rua.getText());
        endereco.setBairro(txt_bairro.getText());
        endereco.setCidade(txt_cidade.getText());
        endereco.setUf(txt_uf.getText());
        
        try {
            if(dao.insere(endereco)) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Dados incluídos com sucesso !");
                alerta.showAndWait();
                
                limparCampos();
                
                txt_cep.requestFocus();
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
        endereco = new Endereco();
        
        endereco.setCep(txt_cep.getText());
        endereco.setRua(txt_rua.getText());
        endereco.setBairro(txt_bairro.getText());
        endereco.setCidade(txt_cidade.getText());
        endereco.setUf(txt_uf.getText());
        
        try {
            if(dao.altera(endereco)) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Dados alterados com sucesso !");
                alerta.showAndWait(); 
                
                limparCampos();
                
                txt_cep.requestFocus();
                
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
        alerta.setContentText("Deseja realmente remover o endereço ?");

        Optional<ButtonType> resultado = alerta.showAndWait();
        
        if (resultado.get() == ButtonType.CANCEL){
            return; 
        }

        endereco = new Endereco();
        
        endereco.setCep(txt_cep.getText());
        endereco.setRua(txt_rua.getText());
        endereco.setBairro(txt_bairro.getText());
        endereco.setCidade(txt_cidade.getText());
        endereco.setUf(txt_uf.getText());
        
        try {
            if(dao.remove(endereco)) {
                alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Endereço removido com sucesso !");
                alerta.showAndWait(); 
                         
                limparCampos();
                
                txt_cep.requestFocus();
                
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

    @FXML
    private void btnMenu_Click(ActionEvent event) {
        Endereco.tela.close();
    }

    @FXML
    private void btnPesquisar_Click(ActionEvent event) {
        endereco = new Endereco();
        
        endereco.setCep(txt_cep.getText());
        
        try {
            endereco = dao.buscaID(endereco);
            
            if(endereco != null) { 
                //move os dados para a tela
                txt_rua.setText(endereco.getRua());
                txt_bairro.setText(endereco.getBairro());
                txt_cidade.setText(endereco.getCidade());
                txt_uf.setText(endereco.getUf());
                
                habilitaAlteracaoRemocao();
            }
            else {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Endereço não encontrado !");
                alerta.showAndWait(); 
                
                txt_cep.requestFocus();
            }
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensagem");
            alerta.setHeaderText("Erro .");
            alerta.setContentText(ex.getMessage());
            alerta.showAndWait(); 
            
            txt_cep.requestFocus();
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
        txt_cep.setText("");
        txt_rua.setText("");
        txt_bairro.setText("");
        txt_cidade.setText("");
        txt_uf.setText("");
    }
    
}
