package br.com.fatec.controllers;

import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.DAO.PedidoDAO;
import br.com.fatec.DAO.ProdutoDAO;
import br.com.fatec.model.Cliente;
import br.com.fatec.model.Pedido;
import br.com.fatec.model.Produto;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.stage.Stage;

public class ViewPedidoController implements Initializable {

    @FXML
    private TextField txt_id;
    @FXML
    private TextField txt_cpf;
    @FXML
    private TextField txt_cliente;
    @FXML
    private TextField txt_qtde;
    @FXML
    private TextField txt_unit;
    @FXML
    private TextField txt_subtotal;
    @FXML
    private ComboBox<Produto> cmb_produto;
    @FXML
    private TextField txt_productid;
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
    
    private Pedido pedido;
    private PedidoDAO dao = new PedidoDAO(); 
  
    private Cliente cliente;
    private ClienteDAO daoC = new ClienteDAO();
    
    private ObservableList<Produto> produtos = 
            FXCollections.observableArrayList();  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        habilitaInclusao(); 
        
        txt_id.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, 
                    Boolean oldValue, Boolean newValue) {
                if(newValue) { 
                    limparCampos();
                    habilitaInclusao();
                }
             }
        });
        
        cmb_produto.setItems(produtos);
        preencheCombo();
        
        //programa a troca de valores da comboBox para mostrar
        //o codigo no textField
        cmb_produto.valueProperty().addListener((value, velho, novo) -> {
            txt_productid.setText(Integer.toString(novo.getId_Produto()));
            txt_unit.setText(Float.toString(novo.getPreco()));
        });
        
        txt_qtde.focusedProperty().addListener((value, velho, novo) -> {
            if (!novo) {
                try {
                    if(txt_qtde != null && txt_unit != null) {
                        int valueQtde = Integer.parseInt(txt_qtde.getText());
                        float valueUnit = Float.parseFloat(txt_unit.getText());
                
                        float valueTotal = valueQtde * valueUnit;
                
                        txt_subtotal.setText(Float.toString(valueTotal));
                    }
                } catch (NumberFormatException ex) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Mensagem");
                    alerta.setHeaderText("Campos de quantidade e/ou valor unitário sem parâmetros !");
                    alerta.setContentText(ex.getMessage());
                    alerta.showAndWait(); 
                }
            }
        });
        
        txt_cpf.focusedProperty().addListener((value, velho, novo) -> {
            if (!novo) {
                cliente = new Cliente();
        
                cliente.setCpf(txt_cpf.getText());
        
                try {
                    cliente = daoC.buscaID(cliente);
            
                    if(cliente != null) { 
                        //move os dados para a tela
                        txt_cpf.setText(cliente.getCpf());
                    }
                    else {
                        try {
                            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                            alerta.setTitle("Mensagem");
                            alerta.setHeaderText("Atenção");
                            alerta.setContentText("Cliente não encontrado !");
                            alerta.showAndWait(); 
                        
                            Cliente client = new Cliente();
                            client.start(new Stage());
                        
                            Pedido.tela.close();
                        } catch (IOException ex) {
                            
                        }
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

        txt_productid.setEditable(false);
        txt_unit.setEditable(false);
        txt_subtotal.setEditable(false);
    }
    
    private void preencheCombo() {
        ProdutoDAO daoP = new ProdutoDAO();
        
        ArrayList<Produto> lista;
        
        try {
            lista = (ArrayList<Produto>) daoP.lista("");
            produtos.addAll(lista);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @FXML
    private void btnIncluir_Click(ActionEvent event) {
        pedido = new Pedido();
        
        pedido.setId_Pedido(Integer.parseInt(txt_id.getText()));
        pedido.setQtd_Pedido(Integer.parseInt(txt_qtde.getText()));
        pedido.setValor_Total(Float.parseFloat(txt_subtotal.getText()));
        pedido.setNome_Cliente(txt_cliente.getText());
        pedido.setNome_Produto(cmb_produto.getValue().getDescricao());
        pedido.setCpf(txt_cpf.getText());
        pedido.setId_Produto(Integer.parseInt(txt_productid.getText()));
        
        try {
            if(dao.insere(pedido)) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Dados incluídos com sucesso !");
                alerta.showAndWait();
                
                limparCampos();
                
                txt_id.requestFocus();
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
    private void btnMenu_Click(ActionEvent event) {
        Pedido.tela.close();
    }

    @FXML
    private void btnAlterar_Click(ActionEvent event) {
        pedido = new Pedido();
        
        pedido.setId_Pedido(Integer.parseInt(txt_id.getText()));
        pedido.setQtd_Pedido(Integer.parseInt(txt_qtde.getText()));
        pedido.setValor_Total(Float.parseFloat(txt_subtotal.getText()));
        pedido.setNome_Cliente(txt_cliente.getText());
        pedido.setNome_Produto(cmb_produto.getValue().getDescricao());
        pedido.setCpf(txt_cpf.getText());
        pedido.setId_Produto(Integer.parseInt(txt_productid.getText()));
        
        try {
            if(dao.altera(pedido)) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Dados alterados com sucesso !");
                alerta.showAndWait(); 
                
                limparCampos();
                
                txt_id.requestFocus();
                
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
        alerta.setContentText("Deseja realmente remover o pedido ?");

        Optional<ButtonType> resultado = alerta.showAndWait();
        
        if (resultado.get() == ButtonType.CANCEL){
            return; 
        }

        pedido = new Pedido();
        
        pedido.setId_Pedido(Integer.parseInt(txt_id.getText()));
        pedido.setQtd_Pedido(Integer.parseInt(txt_qtde.getText()));
        pedido.setValor_Total(Float.parseFloat(txt_subtotal.getText()));
        pedido.setNome_Cliente(txt_cliente.getText());
        pedido.setNome_Produto(cmb_produto.getValue().getDescricao());
        pedido.setCpf(txt_cpf.getText());
        pedido.setId_Produto(Integer.parseInt(txt_productid.getText()));
        
        try {
            if(dao.remove(pedido)) {
                alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Pedido removido com sucesso !");
                alerta.showAndWait(); 
                         
                limparCampos();
                
                txt_id.requestFocus();
                
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
    private void btnPesquisar_Click(ActionEvent event) {
        pedido = new Pedido();
        
        pedido.setId_Pedido(Integer.parseInt(txt_id.getText()));
        
        try {
            pedido = dao.buscaID(pedido);
            
            if(pedido != null) { 
                //move os dados para a tela
                txt_qtde.setText(Integer.toString(pedido.getQtd_Pedido()));
                txt_subtotal.setText(Float.toString(pedido.getValor_Total()));
                txt_cliente.setText(pedido.getNome_Cliente());
                cmb_produto.setPromptText(pedido.getNome_Produto());
                txt_cpf.setText(pedido.getCpf());
                txt_productid.setText(Integer.toString(pedido.getId_Produto()));
                
                habilitaAlteracaoRemocao();
            }
            else {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Mensagem");
                alerta.setHeaderText("Atenção");
                alerta.setContentText("Pedido não encontrado !");
                alerta.showAndWait(); 
                
                txt_id.requestFocus();
            }
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensagem");
            alerta.setHeaderText("Erro .");
            alerta.setContentText(ex.getMessage());
            alerta.showAndWait(); 
            
            txt_id.requestFocus();
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
        txt_id.setText("");
        txt_qtde.setText("");
        txt_subtotal.setText("");
        txt_unit.setText("");
        txt_cliente.setText("");
        cmb_produto.setValue(null);
        txt_cpf.setText("");
        txt_productid.setText("");
    }
    
}
