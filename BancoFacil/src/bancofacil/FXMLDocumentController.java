
package bancofacil;

import bancofacil.Logica.Banco;
import bancofacil.Logica.Cuenta;
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
import javax.swing.JOptionPane;

/**
 *
 * @author 31285
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button L_Retiro;
    @FXML
    private Button L_Depositar;
    @FXML
    private Button B_Saldo;
    @FXML
    private Button B_Salir;
    @FXML
    private TextField T_1;
    @FXML
    private TextField T_2;
    
    Banco ban = new Banco();
    String a;
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    

    @FXML
    private void Retiro(ActionEvent event) {
        try {
            int cuenta = Integer.parseInt(this.T_2.getText());
            int cantidad = Integer.parseInt(this.T_1.getText());
            
           if (ban.buscarCuenta(cuenta)) {
               
                int saldo=ban.realizarRetiro(cuenta, cantidad);
                   if(saldo==0){
                   
                    ban.transaccion(cantidad, cuenta, "Retiro", "Sin fondos");
                    a=ban.imprimirTransaccion(cuenta);
                    Alert alert = new Alert(Alert.AlertType. ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("--Fondos insuficientes--\n"+a);
                    alert.showAndWait();
                    
                   }else{
                       ban.transaccion(cantidad, cuenta, "Retiro", "Exitoso");
                       a=ban.imprimirTransaccion(cuenta);
                       //JOptionPane.showMessageDialog(null,"Saldo de la cuenta: "+saldo );
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Information");
                        alert.setContentText("--Retiro exitoso--\n"+a);
                        alert.showAndWait();
                        
                   }

            } else {
		Alert alert = new Alert(Alert.AlertType. ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El número de cuenta no coincide con ninguna cuenta registrada");
                alert.showAndWait();
            }
             
        } catch (NumberFormatException e) {
            
            Alert alert = new Alert(Alert.AlertType. ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
       
    }

    @FXML
    private void Depositar(ActionEvent event) {
        
         try {
            int cuenta = Integer.parseInt(this.T_2.getText());
            int cantidad = Integer.parseInt(this.T_1.getText());

           if (ban.buscarCuenta(cuenta)) {

                int saldo=ban.depositarDinero(cuenta, cantidad);
                ban.transaccion(cantidad, cuenta, "Deposito", "Exitoso");
                a=ban.imprimirTransaccion(cuenta);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Deposito");
                    alert.setContentText("--Deposito exitoso--\n"+a);
                    alert.showAndWait();

            } else {
		Alert alert = new Alert(Alert.AlertType. ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El número de cuenta no coincide con ninguna cuenta registrada");
                alert.showAndWait();
            }
             
        } catch (NumberFormatException e) {
            
            Alert alert = new Alert(Alert.AlertType. ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
       
    }

    @FXML
    private void Saldo(ActionEvent event) {    
        try {
            int cuenta = Integer.parseInt(this.T_2.getText());
            
             
            
            
           if (ban.buscarCuenta(cuenta)) {
               int saldo=ban.solicitarSaldo(cuenta);
                ban.transaccion(0, cuenta, "Deposito", "Exitoso");
                a=ban.imprimirTransaccion(cuenta);
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setHeaderText(null);
                 alert.setTitle("Information");
                 alert.setContentText("--Saldo de cuenta--"+a);
                 alert.showAndWait();

            } else {
		Alert alert = new Alert(Alert.AlertType. ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El número de cuenta no coincide con ninguna cuenta registrada");
                alert.showAndWait();
            }
             
        } catch (NumberFormatException e) {
            
            Alert alert = new Alert(Alert.AlertType. ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
        
    }

    @FXML
    private void Salir(ActionEvent event) {
        
    Node source = (Node) event.getSource();
    Stage stage = (Stage) source.getScene().getWindow();
    stage.close();
        
    }
    
}
