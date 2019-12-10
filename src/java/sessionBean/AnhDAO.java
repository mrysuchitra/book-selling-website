package sessionBean;

import entity.Anh;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ThanDieu
 */
@Stateless
public class AnhDAO extends AbstractSessionBean<Anh> {
    @PersistenceContext(unitName = "book-selling-webPU")
    private EntityManager em;
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("book-selling-webPU");
//    private EntityManager em = emf.createEntityManager(); 

    protected EntityManager getEntityManager() {
        return em;
    }

    public AnhDAO() {
        super(Anh.class);
    }
}