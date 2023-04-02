package br.com.fatec.model;

import br.com.fatec.App;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Consulta extends Application {
    public static Stage tela;
    
    @Override
    public void start(Stage tela) throws IOException {
        setStage(tela);
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ViewConsultaPedido.fxml"));
        Parent root = fxmlLoader.load();
        
        Scene scene = new Scene(root);
        
        tela.setScene(scene);
        tela.show();        
    }
    
    public static void setStage(Stage t) {
        tela = t;
    }
}
