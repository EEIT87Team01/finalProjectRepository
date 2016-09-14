package iii.runninglife._01.model.members;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("MembersDAO")
public class MembersDAO implements MembersInterface{
	
	private static final String GET_ALL_STMT = "from MembersVO ";
	
	SessionFactory sessionFactory;
	
	public MembersDAO(){super();}
	public MembersDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

	@Override
	public void insert(MembersVO membersVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(membersVO);
	}

	@Override
	public void update(MembersVO memberVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(memberVO);
	}

	@Override
	public void delete(String memberVO) {
		Session session = sessionFactory.getCurrentSession();
		MembersVO membersBean = (MembersVO)session.get(MembersVO.class,memberVO);
		session.delete(membersBean);
	}

	@Override
	public MembersVO selectOne(String memberVO) {
		Session session = sessionFactory.getCurrentSession();
		return (MembersVO)session.get(MembersVO.class,memberVO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MembersVO> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(GET_ALL_STMT); 
		return query.list();
	}

}
