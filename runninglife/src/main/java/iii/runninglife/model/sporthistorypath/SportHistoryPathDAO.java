package iii.runninglife.model.sporthistorypath;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SportHistoryPathDAO implements SportHistoryPathDAO_interface {

	private static final String GET_ALL_STMT = "from SportHistoryPathVO order by recordID, seq";
	private static final String GET_PATHS_BY_RECORDID_STMT = "from SportHistoryPathVO where recordID=:recordID order by recordID, seq";
	private static final String GET_MAX_SEQ_BY_RECORDID_STMT = "select max(sportHistoryPathPK.seq) from SportHistoryPathVO where recordID=:recordID";

	@Autowired
	private SessionFactory sessionFactory;
	
	public SportHistoryPathDAO (){}
	public SportHistoryPathDAO (SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void insert(SportHistoryPathVO sportHistoryPathVO) {
		Session session = getSessionFactory().getCurrentSession();
		
		session.save(sportHistoryPathVO);
	}

	@Override
	public void update(SportHistoryPathVO sportHistoryPathVO) {
		Session session = getSessionFactory().getCurrentSession();
	
		session.saveOrUpdate(sportHistoryPathVO);
	}

	@Override
	public void delete(SportHistoryPathPK sportHistoryPathPK) {
		Session session = getSessionFactory().getCurrentSession();
		
		SportHistoryPathVO sportHistoryPathVO = new SportHistoryPathVO();
		sportHistoryPathVO.setSportHistoryPathPK(sportHistoryPathPK);
		session.delete(sportHistoryPathVO);
	}

	@Override
	public SportHistoryPathVO findByPrimaryKey(SportHistoryPathPK sportHistoryPathPK) {
		Session session = getSessionFactory().getCurrentSession();
			
		return (SportHistoryPathVO)session.get(SportHistoryPathVO.class, sportHistoryPathPK);
	}
	
	@Override
	public int getNextSeqByRecordID(String recordID) {
		Integer nextSeq = 0;
		Integer maxSeq = null;
		Session session = getSessionFactory().getCurrentSession();
		
		Query query = session.createQuery(GET_MAX_SEQ_BY_RECORDID_STMT);
		query.setString("recordID", recordID);
		if((maxSeq = (Integer)query.uniqueResult())!= null)
			nextSeq = maxSeq + 1;
	
		return nextSeq;
	}

	@Override
	public List<SportHistoryPathVO> getPathsByRecordID(String recordID) {
		List<SportHistoryPathVO> list = null;
		Session session = getSessionFactory().getCurrentSession();

		Query query = session.createQuery(GET_PATHS_BY_RECORDID_STMT);
		query.setParameter("recordID", recordID);
		list = query.list();
		
		return list;
	}
	
	@Override
	public List<SportHistoryPathVO> getAll() {
		List<SportHistoryPathVO> list = null;
		Session session = getSessionFactory().getCurrentSession();
		
		Query query = session.createQuery(GET_ALL_STMT);
		list = query.list();
		
		return list;
	}
}
