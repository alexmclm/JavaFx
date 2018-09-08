
package Fx;

import adminConexion.admiConexion;
import base.Usuarios;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import interfazuserpass.openClose;
import interfazuserpass.direcciones;
/**
 * FXML Controller class
 *
 * @author ALex
 */
public class PanelNewCuentaController implements Initializable {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtCodUser;
    @FXML
    private TextField txtPassUser;
    @FXML
    private RadioButton btonFemenino;
    @FXML
    private RadioButton btonMasculino;
    @FXML
    private Button btonCrear;
    @FXML
    private Button btonEliminar;
    @FXML
    private Button btonVolver;

    private ObservableList <Usuarios> listaUsers;
    
    private admiConexion conexion;
    
   
    direcciones direccion = new direcciones();
    openClose op = new openClose();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //btonCrear.setDisable(true);
        conexion = new admiConexion();
        conexion.establecerConexion();
        listaUsers = FXCollections.observableArrayList();
        Usuarios.llenarInfoUsuario(conexion.getConnection(),listaUsers);
        
        conexion.cerrarConexion();
    }
    /*
    public void gestionarLosEventos(){
    
    }
    */
    @FXML
    private void crearCuenta(ActionEvent event) {
        Usuarios usuario = new Usuarios(0,
            Integer.valueOf(txtCodUser.getText()),
            Integer.valueOf(txtPassUser.getText()),    
            txtNombre.getText(),
            txtApellido.getText(),
            Integer.valueOf(txtEdad.getText()),
            btonFemenino.isSelected()?  "F" : "M",
            txtEmail.getText()
        );
        conexion.establecerConexion();
        int resultado = usuario.guardarRegistro(conexion.getConnection());
        conexion.cerrarConexion();
        if (resultado ==1){
            listaUsers.add(usuario);
            Alert message = new Alert(AlertType.INFORMATION);
             message.setTitle("Registro guardado");
             message.setContentText("el registro ha sido guardado");
             message.setHeaderText("resulñtado");
             message.show();           
        }
    }

    @FXML
    private void limpiarCuenta(ActionEvent event) {
        txtNombre.setText(null);
        txtApellido.setText(null);
        txtEdad.setText(null);
        txtEmail.setText(null);
        txtPassUser.setText(null);
        txtCodUser.setText(null);
        btonFemenino.setSelected(false);
        btonMasculino.setSelected(false);
        btonCrear.setDisable(true);
        
    }
    @FXML
    void volver(ActionEvent event) {
        op.cerrarVentana(btonVolver);
    }
}
