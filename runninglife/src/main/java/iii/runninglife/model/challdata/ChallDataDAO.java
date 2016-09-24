package iii.runninglife.model.challdata;

import java.util.*;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import iii.runninglife.model.members.MembersInterface;
import iii.runninglife.model.members.MembersVO;

import java.sql.*;

@Repository
public class ChallDataDAO implements IchallDataDAO {

	private static final String GET_ALL_STMT = 
		"from ChallDataVO order by challenID";
	private static final String GET_CHALL_STMT = 
		"from ChallDataVO where challenID = :chall";
	private static final String GET_MEMBER_STMT = 
		"from ChallDataVO where memberID = :member";
	private static final String GET_MEMBER_TIME_STMT = 
		"from ChallDataVO where memberID = :member AND challenStartTime BETWEEN :startTime AND :endTime";
	private static final String GET_MEMBER_PROCESSING_STMT = 
		"from ChallDataVO where challDataPK.memberID = :member AND challDataPK.challenID.challenEndTime > :nowTime";
	private static final String GET_MEMBER_FINISH_STMT = 
			"from ChallDataVO where challDataPK.memberID = :member AND challDataPK.challenID.challenEndTime < :nowTime";
	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	MembersInterface mdao;
	
	public ChallDataDAO(){super();}
	public ChallDataDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

	@Override
	public void insert(ChallDataVO challDataVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(challDataVO);
	}

	public void update(ChallDataVO challDataVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(challDataVO);
	}

	@Override
	public void delete(ChallDataPK challData_PK) {
			ChallDataPK challDataPK = (ChallDataPK) sessionFactory.getCurrentSession().get(ChallDataPK.class, challData_PK);
			sessionFactory.getCurrentSession().delete(challDataPK);
	}

	@Override
	public ChallDataVO findByPrimaryKey(ChallDataPK challData_PK) {
		return (ChallDataVO) sessionFactory.getCurrentSession().get(ChallDataVO.class, challData_PK);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChallDataVO> getAll() {
		return sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChallDataVO> findByChall(String challenID) {
		return sessionFactory.getCurrentSession().createQuery(GET_CHALL_STMT).setParameter("chall", challenID).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChallDataVO> findByMember(String memberID) {
		return sessionFactory.getCurrentSession().createQuery(GET_MEMBER_STMT).setParameter("member", memberID).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChallDataVO> findByMemberProcessing(MembersVO memberID) {
		return sessionFactory.getCurrentSession().createQuery(GET_MEMBER_PROCESSING_STMT)
				.setParameter("member", memberID).setParameter("nowTime", new java.sql.Timestamp(System.currentTimeMillis())).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChallDataVO> findByMemberFinish(MembersVO memberID) {
		return sessionFactory.getCurrentSession().createQuery(GET_MEMBER_FINISH_STMT)
				.setParameter("member", memberID).setParameter("nowTime", new java.sql.Timestamp(System.currentTimeMillis())).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChallDataVO> findByMemberAndTime(String memberID,java.sql.Date startTime,java.sql.Date endTime) {
		return sessionFactory.getCurrentSession().createQuery(GET_MEMBER_TIME_STMT)
				.setParameter("member", memberID).setParameter("startTime", startTime).setParameter("endTime", endTime).list();
	}

}