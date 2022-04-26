
package bancofacil.Logica;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
   
   
    private int numeroCuenta;
    private int saldo;
 
    public Cuenta(int numeroCuenta, int saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
       
    }
    
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getSaldo() {
        
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
  
   
}
  
   