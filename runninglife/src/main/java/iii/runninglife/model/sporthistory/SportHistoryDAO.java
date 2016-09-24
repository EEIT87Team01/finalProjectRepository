package iii.runninglife.model.sporthistory;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import iii.runninglife.model.sporthistorypath.SportHistoryPathVO;

@Repository
public class SportHistoryDAO implements SportHistoryDAO_interface {

	private static final String GET_ALL_STMT = "from SportHistoryVO order by recordID";
	private static final String GET_DATA_BY_MEMBER_STMT = "from SportHistoryVO where memberID=:memberID order by recordID";
	private static final String GET_DATA_BY_MEMBER_DATE_TIME_STMT = "from SportHistoryVO where memberID=:memberID and startDateTime >=:startDateTime and startDateTime <=:endDateTime and endDateTime is not null order by recordID";
	private static final String GET_CURRENT_RECORDID_BY_MEMBER_STMT = "select recordID from SportHistoryVO where memberID=:memberID and startDateTime is not null and endDateTime is null order by recordID";
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SportHistoryDAO (){}
	public SportHistoryDAO (SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void insert(SportHistoryVO sportHistoryVO) {
		Session session = getSessionFactory().getCurrentSession();

		session.save(sportHistoryVO);
	}

	@Override
	public void update(SportHistoryVO sportHistoryVO) {
		Session session = getSessionFactory().getCurrentSession();

		session.update(sportHistoryVO);
		//session.saveOrUpdate(sportHistoryVO);
	}

	@Override
	public void delete(String recordID) {
		Session session = getSessionFactory().getCurrentSession();

		SportHistoryVO sportHistoryVO = (SportHistoryVO) session.get(SportHistoryVO.class, recordID);
		session.delete(sportHistoryVO);
	}

	@Override
	public SportHistoryVO findByPrimaryKey(String recordID) {
		SportHistoryVO sportHistoryVO = null;
		Session session = getSessionFactory().getCurrentSession();

		sportHistoryVO = (SportHistoryVO) session.get(SportHistoryVO.class, recordID);
	
		return sportHistoryVO;
	}

	@Override
	public List<SportHistoryVO> getAll() {
		List<SportHistoryVO> list = null;
		Session session = getSessionFactory().getCurrentSession();

		Query query = session.createQuery(GET_ALL_STMT);
		list = query.list();

		return list;
	}
	
	@Override
	public List<SportHistoryVO> getDataByMember(String memberID) {
		List<SportHistoryVO> list = null;
		Session session = getSessionFactory().getCurrentSession();

		Query query = session.createQuery(GET_DATA_BY_MEMBER_STMT);
		query.setParameter("memberID", memberID);
		list = query.list();

		return list;
	}

	@Override
	public List<SportHistoryVO> getDataByMemberDate(String memberID, Date date) {
		
		List<SportHistoryVO> list = null;
		Session session = getSessionFactory().getCurrentSession();

		Query query = session.createQuery(GET_DATA_BY_MEMBER_DATE_TIME_STMT);
		query.setParameter("memberID", memberID);
		query.setParameter("startDateTime", new Timestamp(date.getTime()));			//date 00:00:00
		query.setParameter("endDateTime", new Timestamp(date.getTime() + 86399999));//date 23:59:59
		list = query.list();

		return list;
	}

	@Override
	public List<SportHistoryVO> getDataByMemberDurationDate(String memberID, 
															Date startDate,
															Date endDate) {
		List<SportHistoryVO> list = null;
		Session session = getSessionFactory().getCurrentSession();

		Query query = session.createQuery(GET_DATA_BY_MEMBER_DATE_TIME_STMT);
		query.setParameter("memberID", memberID);
		query.setParameter("startDateTime", new Timestamp(startDate.getTime()));		//date 00:00:00
		query.setParameter("endDateTime", new Timestamp(endDate.getTime() + 86399999));	//date 23:59:59
		list = query.list();

		return list;
	}

	@Override
	public Set<SportHistoryPathVO> getPathsByRecordID(String recordID) {	
		return findByPrimaryKey(recordID).getSportHistoryPaths();
	}
	
	@Override
	public String getMemberCurrentRecordID(String memberID) {
		
		String currentRecordID = null;
		Session session = getSessionFactory().getCurrentSession();

		Query query = session.createQuery(GET_CURRENT_RECORDID_BY_MEMBER_STMT);
		query.setString("memberID", memberID);
		List<String> list = query.list();
		if(list.size() > 0) currentRecordID = list.get(0).toString();

		return currentRecordID;
	}
}
