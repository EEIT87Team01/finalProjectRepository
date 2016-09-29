package iii.runninglife.model.competence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CompetenceDAO implements CompetenceInterface{
	
	private static final String GET_ALL_STMT = "from CompetenceVO order by CompetenceID";
	
	@Autowired
	SessionFactory sessionFactory;
		
	public CompetenceDAO() { super(); }
	public SessionFactory getSessionFactory() {	return sessionFactory; }
	public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
	
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
		Criteria cri =  sessionFactory.getCurrentSession()
				.createCriteria(CompetenceVO.class).add(Restrictions.eq("competenceID", competenceVO));
		
		return (CompetenceVO)cri.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompetenceVO> selectAll() {
		Query query = sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT); 
		return query.list();
	}
	
}
