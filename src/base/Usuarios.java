
package base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;


public class Usuarios{
    private IntegerProperty codigo_usuarios;
    private IntegerProperty codUsuario;
    private IntegerProperty passUsuario;
    private StringProperty nombreUsuario;
    private StringProperty apellidoUsuario;
    private IntegerProperty edadUsuario;
    private StringProperty generoUsuario;
    private StringProperty emailUsuario;

         public Usuarios(Integer codigo_usuarios, Integer codUsuario, Integer passUsuario, 
                  String nombreUsuario, String apellidoUsuario, Integer edadUsuario, 
                  String generoUsuario, String emailUsuario) {
             this.codigo_usuarios = new SimpleIntegerProperty(codigo_usuarios);
             this.codUsuario = new SimpleIntegerProperty(codUsuario);
             this.passUsuario = new SimpleIntegerProperty(passUsuario);
             this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
             this.apellidoUsuario = new SimpleStringProperty (apellidoUsuario);
             this.edadUsuario = new SimpleIntegerProperty(edadUsuario);
             this.generoUsuario = new SimpleStringProperty(generoUsuario);
             this.emailUsuario = new SimpleStringProperty(emailUsuario);
     }

 
    //get
    public int getCodigoUsuario(){
        return codigo_usuarios.get();
    }     
    public int getCodUsuario() {
        return codUsuario.get();
    }

    public int getPassUsuario() {
        return passUsuario.get();
    }

    public String getNombreUsuario() {
        return nombreUsuario.get();
    }

    public String getApellidoUsuario() {
        return apellidoUsuario.get();
    }

    public int getEdadUsuario() {
        return edadUsuario.get();
    }

    public String getGeneroUsuario() {
        return generoUsuario.get();
    }

    public String getEmailUsuario() {
        return emailUsuario.get();
    }
    //get losProperty
    public IntegerProperty CodigoUsuarios(){
        return codigo_usuarios;
    }
    public IntegerProperty CodUsuarioProperty(){
        return codUsuario;
    }
    public IntegerProperty PassUsuarioProperty(){
        return passUsuario;
    }
    public StringProperty NombreUsuarioProperty(){
        return nombreUsuario;
    }
    public StringProperty ApellidoUsuarioProperty(){
        return apellidoUsuario;
    }
    public IntegerProperty EdadUsuarioProperty(){
        return edadUsuario;
    }
    public StringProperty GeneroUsuarioProperty(){
        return generoUsuario;
    }
    public StringProperty EmailUsuarioProperty(){
        return emailUsuario;
     }

    // sets
    public void setCodigoUsuarios(int codigo_usuarios){
        this.codigo_usuarios = new SimpleIntegerProperty(codigo_usuarios);
    }
    public void setCodUsuario(int codUsuario) {
        this.codUsuario = new SimpleIntegerProperty(codUsuario);
    }

    public void setPassUsuario(int passUsuario) {
        this.passUsuario = new SimpleIntegerProperty(passUsuario);
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = new SimpleStringProperty(apellidoUsuario);
    }

    public void setEdadUsuario(int edadUsuario) {
        this.edadUsuario = new SimpleIntegerProperty(edadUsuario);
    }

    public void setGeneroUsuario(String generoUsuario) {
        this.generoUsuario = new SimpleStringProperty(generoUsuario);
    }

    public void setEmailProperty(String emailUsuario) {
        this.emailUsuario = new SimpleStringProperty(emailUsuario);
    }

    public static void llenarInfoUsuario(Connection connection,ObservableList<Usuarios> lista){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(
                    "SELECT codigo_users, "
                            + "codUsers, "
                            + "passUsers, "
                            + "nombre, "
                            + "apellido, "
                            + "edad, "
                            + "genero, "
                            + "email "
                            + "FROM usuarios");
 // arreglar tipos de usuarios!! y coincidirlo con los tipos de la base de datos            
            while(resultado.next()){
                lista.add( new Usuarios (
                                resultado.getInt("codigo_users"),
                                resultado.getInt("codUsers"),
                                resultado.getInt("passUsers"),
                                resultado.getString("nombre"),
                                resultado.getString("apellido"),
                                resultado.getInt("edad"),
                                resultado.getString("genero"),
                                resultado.getString("email")
                     )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }
    
    public int guardarRegistro(Connection conexion){
        try {
            PreparedStatement instruccion = conexion.prepareStatement(
                    "INSERT INTO usuarios (codUsers, passUsers, nombre, apellido, edad, genero, email) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            instruccion.setInt(1, codUsuario.get());
            instruccion.setInt(2, passUsuario.get());
            instruccion.setString(3, nombreUsuario.get());
            instruccion.setString(4, apellidoUsuario.get());
            instruccion.setInt(5, edadUsuario.get());
            instruccion.setString(6, generoUsuario.get());
            instruccion.setString(7, emailUsuario.get());
            return instruccion.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    /*
    public void limparRegistro(Connection conexion){
        PreparedStatement instruccion = conexion.prepareStatement(
                "DELETE FROM db_usuarios WHERE codigo_users = ? "
        );
        instruccion.
    }
    */
}
