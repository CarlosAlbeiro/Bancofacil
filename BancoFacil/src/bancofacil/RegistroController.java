/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bancofacil;

import bancofacil.Logica.Banco;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 31285
 */
public class RegistroController implements Initializable {
    @FXML
    private TextField T_Nom;
    @FXML
    private TextField T_Ape;
    @FXML
    private TextField T_Ced;
    @FXML
    private TextField T_Dir;
    @FXML
    private TextField T_Ema;
    @FXML
    private Button B_Guardar;
    @FXML
    private Button B_Salir;
    Banco ban = new Banco();

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Guardar(ActionEvent event) {
        
        String nombre = this.T_Nom.getText();
        String apellido = this.T_Ape.getText();
        long cedula = Long.parseLong( this.T_Ced.getText());
        String direccion = this.T_Dir.getText();
        String email = this.T_Ema.getText();
        
        if(T_Nom.getText().isEmpty() || T_Ape.getText().isEmpty()||
                T_Ced.getText().isEmpty()|| T_Dir.getText().isEmpty()|| T_Ema.getText().isEmpty()){
            
             // la alerta de guardado
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Por favor diligencie todo los campos");
            alert.showAndWait();
          
        }else{
            String c;
            ban.agregarClientes(nombre, apellido, cedula, direccion, email);
            
            if(  ban.agregarClientes(nombre, apellido, cedula, direccion, email)){
                c=ban.ultimoCliente(); 
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("INFORMACION");
                alert.setContentText("Se ha añadido correctamente\nUltimo cliente: "+c);
                alert.showAndWait();
            
        
        }
        // la alerta de guardado
            
           
          
            // cerrar
            Stage stage = (Stage) this.B_Guardar.getScene().getWindow();
            stage.close();
            
         }  
            
        }
        
       
    

    @FXML
    private void Salir(ActionEvent event) {
        
         Node source = (Node) event.getSource();
         Stage stage = (Stage) source.getScene().getWindow();
         stage.close(); 
    }
    
}
