package sessionBean;

import entity.DauSach;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ThanDieu
 */
@Stateless
public class DauSachDAO extends AbstractSessionBean<DauSach> {

    @PersistenceContext(unitName = "book-selling-webPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public DauSachDAO() {
        super(DauSach.class);
    }
}
