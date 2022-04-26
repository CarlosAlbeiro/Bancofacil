
package bancofacil.Logica;

public class Cliente {
   
    private String nombres;
    private String Apellidos;
    private long cedula;
    private String direccion;
    private String email;

    public Cliente(String nombres, String Apellidos, long cedula, String direccion, String email) {
        this.nombres = nombres;
        this.Apellidos = Apellidos;
        this.cedula = cedula;
        this.direccion = direccion;
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombres=" + nombres + ", Apellidos=" + Apellidos + ", cedula=" + cedula + ", direccion=" + direccion + ", email=" + email + '}';
    }
     
}
