import Models.Factura;
import Services.IDAO;
import Services.ImpIDAO;

import java.time.LocalDate;
import java.util.List;


public class Main {
    private static final IDAO dao = new ImpIDAO();


    public static void main(String[] args) {

        Factura f= new Factura();
        f.setFechaEmision(LocalDate.now());
        f.setNombreCliente("Juan Perez");
        f.setTotal(1500.75);
        dao.insert(f);
        List<Factura> lista = dao.getAll("Factura.findAll", Factura.class);
        lista.forEach(System.out::println);
    }
}
