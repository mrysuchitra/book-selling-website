package sessionBean;

import entity.QuyenSach;
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
public class QuyenSachDAO extends AbstractSessionBean<QuyenSach> {
    

//    @PersistenceContext(unitName = "book-selling-webPU")
//    private EntityManager em;book-selling-webPU
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("book-selling-webPU");
    private EntityManager em = emf.createEntityManager(); 

    protected EntityManager getEntityManager() {
        return em;
    }

    public QuyenSachDAO() {
        super(QuyenSach.class);
    }
}