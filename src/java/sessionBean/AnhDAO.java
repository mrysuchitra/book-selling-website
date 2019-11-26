package sessionBean;

import entity.Anh;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ThanDieu
 */
@Stateless
public class AnhDAO extends AbstractSessionBean<Anh> {

    @PersistenceContext(unitName = "book-selling-webPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AnhDAO() {
        super(Anh.class);
    }
}