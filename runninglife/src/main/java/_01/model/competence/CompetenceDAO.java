package _01.model.competence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import _01.model.city.CityVO;
import _01.model.hibernate.util.HibernateUtil;

public class CompetenceDAO implements CompetenceInterface{
	
	private static final String GET_ALL_STMT = "from CompetenceVO order by CompetenceID";

	@Override
	public int insert(CompetenceVO competenceVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			session.saveOrUpdate(competenceVO);
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public int update(CompetenceVO competenceVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			session.saveOrUpdate(competenceVO);
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public int delete(String competenceVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int count = 0;
		try{
			session.beginTransaction();
			
			CompetenceVO competenceBean = (CompetenceVO)session.get(CompetenceVO.class,competenceVO);
			session.delete(competenceBean);
			
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
	public CompetenceVO selectOne(int competenceVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		CompetenceVO competenceBean = null;
		try{
			session.beginTransaction();
			
			competenceBean = (CompetenceVO)session.get(CompetenceVO.class,competenceVO);
			System.out.println("CountryID: "+competenceBean.getCompetenceID() +",");
			System.out.println("CountryID: "+competenceBean.getCompetenceName());
			System.out.println(" ");
			
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		} 
		return competenceBean;
	}

	@Override
	public List<CompetenceVO> selectAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<CompetenceVO> list = new ArrayList<CompetenceVO>();
		try{
			session.beginTransaction();
			
			Query query = session.createQuery(GET_ALL_STMT);
			list = (List<CompetenceVO>)query.list();
			for (CompetenceVO aCompetence : list) {
				System.out.println("CompetenceID: "+aCompetence.getCompetenceID() +",");
				System.out.println("CompetenceName: "+aCompetence.getCompetenceName());
			}
			
			session.getTransaction().commit();
		} catch(RuntimeException ex){
			session.getTransaction().rollback();
			throw ex;
		}

		return null;
	}
	
}
