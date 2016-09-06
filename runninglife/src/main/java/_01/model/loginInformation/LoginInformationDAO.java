package _01.model.loginInformation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import _01.model.hibernate.util.HibernateUtil;
import _01.model.writer.WriterVO;

public class LoginInformationDAO implements LoginInformationInterface{

	private static final String GET_ALL_STMT = "from LoginInformationVO order by memberID";

	//need
	@Override
	public int insert(LoginInformationVO loginInformationVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			session.saveOrUpdate(loginInformationVO);
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public int update(LoginInformationVO loginInformationVO) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
//		try{
//			session.beginTransaction();
//			session.saveOrUpdate(loginInformationVO);
//			session.getTransaction().commit();
//		} catch(RuntimeException ex){
//			session.getTransaction().rollback();
//			throw ex;
//		} 
//		count++;
		return count;
	}

	@Override
	public int delete(LoginInformationPK loginInformationVO) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
//		try{
//			session.beginTransaction();
//			
//			LoginInformationVO loginInformationBean = 
//					(LoginInformationVO)session.get(LoginInformationVO.class,loginInformationVO);
//			session.delete(loginInformationBean);
//			
//			session.getTransaction().commit();
//			System.out.print("success delete");
//		} catch(RuntimeException ex){
//			session.getTransaction().rollback();
//			throw ex;
//		} 
//		count++;
		return count;
	}
	
	//need
	@Override
	public LoginInformationVO selectOne(LoginInformationPK loginInformationPK) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		LoginInformationVO loginInformationBean = null;
		try{
			session.beginTransaction();
			
			loginInformationBean = 
					(LoginInformationVO)session.get(LoginInformationVO.class,loginInformationPK);
			System.out.println("MemberAccount: "+loginInformationBean.getLoginInformationID().getMemberID() +", ");
			System.out.println("Password: "+loginInformationBean.getMemberAccount() + ", ");
			System.out.println("LoginMethod: "+loginInformationBean.getPassword() + ", ");
			System.out.println("MemberID: "+loginInformationBean.getLoginInformationID().getLoginMethod() + ", ");
			System.out.println("MemberID: "+loginInformationBean.getStatus());
			System.out.println(" ");
			
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		return loginInformationBean;
	}

	@Override
	public List<LoginInformationVO> selectAll(LoginInformationVO loginInformationVO) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try{
//			session.beginTransaction();
//			Query query = session.createQuery(GET_ALL_STMT); 
//			List<LoginInformationVO> list = query.list();
//			for (LoginInformationVO aLoginInformation : list) {
//				System.out.print(aLoginInformation.getLoginInformationID().getMemberID() + ", ");
//				System.out.print(aLoginInformation.getMemberAccount() + ", ");
//				System.out.print(aLoginInformation.getPassword()+ ", ");
//				System.out.print(aLoginInformation.getLoginInformationID().getLoginMethod());
//			}
//			
//			session.getTransaction().commit();
//		} catch(RuntimeException ex){
//			session.getTransaction().rollback();
//			throw ex;
//		} 
		return null;
	}
	
//	private LoginInformationVO isExi

}
