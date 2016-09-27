package iii.runninglife.model.challs;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import iii.runninglife.model.members.MembersVO;

@Repository
public class ChallsDAO implements IchallDAO {
	
	private static final String GET_ALL_STMT = 
		"from ChallsVO order by challenID";
	private static final String GET_DATE_STMT = 
		"select max(challenID) from ChallsVO where challenID like :day";
	private static final String GET_ALL_STMT_BY_DATE = 
		"from ChallsVO where :day > challenStartTime and :day < challenEndTime";
	private static final String GET_ALL_STMT_BY_ENDDATE = 
		"from ChallsVO where :day > challenEndTime";
	private static final String GET_ALL_STMT_BY_STARTDATE = 
		"from ChallsVO where :day < challenStartTime";
	private static final String GET_BY_FOUNDER_STMT = 
		"from ChallsVO where founderID = :founderID";
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ChallsDAO(){super();}
	public ChallsDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

	@Override
	public void insert(ChallsVO challVO) {
		sessionFactory.getCurrentSession().persist(challVO);
	}


	@Override
	public void delete(String challenID) {
		ChallsVO challVO = new ChallsVO();
		challVO.setChallenID(challenID);
		sessionFactory.getCurrentSession().delete(challVO);
	}

	@Override
	public ChallsVO findByPrimaryKey(String challenID) {
		return (ChallsVO) sessionFactory.getCurrentSession().get(ChallsVO.class, challenID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChallsVO> findByDate(){
		Date d=new Date(System.currentTimeMillis());
		return sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT_BY_DATE).setParameter("day", d).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChallsVO> findByEndDate(){
		Date d=new Date(System.currentTimeMillis());
		return sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT_BY_ENDDATE).setParameter("day", d).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChallsVO> findByStartDate(){
		Date d=new Date(System.currentTimeMillis());
		return sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT_BY_STARTDATE).setParameter("day", d).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChallsVO> getAll() {
		return sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChallsVO> findByFounderID(MembersVO founderID){
		return sessionFactory.getCurrentSession().createCriteria(ChallsVO.class).add(Restrictions.eq("founderID", founderID)).list();
	}
	
	@Override
	public String countDateChallenge(String challenDate){
		String seq = "00001";
		Date d=new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateString = sdf.format(d);
		dateString = dateString+"%";

		Query query = sessionFactory.getCurrentSession().createQuery(GET_DATE_STMT).setParameter("day", dateString);
		if(query.list().toString().length()!=6){
		    int max=Integer.valueOf(query.list().toString().substring(9,14));
		    seq=String.format("%05d",max+1);
		}
		System.out.println(query.list().toString());
		
		return seq;
	}
}