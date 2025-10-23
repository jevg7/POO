package Models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="factura")
@NamedQueries({
        @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
})
public class Factura {
    @Id
    @SequenceGenerator (name = "seqFactura", sequenceName = "seq_factura", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFactura")
    private Integer id;

    @Column(name="fecha_emision", nullable = false)
    private  LocalDate fechaEmision;

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




