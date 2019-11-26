package sessionBean;

import entity.ReviewSach;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ThanDieu
 */
@Stateless
public class ReviewSachDAO extends AbstractSessionBean<ReviewSach> {

    @PersistenceContext(unitName = "book-selling-webPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ReviewSachDAO() {
        super(ReviewSach.class);
    }
}