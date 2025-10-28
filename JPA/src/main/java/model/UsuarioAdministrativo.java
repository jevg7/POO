package model;

import jakarta.persistence.*;

import javax.management.relation.Role;
import java.util.Set;

@Entity
@Table(name = "usuario_administrativo")
@NamedQueries({
        @NamedQuery(name = "UsuarioAdministrativo.findAll", query = "SELECT u FROM UsuarioAdministrativo u")
})
public class UsuarioAdministrativo {

    @Id

    @SequenceGenerator(name = "seqUsuarioAdmin", sequenceName = "seq_usuario_admin", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUsuarioAdmin")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;


    @Column(name = "activo", nullable = false)
    private Boolean activo = true;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuario_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")

    )
    private Set<Rol> roles;

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        // Lógica de comprobación: si estaba activo y se está cambiando a inactivo
        if (this.activo != null && this.activo && !activo) {
            System.out.println("**Alerta:** El usuario con ID " + this.id + " (" + this.nombre + " " + this.apellido + ") ha sido DESACTIVADO.");
        }
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "UsuarioAdministrativo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", activo=" + activo +
                '}';
    }

    public void setRoles(Rol r) {

    }
}