package _01.model.admins;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import _01.model.hibernate.util.HibernateUtil;

public class AdminsDAO implements AdminsInterface{
	
	private static final String GET_ALL_STMT = "from AdminsVO order by adminAccount";
	
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx = null;
	@Override
	public int insert(AdminsVO adminsVO) {
		int count = 0;
		try{
			tx = session.beginTransaction();
			session.saveOrUpdate(adminsVO);
			tx.commit();
		} catch(RuntimeException ex){
			tx.rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public int update(AdminsVO adminsVO) {
		int count = 0;
		try{
			tx = session.beginTransaction();
			
			AdminsVO adminsBean = (AdminsVO)session.get(AdminsVO.class,adminsVO);
			session.delete(adminsBean);
			
			tx.commit();
		} catch(RuntimeException ex){
			tx.rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public int delete(String adminsVO) {
		int count = 0;
		try{
			tx = session.beginTransaction();
			
			AdminsVO adminsBean = (AdminsVO)session.get(AdminsVO.class,adminsVO);
			session.delete(adminsBean);
			
			tx.commit();
			System.out.print("success delete");
		} catch(RuntimeException ex){
			tx.rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public AdminsVO selectOne(String adminsVO) {
		try{
			tx = session.beginTransaction();
			
			AdminsVO adminsBean = (AdminsVO)session.get(AdminsVO.class,adminsVO);
			System.out.println("AdminAccount: "+adminsBean.getAdminAccount() +", ");
			System.out.println("Password: "+adminsBean.getPassword() + ", ");
			System.out.println("Name: "+adminsBean.getName() + ", ");
			System.out.println("LevelID: "+adminsBean.getAdminsPriorityBean().getLevelID() + ", ");
			System.out.println("Status: "+adminsBean.getStatus());
			System.out.println(" ");
			
			tx.commit();
		} catch(RuntimeException ex){
			tx.rollback();
			throw ex;
		} 
		return null;
	}

	@Override
	public List<AdminsVO> selectAll() {
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT); 
			List<AdminsVO> list = query.list();
			for (AdminsVO aAdmin : list) {
				System.out.print(aAdmin.getAdminAccount() + ", ");
				System.out.print(aAdmin.getPassword() + ", ");
				System.out.print(aAdmin.getName()+ ", ");
				System.out.print(aAdmin.getAdminsPriorityBean().getLevelID() + ", ");
				System.out.println(aAdmin.getStatus());
			}
			
			tx.commit();
		} catch(RuntimeException ex){
			tx.rollback();
			throw ex;
		} 

		return null;
	}

}
