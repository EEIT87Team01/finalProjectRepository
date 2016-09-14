package iii.runninglife._01.model.writer;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class WriterDAO implements WriterInterface {

	private static final String GET_ALL_STMT = "from WriterVO order by writerAccount";
	
	SessionFactory sessionFactory;
	
	
	
	public WriterDAO() {super();}
	public WriterDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public SessionFactory getSessionFactory() {	return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

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
		WriterVO adminsBean = (WriterVO)session.get(WriterVO.class,writerVO);
		session.delete(adminsBean);
	}

	@Override
	public WriterVO selectOne(String writerVO) {
		return (WriterVO)sessionFactory.getCurrentSession().get(WriterVO.class,writerVO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WriterVO> selectAll() {
		Query query = sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT); 
		return query.list();
	}
	
}
