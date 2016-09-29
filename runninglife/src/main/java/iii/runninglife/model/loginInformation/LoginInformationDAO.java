package iii.runninglife.model.loginInformation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LoginInformationDAO implements LoginInformationInterface{

	private static final String GET_ALL_STMT = "from LoginInformationVO order by memberID";
	
	@Autowired
	SessionFactory sessionFactory;
		
	public LoginInformationDAO() { super(); }
	public SessionFactory getSessionFactory() {	return sessionFactory; }
	public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

	//need
	@Override
	public void insert(LoginInformationVO loginInformationVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(loginInformationVO);
	}

	@Override
	public void update(LoginInformationVO loginInformationVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(loginInformationVO);
	}

	//need
	@Override
	public LoginInformationVO selectOne(LoginInformationPK loginInformationPK) {
		Session session = sessionFactory.getCurrentSession();
		return (LoginInformationVO)session.get(LoginInformationVO.class,loginInformationPK);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoginInformationVO> selectAll(LoginInformationVO loginInformationVO) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(GET_ALL_STMT); 
		return query.list();
	}
	

}
