package Modelo;

// Cliente.java
public class Cliente {
    private String nombre;
    private String direccion;
    private String documentoIdentidad;
    private Cuenta cuenta;
    
    public Cliente(String nombre, String direccion, String documentoIdentidad, Cuenta cuenta) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.documentoIdentidad = documentoIdentidad;
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}

