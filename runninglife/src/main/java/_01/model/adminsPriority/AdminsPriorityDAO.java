package _01.model.adminsPriority;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import _01.model.admins.AdminsVO;
import _01.model.hibernate.util.HibernateUtil;

public class AdminsPriorityDAO implements AdminsPriorityInterface{

	private static final String GET_ALL_STMT = "from AdminsPriorityVO order by levelID";
	
	@Override
	public int insert(AdminsPriorityVO adminsPriorityVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			session.saveOrUpdate(adminsPriorityVO);
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public int update(AdminsPriorityVO adminsPriorityVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			session.saveOrUpdate(adminsPriorityVO);
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public int delete(String adminsPriorityVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			
			AdminsPriorityVO adminsPriorityBean = 
					(AdminsPriorityVO)session.get(AdminsPriorityVO.class,adminsPriorityVO);
			session.delete(adminsPriorityBean);
			
			session.getTransaction().commit();
			System.out.print("success delete");
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public AdminsPriorityVO selectOne(String adminsPriorityVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			
			AdminsPriorityVO adminsPriorityBean = 
					(AdminsPriorityVO)session.get(AdminsPriorityVO.class,adminsPriorityVO);
			System.out.println("AdminAccount: "+adminsPriorityBean.getLevelID() +", ");
			System.out.println("LevelName: "+adminsPriorityBean.getLevelName());
			System.out.println(" ");
			
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		return null;
	}

	@Override
	public List<AdminsPriorityVO> selectAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT); 
			List<AdminsPriorityVO> list = query.list();
			for (AdminsPriorityVO aAdminPriority : list) {
				System.out.print(aAdminPriority.getLevelID() + ", ");
				System.out.println(aAdminPriority.getLevelName());
			}
			
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 

		return null;
	}

}
