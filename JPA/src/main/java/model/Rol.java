package model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="Rol")
@NamedQueries({
        @NamedQuery(name ="Rol.all",query="select r from Rol r")
})

public class Rol {

    @Id
    @SequenceGenerator(name= "rolSeq"
            ,sequenceName = "rolSeq"
            ,allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "rolSeq")
    private Integer id;
    @Column(length=50,nullable = false)
    private String nombre;
    @Column(length=50,nullable = false)
    private String descripcion;


    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private Set<UsuarioAdministrativo> usuarios;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<UsuarioAdministrativo> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<UsuarioAdministrativo> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", usuarios=" + usuarios +
                '}';
    }
}
