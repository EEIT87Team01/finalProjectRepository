package _05model.clothes;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import _05hibernate.util.HibernateUtil;
import _05model.event.EventVO;
@Service
public class ClothesDAOimpl implements ClothesDAO {
	private static final String GET_ALL_STMT = "from ClothesVO order by breast";
	@Override
	public void insert(ClothesVO clothesVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(clothesVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(ClothesVO clothesVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(clothesVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

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
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	public static void main(String[] args) {
		ClothesDAOimpl dao = new ClothesDAOimpl();
		ClothesVO clothesVO = new ClothesVO();
		clothesVO.setClothesSize("SAs");
		clothesVO.setBreast(66);
		clothesVO.setLength(101);
		dao.insert(clothesVO);
	}

}
