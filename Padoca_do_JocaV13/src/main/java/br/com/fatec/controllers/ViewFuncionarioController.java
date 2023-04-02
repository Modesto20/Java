package br.com.fatec.controllers;

import br.com.fatec.model.Funcionario;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ViewFuncionarioController implements Initializable {

    @FXML
    private TextField txt_cpf;
    @FXML
    private TextField txt_nome;
    @FXML
    private TextField txt_admis;
    @FXML
    private TextField txt_cargo;
    @FXML
    private TextField txt_nasci;
    @FXML
    private Button btn_incluir;
    @FXML
    private Button btn_alterar;
    @FXML
    private Button btn_remover;
    @FXML
    private Button btn_menu;
    @FXML
    private Button btn_pesquisar;
    @FXML
    private ComboBox<Funcionario> cmb_funcionario;

    private ObservableList<Funcionario> funcionarios = 
            FXCollections.observableArrayList();    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        habilitaInclusao();
        
        //vincular a colecao Funcionarios dentro da comboBox
        cmb_funcionario.setItems(funcionarios);
        
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
    }    
    
    @FXML
    private void btnIncluir_Click(ActionEvent event) {
        Funcionario f = new Funcionario();
        f.setCpf(txt_cpf.getText());
        
        if(funcionarios.contains(f)) {
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Funcionário já cadastrado !", ButtonType.OK);
            alerta.showAndWait();
                        
            return;
        }
        
        try {
            //coloca os dados da tela na colecao
            funcionarios.add(moveTelaParaObjeto());
        
            Alert alerta = new Alert(Alert.AlertType.INFORMATION, "Funcionário cadastrado com sucesso !", ButtonType.OK);
            alerta.showAndWait();
        
            limparCampos();
        
            txt_cpf.requestFocus();
        } catch (Exception ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensagem");
            alerta.setHeaderText("Erro .");
            alerta.setContentText(ex.getMessage());
            alerta.showAndWait(); 
        }
    }

    @FXML
    private void btnAlterar_Click(ActionEvent event) {
        Funcionario f = new Funcionario();
        
        f.setCpf(txt_cpf.getText());
        f.setNome(txt_nome.getText());
        f.setData_Admissao(txt_admis.getText());
        f.setCargo(txt_cargo.getText());
        f.setData_Nascimento(txt_nasci.getText());
        
        f.hashCode();
        
        for(Funcionario a : funcionarios) {
            if(a.hashCode() == f.hashCode()) {
                a.setCpf(txt_cpf.getText());
                a.setNome(txt_nome.getText());
                a.setData_Admissao(txt_admis.getText());
                a.setCargo(txt_cargo.getText());
                a.setData_Nascimento(txt_nasci.getText());
                
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
        }
    }

    @FXML
    private void btnRemover_Click(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText("Atenção");
        alerta.setContentText("Deseja realmente remover o funcionário ?");
        
        Optional<ButtonType> resultado = alerta.showAndWait();
        
        if (resultado.get() == ButtonType.CANCEL){
            return; 
        }
        
        Funcionario f = new Funcionario();
        
        f.setCpf(txt_cpf.getText());
        f.setNome(txt_nome.getText());
        f.setData_Admissao(txt_admis.getText());
        f.setCargo(txt_cargo.getText());
        f.setData_Nascimento(txt_nasci.getText());
        
        f.hashCode();
        
        if(funcionarios.remove(f)) {
            alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Mensagem");
            alerta.setHeaderText("Atenção");
            alerta.setContentText("Funcionário removido com sucesso !");
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
    }

    @FXML
    private void btnMenu_Click(ActionEvent event) {
        Funcionario.tela.close();
    }

    @FXML
    private void btnPesquisar_Click(ActionEvent event) {
        //obtem o objeto que esta selecionado na comboBox
        Funcionario f = cmb_funcionario.getValue();
        
        //verifica se realmente e um objeto ou nao
        if(f == null) {
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Selecione algum funcionário na comboBox .", ButtonType.OK);
            alerta.showAndWait();
        }
        else {
            moveObjetoParaTela(f);
            
            habilitaAlteracaoRemocao();
        }
    }
    
    private void limparCampos(){
        txt_cpf.setText("");
        txt_nome.setText("");
        txt_admis.setText("");
        txt_cargo.setText("");
        txt_nasci.setText("");
    }
    
    private Funcionario moveTelaParaObjeto() {
        //instancia o Funcionario
        Funcionario f = new Funcionario();
        
        f.setCpf(txt_cpf.getText());
        f.setNome(txt_nome.getText());
        f.setData_Admissao(txt_admis.getText());
        f.setCargo(txt_cargo.getText());
        f.setData_Nascimento(txt_nasci.getText());
        
        return f;
    }
    
    private void moveObjetoParaTela(Funcionario f) {
        txt_cpf.setText(f.getCpf());
        txt_nome.setText(f.getNome());
        txt_admis.setText(f.getData_Admissao());
        txt_cargo.setText(f.getCargo());
        txt_nasci.setText(f.getData_Nascimento());
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
    
}
