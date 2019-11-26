package sessionBean;

import entity.NguoiDung;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ThanDieu
 */
@Stateless
public class NguoiDungDAO extends AbstractSessionBean<NguoiDung> {

    @PersistenceContext(unitName = "book-selling-webPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public NguoiDungDAO() {
        super(NguoiDung.class);
    }
}