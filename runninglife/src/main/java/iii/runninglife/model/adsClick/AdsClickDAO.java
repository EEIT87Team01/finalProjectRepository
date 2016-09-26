package iii.runninglife.model.adsClick;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdsClickDAO implements IadClickDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public AdsClickDAO(){super();}
	public AdsClickDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	
	private static final String GET_ALL_STMT = "from AdsClickVO order by adID";
	private static final String GET_TIME_STMT = "from AdsClickVO where adID= :adID AND clickDay BETWEEN :startTime AND :endTime";

	@Override
	public void insert(AdsClickVO adsClickVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(adsClickVO);
	}

	@Override
	public void update(AdsClickVO adsClickVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(adsClickVO);
	}

	@Override
	public AdsClickVO findByPrimaryKey(AdsClickPK adsClick_PK) {
		return (AdsClickVO) sessionFactory.getCurrentSession().get(AdsClickVO.class, adsClick_PK);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AdsClickVO> findByTimeRange(String adID, java.sql.Date startTime, java.sql.Date endTime) {
		return sessionFactory.getCurrentSession().createQuery(GET_TIME_STMT)
				.setParameter("startTime", startTime).setParameter("endTime", endTime).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdsClickVO> getAll() {
		return sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT).list();
	}
}