package br.upe.controllersJavaFX;

import java.io.IOException;

import br.upe.App;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Contabil {

    @FXML
    private ImageView btn_administrativo;

    @FXML
    private ImageView btn_almoxarifado;

    @FXML
    private Button btn_boletos;

    @FXML
    private Button btn_contas;

    @FXML
    private Button btn_multas;

    @FXML
    void switchToAdministrativo(MouseEvent event) throws IOException {
    	switchScreen("administrativo");
    }

    @FXML
    void switchToAlmoxarifado(MouseEvent event) throws IOException {
    	switchScreen("almoxarifado");
    }

    @FXML
    void switchToAlmoxarifado_produto(MouseEvent event) {

    }

    @FXML
    void switchToAlmoxarifado_requisicao(MouseEvent event) {

    }

    @FXML
    void switchToContabil(MouseEvent event) {

    }
    
    @FXML
    void logout(MouseEvent event) throws IOException {
    	if (Alerts.alertConfirmation("Desejar sair do sistema?", null)) {
    		switchScreen("login");
    	}
    }
    
    public void switchScreen(String screen) throws IOException {
		Stage stage;
        Parent root;
        Scene scene;
        
        stage = (Stage) btn_administrativo.getScene().getWindow();
        root = App.loadFXML(screen);
        if (screen.equals("login")) {
        	scene = new Scene(root, 700, 500);
        }else {
        	scene = new Scene(root, 1280, 720);
        }
        stage.setScene(scene);
        stage.show();
	}

}
