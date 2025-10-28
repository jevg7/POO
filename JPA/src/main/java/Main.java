import model.UsuarioAdministrativo;
import services.IDAO;
import services.ImpIDAO;

import java.time.LocalDate;
import java.util.List;

public class Main {

    private static final IDAO dao = new ImpIDAO();

    public static void main(String[] args) {

        UsuarioAdministrativo u= new UsuarioAdministrativo();
        u.setNombre("Juan");
        u.setApellido("Perez");
        u.setActivo(false);
        dao.insert(u);
        List<UsuarioAdministrativo> lista = dao.getAll("UsuarioAdministrativo.findAll", UsuarioAdministrativo.class);
        lista.forEach(System.out::println);
    }
}
