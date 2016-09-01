package _05model.clothes;

import java.util.List;

import org.hibernate.Session;

import _05hibernate.util.HibernateUtil;
import _05model.contest.ContestVO;

public class ClothesDAOimpl implements ClothesDAO {

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
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		ClothesDAOimpl dao = new ClothesDAOimpl();
		ClothesVO clothesVO=new ClothesVO();
		clothesVO.setClothesSize("SAs");
		clothesVO.setBreast(66);
		clothesVO.setLength(101);
		dao.insert(clothesVO);
	}

}
