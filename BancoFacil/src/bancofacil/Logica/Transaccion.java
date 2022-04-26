package bancofacil.Logica;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author 31285
 */
public class Transaccion {
    
    private int valor;
    private int numeroCuenta;
    private LocalTime hora;
    private LocalDate fecha;
    private String tipo;
    private String estado;

    public Transaccion(int valor, int numeroCuenta,String tipo, String estado) {
        this.valor = valor;
        this.numeroCuenta = numeroCuenta;
        hora = LocalTime.now();
        fecha = LocalDate.now();
        this.tipo = tipo;
        this.estado = estado;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
    
}