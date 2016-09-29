package iii.runninglife.model.reportreason;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportReasonDAO implements ReportReasonDAO_interface {
	
	private static final String GET_ALL_STMT = "from ReportReasonVO order by typeID";
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ReportReasonDAO(){super();}
	public ReportReasonDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	
	@Override
	public void insert(ReportReasonVO reportReasonVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(reportReasonVO);
	}

	@Override
	public void update(ReportReasonVO reportReasonVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(reportReasonVO);
	}

	@Override
	public void delete(String typeID) {
		ReportReasonVO reportReasonVO = (ReportReasonVO) sessionFactory.getCurrentSession().get(ReportReasonVO.class, typeID);
		sessionFactory.getCurrentSession().delete(reportReasonVO);
	}

	@Override
	public ReportReasonVO findByPrimaryKey(String typeID) {
		return (ReportReasonVO) sessionFactory.getCurrentSession().get(ReportReasonVO.class, typeID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReportReasonVO> getAll() {
		return sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT).list();
	}
	
}
