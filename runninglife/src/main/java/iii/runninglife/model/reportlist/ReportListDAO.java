package iii.runninglife.model.reportlist;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportListDAO implements ReportListDAO_interface {

	private static final String GET_ALL_STMT = "from ReportListVO";
	private static final String GET_ALL_UNTREATEDREPORTLIST = "from ReportListVO where status = '0'";
	private static final String GET_ALL_FINISHREPORTLIST = "from ReportListVO where status != '0'";

	@Autowired
	SessionFactory sessionFactory;
	
	public ReportListDAO(){super();}
	public ReportListDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	
	@Override
	public void insert(ReportListVO reportListVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(reportListVO);
	}

	@Override
	public void update(ReportListVO reportListVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(reportListVO);
	}

	@Override
	public void delete(ReportListVO reportListVO) {
		sessionFactory.getCurrentSession().delete(reportListVO);
	}

	@Override
	public ReportListVO findByPrimaryKey(ReportListPK reportListPK) {
		return (ReportListVO) sessionFactory.getCurrentSession().get(ReportListVO.class, reportListPK);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReportListVO> getUntreatedReportList() {
		return sessionFactory.getCurrentSession().createQuery(GET_ALL_UNTREATEDREPORTLIST).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReportListVO> getFinishReportList() {
		return sessionFactory.getCurrentSession().createQuery(GET_ALL_FINISHREPORTLIST).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReportListVO> getAll() {
		return sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT).list();
	}

}