/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazuserpass;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ALex
 */
public class InterfazUserPass extends Application{
//    @Override
//   public void start(Stage stage) throws IOException{
//       Parent root = FXMLLoader.load(getClass().getResource("/Fx/PanelUserPass.fxml"));
//       Scene scene = new Scene(root);
//       stage.setTitle("Input Server");
//       stage.setScene(scene);
//       stage.show();
//   }
//    public static void main(String[] args){
//        launch(args);
//    }
    direcciones direccion = new direcciones();
    openClose op = new openClose();
    public void start(Stage stage) throws IOException{
        op.abrirVentana("ventana Loggin",direccion.getVentanaLoggin());
    }
    public static void main(String [] args){
    launch (args);
    }
}
