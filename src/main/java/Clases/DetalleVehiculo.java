package Clases;

public class DetalleVehiculo {
    public String placa;
    public String modelo;
    public int capacidad;
    public TipoVehiculo tipo;
    public Conductores conductor;
    public boolean disponible = true;

    public DetalleVehiculo(String placa, String modelo, int capacidad, TipoVehiculo tipo, Conductores conductor) {
        this.placa = placa;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.conductor = conductor;

    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public Conductores getConductor() {
        return conductor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

}
