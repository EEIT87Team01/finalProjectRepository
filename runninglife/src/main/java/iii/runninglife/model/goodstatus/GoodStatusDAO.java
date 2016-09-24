package iii.runninglife.model.goodstatus;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GoodStatusDAO implements GoodStatusDAO_interface {
	private static final String GET_ALL_STMT = "from GoodStatusVO order by postID,memberID";
	private static final String GOOD_COUNT = "select count(*) from GoodStatusVO  where postID=:postID";
	
	@Autowired
	SessionFactory sessionFactory;
	
	public GoodStatusDAO(){super();}
	public GoodStatusDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	
	@Override
	public void insert(GoodStatusVO goodStatusVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(goodStatusVO);
	}

	@Override
	public void update(GoodStatusVO goodStatusVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(goodStatusVO);
	}

	@Override
	public void delete(GoodStatusVO goodStatusVO) {
		sessionFactory.getCurrentSession().delete(goodStatusVO);
	}

	@Override
	public GoodStatusVO findByPrimaryKey(GoodStatusPK goodStatusPK) {
		return (GoodStatusVO) sessionFactory.getCurrentSession().get(GoodStatusVO.class, goodStatusPK);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GoodStatusVO> getAll() {
		return sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT).list();
	}

	public Long goodCount(String postID) {
		Query query = sessionFactory.getCurrentSession().createQuery(GOOD_COUNT);
		query.setString("postID", postID);
		return (Long)query.uniqueResult();
	}
}
//test all ok save20160904
