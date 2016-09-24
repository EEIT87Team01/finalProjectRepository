package iii.runninglife.model.ads;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdsDAO implements IadDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public AdsDAO(){super();}
	public AdsDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

	private static final String GET_ALL_STMT = "from AdsVO order by adID";
	private static final String GET_DATE_STMT = "SELECT max(adID) FROM AdsVO where adID like :day";

	@Override
	public void insert(AdsVO adVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(adVO);
	}

	@Override
	public void update(AdsVO adVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(adVO);
	}

	@Override
	public void delete(String adID) {
			AdsVO adVO = new AdsVO();
			adVO.setAdID(adID);
			sessionFactory.getCurrentSession().delete(adVO);
	}

	@Override
	public AdsVO findByPrimaryKey(String adID) {
		return (AdsVO) sessionFactory.getCurrentSession().get(AdsVO.class, adID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdsVO> getAll() {
		return sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT).list();
	}

	@Override
	public String countDateAd(String adTime) {

		String seq = "00001";
		Date d = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateString = sdf.format(d);
		dateString=dateString+"%";
		Query query = sessionFactory.getCurrentSession().createQuery(GET_DATE_STMT).setParameter("day", dateString);
		if(query.list().toString().length()==6){
		}else{
			int max = Integer.valueOf(query.list().toString().substring(9, 14));
			seq = String.format("%05d", max + 1);
		}
		System.out.println(query.list().toString());
		return seq;

	}

}
