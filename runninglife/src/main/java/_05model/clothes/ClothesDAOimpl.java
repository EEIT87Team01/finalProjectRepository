package _05model.clothes;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import _05hibernate.util.HibernateUtil;

class ClothesDAOimpl implements ClothesDAO {
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
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ClothesVO clothesVO = (ClothesVO) session.get(ClothesVO.class, clothesSize);
			session.delete(clothesVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public ClothesVO findByPrimaryKey(String clothesSize) {
		ClothesVO ClothesVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ClothesVO = (ClothesVO) session.get(ClothesVO.class, clothesSize);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return ClothesVO;
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
		ClothesVO clothesVO= new ClothesVO();
		clothesVO.setClothesSize("SSA");
		clothesVO.setBreast(43);
		clothesVO.setLength(67);;
		
		ClothesDAOimpl dao =  new ClothesDAOimpl();
//		dao.insert(clothesVO);
//		dao.delete("3XL");
		List<ClothesVO> clothes=dao.getAll();
		for(ClothesVO aClothes:clothes){
			System.out.printf("%6s",aClothes.getClothesSize());
			System.out.printf("%6s",aClothes.getLength());
			System.out.printf("%6s\n",aClothes.getBreast());
		}
	
	}

}
