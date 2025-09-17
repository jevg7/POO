package Clases;

public class Viaje {

    public String origen;
    public String destino;
    public double costo;
    Cliente cliente;
    DetalleVehiculo detalleVehiculo;

    public Viaje(String origen, String destino, double costo, Cliente cliente, DetalleVehiculo detalleVehiculo) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
        this.cliente = cliente;
        this.detalleVehiculo = detalleVehiculo;
    }

    public String getOrigen() {
        return origen;
    }
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void mostrarDetalles() {
        System.out.println("===== DETALLES DEL VIAJE =====");
        System.out.println("Cliente: " + cliente.getNombre() + " | Tel: " + cliente.getTelefono());
        System.out.println("Vehículo: " + detalleVehiculo.getModelo() + " (" + detalleVehiculo.getPlaca() + ")");
        System.out.println("Conductor: " + detalleVehiculo.getConductor().getNombre() +
                " | Licencia: " + detalleVehiculo.getConductor().getLicencia());
        System.out.println("Origen: " + origen);
        System.out.println("Destino: " + destino);
        System.out.println("Costo: $" + costo);
        System.out.println("=============================");
    }
}
