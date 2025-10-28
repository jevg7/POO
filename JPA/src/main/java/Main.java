import model.Rol;
import model.UsuarioAdministrativo;
import services.IDAO;
import services.ImpIDAO;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    private static final IDAO dao = new ImpIDAO();

    public static void main(String[] args) {

            Rol r = new Rol();
            r.setNombre("Administrador");
            r.setDescripcion("Rol con todos los permisos");

            Rol r2 = new Rol();
            r2.setNombre("Lector");
            r2.setDescripcion("Rol con permisos de solo lectura");

            UsuarioAdministrativo u = new UsuarioAdministrativo();
            u.setNombre("Jairo");
            u.setApellido("Vega");
            u.setActivo(false);

            UsuarioAdministrativo u2 = new UsuarioAdministrativo();
            u2.setNombre("Leana");
            u2.setApellido("Cruz");

            // --- Inicio de la Lógica Corregida ---

            // 1. Asignar roles a Jairo
            Set<Rol> setDeRolesJairo = new HashSet<>();
            setDeRolesJairo.add(r);
            u.setRoles(setDeRolesJairo);

            // 2. Asignar roles a Leana
            Set <Rol> setDeRolesLeana = new HashSet<>();
            setDeRolesLeana.add(r2);
            u2.setRoles(setDeRolesLeana);

            // 3. Asignar usuarios a Rol Admin (Solo Jairo)
            Set<UsuarioAdministrativo> setDeUsuariosAdmin = new HashSet<>();
            setDeUsuariosAdmin.add(u);
            r.setUsuarios(setDeUsuariosAdmin);

            // 4. Asignar usuarios a Rol Lector (Solo Leana)
            Set<UsuarioAdministrativo> setDeUsuariosLector = new HashSet<>();
            setDeUsuariosLector.add(u2);
            r2.setUsuarios(setDeUsuariosLector);

            // --- Fin de la Lógica Corregida ---

            // 5. Persistir (Esto ahora es consistente)
            // Al guardar r, JPA guardará 'u' gracias a la cascada.
            dao.insert(r);

            // Al guardar r2, JPA guardará 'u2' gracias a la cascada.
            dao.insert(r2);

            List<Rol> lista = dao.getAll("Rol.all", Rol.class);
            System.out.println("--- Roles en la BD ---");
            lista.forEach(System.out::println);
    }
}
