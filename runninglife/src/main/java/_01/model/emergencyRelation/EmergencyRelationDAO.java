package _01.model.emergencyRelation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import _01.model.country.CountryVO;
import _01.model.hibernate.util.HibernateUtil;

public class EmergencyRelationDAO implements EmergencyRelationInterface {
	
	private static final String GET_ALL_STMT = "from EmergencyRelationVO order by relationID";
	
	@Override
	public int insert(EmergencyRelationVO emergencyRelationVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			session.saveOrUpdate(emergencyRelationVO);
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public int update(EmergencyRelationVO emergencyRelationVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			session.saveOrUpdate(emergencyRelationVO);
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public int delete(int emergencyRelationVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			
			EmergencyRelationVO emergencyRelationBean = 
					(EmergencyRelationVO)session.get(EmergencyRelationVO.class,emergencyRelationVO);
			session.delete(emergencyRelationBean);
			
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
	public EmergencyRelationVO selectOne(int emergencyRelationVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			
			EmergencyRelationVO emergencyRelationBean = 
					(EmergencyRelationVO)session.get(EmergencyRelationVO.class,emergencyRelationVO);
			System.out.println("RelationID: "+emergencyRelationBean.getRelationID() +",");
			System.out.println("RelationName: "+emergencyRelationBean.getRelationName());
			System.out.println(" ");
			
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		return null;
	}

	@Override
	public List<EmergencyRelationVO> selectAll(EmergencyRelationVO emergencyRelationVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			List<EmergencyRelationVO> list = query.list();
			for (EmergencyRelationVO aEmergencyRelation : list) {
				System.out.print(aEmergencyRelation.getRelationID() + ", ");
				System.out.println(aEmergencyRelation.getRelationName());
			}
			
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 

		return null;
	}

}
