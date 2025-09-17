package Clases;

public class Empresa {
    String nombre;
    Conductores conductor;
    DetalleVehiculo vehiculo;
    Cliente cliente;
    Viaje viaje;

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public void registrarConductor(Conductores c) {
        this.conductor = c;
    }

    public void registrarVehiculo(DetalleVehiculo v) {
        this.vehiculo = v;
    }

    public void registrarCliente(Cliente c) {
        this.cliente = c;
    }

    public void asignarViaje(String origen, String destino, double costo) {
        if (vehiculo == null || cliente == null) {
            System.out.println("Debe registrar un vehículo y un cliente antes de asignar un viaje.");
            return;
        }

        if (!vehiculo.disponible) {
            System.out.println("El vehículo no está disponible.");
            return;
        }

        vehiculo.disponible = false;
        viaje = new Viaje(origen, destino, costo, cliente, vehiculo);
        System.out.println("Viaje asignado correctamente.");
    }

    public void mostrarViaje() {
        if (viaje != null) {
            System.out.println(viaje);
        } else {
            System.out.println("No se ha registrado ningún viaje.");
        }
    }

    public void finalizarViaje() {
        if (viaje != null) {
            vehiculo.disponible = true;
            System.out.println("El viaje ha finalizado y el vehículo está disponible nuevamente.");
            viaje = null;
        } else {
            System.out.println("No hay viaje en curso para finalizar.");
        }
    }
}
