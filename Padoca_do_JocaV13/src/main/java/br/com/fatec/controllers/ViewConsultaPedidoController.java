package br.com.fatec.controllers;

import br.com.fatec.DAO.PedidoDAO;
import br.com.fatec.model.Pedido;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewConsultaPedidoController implements Initializable {

    @FXML
    private TableView<Pedido> tb_pedido;
    @FXML
    private TableColumn<Pedido, Integer> col_id;
    @FXML
    private TableColumn<Pedido, Integer> col_qtde;
    @FXML
    private TableColumn<Pedido, Float> col_subtotal;
    @FXML
    private TableColumn<Pedido, String> col_cliente;
    @FXML
    private TableColumn<Pedido, String> col_produto;
    @FXML
    private TableColumn<Pedido, String> col_cpf;
    @FXML
    private TableColumn<Pedido, Integer> col_productid;
    @FXML
    private TableColumn<Pedido, Boolean> col_selecionado;
    @FXML
    private Button btn_filtro;
    @FXML
    private RadioButton radio_france;
    @FXML
    private RadioButton radio_brigadeiro;
    @FXML
    private RadioButton radio_bolo; 
    @FXML
    private RadioButton radio_torta;
    @FXML
    private RadioButton radio_pudim;
    @FXML
    private RadioButton radio_italiano;
    @FXML
    private RadioButton radio_baguete;
    @FXML
    private RadioButton radio_queijo;
    @FXML
    private Group group_box;
    @FXML
    private ToggleGroup product;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        col_id.setCellValueFactory(
                new PropertyValueFactory<>("id_Pedido"));
        col_qtde.setCellValueFactory(
                new PropertyValueFactory<>("qtd_Pedido"));
        col_subtotal.setCellValueFactory(
                new PropertyValueFactory<>("valor_Total"));
        col_cliente.setCellValueFactory(
                new PropertyValueFactory<>("nome_Cliente"));
        col_produto.setCellValueFactory(
                new PropertyValueFactory<>("nome_Produto"));
        col_cpf.setCellValueFactory(
                new PropertyValueFactory<>("cpf"));
        col_productid.setCellValueFactory(
                new PropertyValueFactory<>("id_Produto"));
        col_selecionado.setCellValueFactory(
                new PropertyValueFactory<>("selecionado"));
        
        //coloca o checkBox na coluna
        col_selecionado.setCellFactory(
                CheckBoxTableCell.forTableColumn(col_selecionado));

        //preenche a tabela
        tb_pedido.setItems(preencheTabela());
    }    
    
    private ObservableList<Pedido> preencheTabela() {
        PedidoDAO dao = new PedidoDAO();
        
        ObservableList<Pedido> pedidos =
            FXCollections.observableArrayList();
        
        try {
            pedidos.addAll(dao.lista(""));
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR,
                "Erro Preenche Tabela: " + ex.getMessage(), ButtonType.OK);
            alerta.showAndWait();
        }
        
        return pedidos;
    }

    @FXML
    private void btnFiltro_Click(ActionEvent event) {
        PedidoDAO dao = new PedidoDAO();
        
        ObservableList<Pedido> pedidos =
            FXCollections.observableArrayList();
        
        if(radio_france.isSelected()) {
            try {
                pedidos.addAll(dao.lista("nome_Produto like '%Pão Francês'"));
                
                tb_pedido.setItems(pedidos);
            } catch (SQLException ex) {
                Alert alerta = new Alert(Alert.AlertType.ERROR,
                    "Erro Preenche Tabela: " + ex.getMessage(), ButtonType.OK);
                alerta.showAndWait();
            }
        }
        
        if(radio_brigadeiro.isSelected()) {
            try {
                pedidos.addAll(dao.lista("nome_Produto like '%Brigadeiro'"));
                
                tb_pedido.setItems(pedidos);
            } catch (SQLException ex) {
                Alert alerta = new Alert(Alert.AlertType.ERROR,
                    "Erro Preenche Tabela: " + ex.getMessage(), ButtonType.OK);
                alerta.showAndWait();
            }
        }
        
        if(radio_bolo.isSelected()) {
            try {
                pedidos.addAll(dao.lista("nome_Produto like '%Bolo'"));
                
                tb_pedido.setItems(pedidos);
            } catch (SQLException ex) {
                Alert alerta = new Alert(Alert.AlertType.ERROR,
                    "Erro Preenche Tabela: " + ex.getMessage(), ButtonType.OK);
                alerta.showAndWait();
            }
        }
        
        if(radio_torta.isSelected()) {
            try {
                pedidos.addAll(dao.lista("nome_Produto like '%Torta'"));
                
                tb_pedido.setItems(pedidos);
            } catch (SQLException ex) {
                Alert alerta = new Alert(Alert.AlertType.ERROR,
                    "Erro Preenche Tabela: " + ex.getMessage(), ButtonType.OK);
                alerta.showAndWait();
            }
        }
        
        if(radio_pudim.isSelected()) {
            try {
                pedidos.addAll(dao.lista("nome_Produto like '%Pudim'"));
                
                tb_pedido.setItems(pedidos);
            } catch (SQLException ex) {
                Alert alerta = new Alert(Alert.AlertType.ERROR,
                    "Erro Preenche Tabela: " + ex.getMessage(), ButtonType.OK);
                alerta.showAndWait();
            }
        }
        
        if(radio_italiano.isSelected()) {
            try {
                pedidos.addAll(dao.lista("nome_Produto like '%Pão Italiano'"));
                
                tb_pedido.setItems(pedidos);
            } catch (SQLException ex) {
                Alert alerta = new Alert(Alert.AlertType.ERROR,
                    "Erro Preenche Tabela: " + ex.getMessage(), ButtonType.OK);
                alerta.showAndWait();
            }
        }
        
        if(radio_baguete.isSelected()) {
            try {
                pedidos.addAll(dao.lista("nome_Produto like '%Baguete'"));
                
                tb_pedido.setItems(pedidos);
            } catch (SQLException ex) {
                Alert alerta = new Alert(Alert.AlertType.ERROR,
                    "Erro Preenche Tabela: " + ex.getMessage(), ButtonType.OK);
                alerta.showAndWait();
            }
        }
        
        if(radio_queijo.isSelected()) {
            try {
                pedidos.addAll(dao.lista("nome_Produto like '%Pão de Queijo'"));
                
                tb_pedido.setItems(pedidos);
            } catch (SQLException ex) {
                Alert alerta = new Alert(Alert.AlertType.ERROR,
                    "Erro Preenche Tabela: " + ex.getMessage(), ButtonType.OK);
                alerta.showAndWait();
            }
        }
    }
    
}
