/* aca creoare el interface del passUsers*/
package Fx;

import interfazuserpass.direcciones;
import interfazuserpass.openClose;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ALex
 */
public class PanelUserPassController implements Initializable {
    @FXML
    private PasswordField txtPass;
    @FXML
    private TextField txtUser;
    @FXML
    private Button btonIngresar;
    @FXML
    private Button btonLimpiar;
    @FXML
    private Button btonCuenta;

     openClose op = new openClose();
     direcciones direccion = new direcciones();
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ingresar(ActionEvent event) {
        if(txtUser.getText().equals("admin") && txtPass.getText().equals("admin")){
             Alert alert = new Alert(AlertType.CONFIRMATION);
             alert.setTitle(" Loggeo correcto");
             alert.setContentText("bienvenido " + txtUser.getText());
             alert.setHeaderText("-");
             alert.show();
       
        }
        else{
             Alert alert = new Alert(AlertType.ERROR);
             alert.setTitle("Error de Loggeo");
             alert.setContentText("Loggin incorrecto");
             alert.setHeaderText("Atencion");
             alert.show(); 
        }
    }

    @FXML
    private void limpiar(ActionEvent event) {
        txtPass.setText(null);
        txtUser.setText(null);
    }

    @FXML
    private void newAccount(ActionEvent event) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/formulario/panelNewCuenta.fxml"));
//        Scene scene = new Scene(root);
//        stage.setTitle("CuentaNueva");
//        stage.setScene(scene);
//        stage.show();

      op.abrirVentana("Ventana New account", direccion.getVentanaNewCuenta());
    }
    
}
