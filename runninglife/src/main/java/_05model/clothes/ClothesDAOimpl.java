package _05model.clothes;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import _05hibernate.util.HibernateUtil;
import _05model.event.EventVO;
@Repository
@Transactional
public class ClothesDAOimpl implements ClothesDAO {
	private static final String GET_ALL_STMT = "from ClothesVO order by breast";
	
	
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
	@Override
	public void insert(ClothesVO clothesVO) {
		Session session = getSession();
		try {
			session.saveOrUpdate(clothesVO);
		} catch (RuntimeException ex) {
			throw ex;
		}
	}
//	@Override
//	public void insert(ClothesVO clothesVO) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			session.saveOrUpdate(clothesVO);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//	}

	@Override
	public void update(ClothesVO clothesVO) {
		Session session = getSession();
		try {
			session.saveOrUpdate(clothesVO);
		} catch (RuntimeException ex) {
			throw ex;
		}
	}
//	@Override
//	public void update(ClothesVO clothesVO) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			session.saveOrUpdate(clothesVO);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//	}

	@Override
	public void delete(String clothesSize) {
		// TODO Auto-generated method stub

	}

	@Override
	public ClothesVO findByPrimaryKey(String clothesSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClothesVO> getAll() {
		List<ClothesVO> list = null;
		Session session = getSession();
		try {
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		}
		return list;
	}
//	@Override
//	public List<ClothesVO> getAll() {
//		List<ClothesVO> list = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			Query query = session.createQuery(GET_ALL_STMT);
//			list = query.list();
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//		return list;
//	}

}
