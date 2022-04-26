/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bancofacil;

import bancofacil.Logica.Banco;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 31285
 */
public class BienvenidaController implements Initializable {

    @FXML
    private AnchorPane B_;
    @FXML
    private Button B_Consultar;
    @FXML
    private Button B_Salir;
    @FXML
    private RadioButton R_registro;
    @FXML
    private RadioButton R_transa;
    Banco ban = new Banco();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ToggleGroup tg = new ToggleGroup ();
        this.R_registro.setToggleGroup(tg);
        this.R_transa.setToggleGroup(tg);
    }    

    @FXML
    private void B_Consulta(ActionEvent event) {
        
        if (this.R_registro.isSelected()){
        
             // Abrir unn nueva ventana
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Registro.fxml"));
                
                Parent root = loader.load();
                //Controlador de la vista
                RegistroController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage ();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();
            } catch (IOException ex) {
                Logger.getLogger(BienvenidaController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        }
        else if(this.R_transa.isSelected()){
        
            // Abrir unn nueva ventana
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
                
                Parent root = loader.load();
                FXMLDocumentController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage ();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();
            } catch (IOException ex) {
                Logger.getLogger(BienvenidaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void Salir(ActionEvent event) {
        
         Node source = (Node) event.getSource();
         Stage stage = (Stage) source.getScene().getWindow();
         stage.close();
    }
    
}
