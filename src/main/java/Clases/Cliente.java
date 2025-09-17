package Clases;

public class Cliente {

    public String nombre;
    public String telefono;
    public String email;


    public Cliente(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public String getTelefono() {
        return telefono;

    }
}
