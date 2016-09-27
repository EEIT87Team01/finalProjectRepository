package iii.runninglife.model.articles;

import java.sql.Clob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ArticlesDAO implements IarticleDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ArticlesDAO(){super();}
	public ArticlesDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	
	private static final String INSERT_STMT = "insert into Articles values(?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT = "from ArticlesVO order by ArticleID";
	private static final String GET_WRITER_STMT = "from ArticlesVO where writerAccount = :writer";
	private static final String CHANGE_STATUS_STMT = "update articles set status= :newStatus where ArticleID = :articleID";

	@Override
	public void insert(String writerAccount,String content,String title) {
		Timestamp d=new Timestamp(System.currentTimeMillis());
		Query query = sessionFactory.getCurrentSession().createSQLQuery(INSERT_STMT)
				             .setParameter(0, writerAccount)
				             .setParameter(1, content)
				             .setParameter(2, title)
				             .setParameter(3, "")
				             .setParameter(4, d)
				             .setParameter(5, "1")
				             .setParameter(6, 0);
		query.executeUpdate();
	}

	@Override
	public void update(ArticlesVO articlesVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(articlesVO);
	}

	@Override
	public ArticlesVO findByPrimaryKey(String articlesID) {
		int articlesIDINT=Integer.valueOf(articlesID);
		return (ArticlesVO) sessionFactory.getCurrentSession().get(ArticlesVO.class, articlesIDINT);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArticlesVO> getAll() {
		return sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ArticlesVO> findByWriter(String writerAccount) {
		return sessionFactory.getCurrentSession().createQuery(GET_WRITER_STMT).setParameter("writer", writerAccount).list();
	}
	
	@Override
	public void changeStatus(int articleID,String status) {
		sessionFactory.getCurrentSession().createQuery(CHANGE_STATUS_STMT).setParameter("status", status).setParameter("articleID", articleID);
	}
}
