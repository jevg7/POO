package org.example;

import Model.PublicacionPostgres;
import Model.PublicacionPostgres;
import service.IDAO;
import service.ImplDAO;

import java.time.LocalDate;
import java.util.List;

public class Main {

    private static final IDAO dao = new ImplDAO();

    public static void publicacionCrudPostgres() {
        System.out.println("--- CRUD para Publicacion con PostgreSQL (ID con Secuencia) ---");

        // 1. CREATE
        System.out.println("\n1. Creando nueva publicacion...");
        PublicacionPostgres nuevaPublicacion = new PublicacionPostgres();
        nuevaPublicacion.setNombrePublicacion("Avances en IA");
        nuevaPublicacion.setDescripcionPublicacion("Un resumen de los últimos avances en inteligencia artificial.");
        nuevaPublicacion.setFechaPublicacion(LocalDate.now());
        dao.insert(nuevaPublicacion);
        System.out.println("Publicacion creada.");

        // Para las pruebas, necesitamos recuperar el ID asignado por la secuencia.
        List<PublicacionPostgres> publicacionesAfterCreate = dao.getAll("PublicacionPostgres.findAll", PublicacionPostgres.class);
        Integer idCreado = publicacionesAfterCreate.isEmpty() ? null : publicacionesAfterCreate.get(publicacionesAfterCreate.size() - 1).getId();

        if (idCreado == null) {
            System.out.println("No se pudo obtener el ID de la publicación creada. Terminando prueba.");
            return;
        }
        System.out.println("ID de la nueva publicación: " + idCreado);

        // 2. READ (all)
        System.out.println("\n2. Leyendo todas las publicaciones...");
        List<PublicacionPostgres> publicaciones = dao.getAll("PublicacionPostgres.findAll", PublicacionPostgres.class);
        if (publicaciones != null && !publicaciones.isEmpty()) {
            publicaciones.forEach(System.out::println);
        } else {
            System.out.println("No se encontraron publicaciones.");
        }

        // 3. READ (by ID)
        System.out.println("\n3. Buscando publicacion con ID: " + idCreado);
        PublicacionPostgres pubEncontrada = dao.findById(idCreado, PublicacionPostgres.class);
        if (pubEncontrada != null) {
            System.out.println("Encontrada: " + pubEncontrada);

            // 4. UPDATE
            System.out.println("\n4. Actualizando publicacion...");
            pubEncontrada.setDescripcionPublicacion("Descripción actualizada sobre los avances en IA y machine learning.");
            dao.update(pubEncontrada);
            PublicacionPostgres pubActualizada = dao.findById(idCreado, PublicacionPostgres.class);
            System.out.println("Publicacion actualizada: " + pubActualizada);

            // 5. DELETE
            System.out.println("\n5. Eliminando publicacion...");
            dao.delete(pubActualizada);
            PublicacionPostgres pubEliminada = dao.findById(idCreado, PublicacionPostgres.class);
            if (pubEliminada == null) {
                System.out.println("Publicacion con ID " + idCreado + " eliminada correctamente.");
            } else {
                System.out.println("Error al eliminar la publicacion.");
            }
        } else {
            System.out.println("No se pudo encontrar la publicación para actualizar y eliminar.");
        }
        System.out.println("\n--- Fin del CRUD para PostgreSQL ---");
    }

    /**
     * Prueba el ciclo CRUD para la entidad PublicacionSqlServer (ID con UUID).
     */
    public static void publicacionCrudSqlServer() {
        System.out.println("\n\n--- CRUD para Publicacion con SQL Server (ID con UUID) ---");

        // 1. CREATE
        System.out.println("\n1. Creando nueva publicacion...");
        PublicacionPostgres nuevaPublicacion = new PublicacionPostgres();
        nuevaPublicacion.setNombrePublicacion("Introducción a la Nube");
        nuevaPublicacion.setDescripcionPublicacion("Conceptos básicos de cloud computing.");
        nuevaPublicacion.setFechaPublicacion(LocalDate.now().minusDays(10));
        dao.insert(nuevaPublicacion);

        // El ID UUID se asigna en la capa de persistencia, lo recuperamos del objeto.
        String idCreado = String.valueOf(nuevaPublicacion.getId());
        System.out.println("Publicacion creada con ID (UUID): " + idCreado);

        // 2. READ (all)
        System.out.println("\n2. Leyendo todas las publicaciones...");
        List<PublicacionPostgres> publicaciones = dao.getAll("PublicacionSqlServer.findAll", PublicacionPostgres.class);
        if (publicaciones != null && !publicaciones.isEmpty()) {
            publicaciones.forEach(System.out::println);
        } else {
            System.out.println("No se encontraron publicaciones.");
        }

        // 3. READ (by ID)
        System.out.println("\n3. Buscando publicacion con ID: " + idCreado);
        PublicacionPostgres pubEncontrada = dao.findById(idCreado, PublicacionPostgres.class);
        if (pubEncontrada != null) {
            System.out.println("Encontrada: " + pubEncontrada);

            // 4. UPDATE
            System.out.println("\n4. Actualizando publicacion...");
            pubEncontrada.setNombrePublicacion("Introducción a Cloud Computing (v2)");
            dao.update(pubEncontrada);
            PublicacionPostgres pubActualizada = dao.findById(idCreado, PublicacionPostgres.class);
            System.out.println("Publicacion actualizada: " + pubActualizada);

            // 5. DELETE
            System.out.println("\n5. Eliminando publicacion...");
            dao.delete(pubActualizada);
            PublicacionPostgres pubEliminada = dao.findById(idCreado, PublicacionPostgres.class);
            if (pubEliminada == null) {
                System.out.println("Publicacion con ID " + idCreado + " eliminada correctamente.");
            } else {
                System.out.println("Error al eliminar la publicacion.");
            }
        } else {
            System.out.println("No se pudo encontrar la publicación para actualizar y eliminar.");
        }
        System.out.println("\n--- Fin del CRUD para SQL Server ---");
    }


    public static void main(String[] args) {
        publicacionCrudPostgres();
        publicacionCrudSqlServer();
    }
}