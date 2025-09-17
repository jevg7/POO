import Clases.*;

public class Main {
    public static void main(String[] args) {

        Empresa empresa = new Empresa("Transporte Rápido");

        // Registrar conductor, vehículo y cliente
        Conductores c1 = new Conductores("Jairo Vega", "001-010906-1011U", 5);
        empresa.registrarConductor(c1);

        DetalleVehiculo v1 = new DetalleVehiculo("M268468", "Mazda 2", 4, TipoVehiculo.AUTO, c1);
        empresa.registrarVehiculo(v1);

        Cliente cliente1 = new Cliente("Leana Cruz", "8888-9999", "tuperro@mail.com");
        empresa.registrarCliente(cliente1);

        Viaje viaje1 = new Viaje("Managua", "Granada", 500.0, cliente1, v1);


        viaje1.mostrarDetalles();

    }
}
