
package bancofacil.Logica;

import java.util.ArrayList;

public class Banco {
    public  ArrayList<Transaccion> listaTransacciones;
    public ArrayList<Cliente> listaClientes;
    public ArrayList<Cuenta> listaCuentas;
    public Banco(){
        listaClientes= new ArrayList();
        listaCuentas= new ArrayList();
        listaTransacciones= new ArrayList();
        
        listaCuentas.add(new Cuenta(1,4500));
        listaCuentas.add(new Cuenta(2,0));
        listaCuentas.add(new Cuenta(3,0));
        
        
    }
    public boolean agregarClientes(String nombre, String apellido, long cedula, String dirreccion, String email){
        listaClientes.add(new Cliente(nombre,apellido,cedula,dirreccion,email));  
        return true;
    }
    public String ultimoCliente(){
            String c;
            int cantidad=listaClientes.size()-1;
            c="\nNombre: "+listaClientes.get(cantidad).getNombres()+"\nApellido: "+listaClientes.get(cantidad).getApellidos()
                +"\nCedula: "+listaClientes.get(cantidad).getCedula()+"\nDirreccion: "+listaClientes.get(cantidad).getDireccion()
                 +"\nCorreo: "+listaClientes.get(cantidad).getEmail();
        return c;
    }
    public boolean buscarCuenta(int numeroCuenta){
       boolean existe = false;
       for (int i = 0; i < listaCuentas.size(); i++) {
           if (listaCuentas.get(i).getNumeroCuenta()==numeroCuenta){
               existe=true;
               
           }
       }
       return existe;
   }
    public int realizarRetiro(int cuenta,int valor){
         int saldoFinal=0;
         
         for (int i = 0; i < listaCuentas.size(); i++) {
              if(listaCuentas.get(i).getNumeroCuenta()==cuenta){
                  if(listaCuentas.get(i).getSaldo()<valor){
                      saldoFinal=0;
                  }else{
                    int saldo=(listaCuentas.get(i).getSaldo()-valor);
                    listaCuentas.get(i).setSaldo(saldo);
                    saldoFinal=listaCuentas.get(i).getSaldo();
                  }
              }
                  
         }
     return saldoFinal; 
    }  
    public int depositarDinero(int cuenta,int valor){
        int saldoFinal=0;
         
         for (int i = 0; i < listaCuentas.size(); i++) {
              if(listaCuentas.get(i).getNumeroCuenta()==cuenta){
                    listaCuentas.get(i).setSaldo(listaCuentas.get(i).getSaldo()+valor);
                    saldoFinal=listaCuentas.get(i).getSaldo();
              }
                  
         }
     return saldoFinal; 
    }
    public int solicitarSaldo(int cuenta){
        int saldo=0;
         for (int i = 0; i < listaCuentas.size(); i++) {
              if(listaCuentas.get(i).getNumeroCuenta()==cuenta){
                    saldo=listaCuentas.get(i).getSaldo();
                  
              }
                  
         }
     return saldo;
    }
    public void transaccion(int cantidad,int cuenta,String tipo,String estado){
      listaTransacciones.add(new Transaccion(cantidad, cuenta, tipo, estado));
    }
    public String imprimirTransaccion(int cuenta){
        String a="";
        for (int i = 0; i < listaCuentas.size(); i++) {
           if (listaCuentas.get(i).getNumeroCuenta()==cuenta){
                int cantida=listaTransacciones.size()-1;
                a="\nValor solicitado: "+listaTransacciones.get(cantida).getValor()+"\nSaldo actual: "+listaCuentas.get(i).getSaldo()+"\nCuenta: "+listaTransacciones.get(cantida).getNumeroCuenta()
                +"\nHora: "+listaTransacciones.get(cantida).getHora()+"\nFecha: "+listaTransacciones.get(cantida).getFecha()
                +"\nTipo: "+listaTransacciones.get(cantida).getTipo()+"\nEstado: "+listaTransacciones.get(cantida).getEstado();
           }
       }
      
      return a;
    }
}
