package iii.runninglife.model.writer;

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
public class WriterDAO implements WriterInterface {

	private static final String GET_ALL_STMT = "from WriterVO order by writerAccount";
	
	@Autowired
	SessionFactory sessionFactory;
		
	public WriterDAO() { super(); }
	public SessionFactory getSessionFactory() {	return sessionFactory; }
	public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
	
	@Override
	public void insert(WriterVO writerVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(writerVO);
	}

	@Override
	public void update(WriterVO writerVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(writerVO);
	}

	@Override
	public void delete(String writerVO) {
		Session session = sessionFactory.getCurrentSession();
		WriterVO writerBean = (WriterVO)session.get(WriterVO.class,writerVO);
		session.delete(writerBean);
	}

	@Override
	public WriterVO selectOne(String writerVO) {
		Criteria cri =  sessionFactory.getCurrentSession()
				.createCriteria(WriterVO.class).add(Restrictions.eq("writerAccount", writerVO));
		
		return (WriterVO)cri.uniqueResult();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WriterVO> selectAll() {
		Query query = sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT); 
		return query.list();
	}
	
}
