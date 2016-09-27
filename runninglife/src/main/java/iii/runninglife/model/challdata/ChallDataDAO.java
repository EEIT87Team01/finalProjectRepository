package iii.runninglife.model.challdata;

import java.util.*;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import iii.runninglife.model.challs.ChallsVO;
import iii.runninglife.model.members.MembersInterface;
import iii.runninglife.model.members.MembersVO;

import java.sql.*;

@Repository
public class ChallDataDAO implements IchallDataDAO {

	private static final String GET_ALL_STMT = 
		"from ChallDataVO order by challenID";
	private static final String GET_CHALL_STMT = 
		"from ChallDataVO where challDataPK.challenID = :chall order by finishTime desc";
	private static final String GET_MEMBER_STMT = 
		"from ChallDataVO where memberID = :member";
	private static final String GET_MEMBER_TIME_STMT = 
		"from ChallDataVO where challDataPK.memberID.memberID = :member AND challDataPK.challenID.challenStartTime BETWEEN :startTime AND :endTime";
	private static final String GET_MEMBER_PROCESSING_STMT = 
		"from ChallDataVO where challDataPK.memberID = :member AND challDataPK.challenID.challenEndTime > :nowTime1 AND challDataPK.challenID.challenStartTime < :nowTime2 AND(status = '2' or status = '1')";
	private static final String GET_MEMBER_FINISH_STMT = 
		"from ChallDataVO where challDataPK.memberID = :member AND challDataPK.challenID.challenEndTime < :nowTime AND (status = '2' or status = '1')";
	private static final String GET_MEMBER_RESERVED_STMT = 
		"from ChallDataVO where challDataPK.memberID = :member AND challDataPK.challenID.challenStartTime > :nowTime AND status = '1'";
	private static final String GET_MEMBER_RECEIVED_REQUEST_STMT = 
		"from ChallDataVO where challDataPK.memberID = :member AND isFounder = '0' AND status = '0'";
	private static final String GET_TOP_10_STMT =
		"select top 10 ChallDataVO.finishTime from ChallDataVO where challDataPK.challenID = :chall ";
	private static final String DELETE_BY_CHALLENGEID =
		"delete from ChallDataVO where challDataPK.challenID = :chall ";
	
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
	
	@Override
	public void insertByFounder(ChallDataVO challDataVO) {
		challDataVO.setStatus("3");
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
	public List<ChallDataVO> findByChall(ChallsVO challenID) {
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
				.setParameter("member", memberID).setParameter("nowTime1", new java.sql.Timestamp(System.currentTimeMillis()))
				.setParameter("nowTime2", new java.sql.Timestamp(System.currentTimeMillis())).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChallDataVO> findByMemberFinish(MembersVO memberID) {
		return sessionFactory.getCurrentSession().createQuery(GET_MEMBER_FINISH_STMT)
				.setParameter("member", memberID).setParameter("nowTime", new java.sql.Timestamp(System.currentTimeMillis())).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChallDataVO> findByMemberReserved(MembersVO memberID) {
		return sessionFactory.getCurrentSession().createQuery(GET_MEMBER_RESERVED_STMT)
				.setParameter("member", memberID).setParameter("nowTime", new java.sql.Timestamp(System.currentTimeMillis())).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChallDataVO> findByMemberAndTime(String memberID,java.sql.Date startTime,java.sql.Date endTime) {
		return sessionFactory.getCurrentSession().createQuery(GET_MEMBER_TIME_STMT)
				.setParameter("member", memberID).setParameter("startTime", startTime).setParameter("endTime", endTime).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ChallDataVO> findByMemberReceivedRequest(MembersVO memberID) {
		return sessionFactory.getCurrentSession().createQuery(GET_MEMBER_RECEIVED_REQUEST_STMT).setParameter("member", memberID).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public int deleteByChallengeID(ChallsVO challenID) {
		return sessionFactory.getCurrentSession().createQuery(DELETE_BY_CHALLENGEID).setParameter("chall", challenID).executeUpdate();
	}
	

}