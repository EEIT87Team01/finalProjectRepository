package iii.runninglife._01.model.competence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import iii.runninglife._01.model.city.CityVO;

@Repository("CompetenceDAO")
public class CompetenceDAO implements CompetenceInterface{
	
	private static final String GET_ALL_STMT = "from CompetenceVO order by CompetenceID";
	
	SessionFactory sessionFactory;
	
	public CompetenceDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public CompetenceDAO() {super();}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

	@Override
	public void insert(CompetenceVO competenceVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(competenceVO);
	}

	@Override
	public void update(CompetenceVO competenceVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(competenceVO);
	}

	@Override
	public void delete(String competenceVO) {
		Session session = sessionFactory.getCurrentSession();
		CompetenceVO competenceBean = (CompetenceVO)session.get(CompetenceVO.class,competenceVO);
		session.delete(competenceBean);
	}

	@Override
	public CompetenceVO selectOne(int competenceVO) {
		Session session = sessionFactory.getCurrentSession();
		return (CompetenceVO)session.get(CompetenceVO.class,competenceVO);
	}

	@Override
	public List<CompetenceVO> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(GET_ALL_STMT);
		return query.list();
	}
	
}
