package iii.runninglife.model.members;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MembersDAO implements MembersInterface{
	
	private static final String GET_ALL_STMT = "from MembersVO";
	private static final String GET_BY_NAME_STMT = "from MembersVO where firstName=:firstName OR lastName=:lastName";
	
	@Autowired
	SessionFactory sessionFactory;
		
	public MembersDAO() { super(); }
	public SessionFactory getSessionFactory() {	return sessionFactory; }
	public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
	
	@Override
	public void insert(MembersVO memberVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(memberVO);
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
		System.out.print("success delete");
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
	@SuppressWarnings("unchecked")
	@Override
	public List<MembersVO> findByFirstNameOrLastName(String name) {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(MembersVO.class)
				.add(Restrictions.disjunction(Restrictions.like("firstName", "%" + name + "%"),
											  Restrictions.like("lastName", "%" + name + "%")));
		System.out.println(cri.list().size());
		return cri.list();
	}

}
