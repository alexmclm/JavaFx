
package interfazuserpass;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class openClose {
    
    direcciones direccion = new direcciones();
    
    public void abrirVentana(String nombre, String direction) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(direction));
        AnchorPane vent = (AnchorPane) loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(vent);
        stage.setTitle(nombre);
        stage.setScene(scene);
        stage.show();
    }
    public void cerrarVentana(Button a){
        Stage stage = (Stage) a.getScene().getWindow();
        stage.close();
        }
}
