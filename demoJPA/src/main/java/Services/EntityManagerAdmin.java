package Services;

public class EntityManagerAdmin {
    private static String UNIDAD_PERSISTENCE = "DEMOJPA";

    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory(UNIDAD_PERSISTENCE);
        EntityManager em = emf.createEntityManager();
        return em;
    }
    private EntityManagerAdmin() {}
}
