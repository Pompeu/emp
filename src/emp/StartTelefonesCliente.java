/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author pompeu
 */
public class StartTelefonesCliente extends Application {

   /* public static StartTelefonesCliente INSTANCE = null;

    private StartTelefonesCliente() {
    }

    public static StartTelefonesCliente getInstace() {
        if (INSTANCE == null) {
            INSTANCE = new StartTelefonesCliente();
        }
        return INSTANCE;
    }*/

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/emp/view/FXMLClienteTelefone.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Telefones");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
