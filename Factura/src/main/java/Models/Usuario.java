package Models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="usuario")
@NamedQueries({
        @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
})
public class Usuario {
    @Id
    @SequenceGenerator (name = "seqUsuario", sequenceName = "seq_Usuario", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUsuario")
    private Integer id;

    @Column(name="nombre", nullable = false)
    private  String nombre;

    @Column(name="nombre_cliente", nullable = false, length=100)
    private String nombreCliente;

    @Column(name="total", nullable = false)
    private Double total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", fechaEmision=" + fechaEmision +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", total=" + total +
                '}';
    }
}




