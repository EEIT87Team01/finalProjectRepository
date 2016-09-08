package _02.model.members;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("membersDAO")
public class MembersDAO implements MembersDAO_interface{
	
	@Autowired
	private SessionFactory sessionFactory;
	 
	public MembersDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public MembersDAO() {super();}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

	@Override
	public void insert(MembersVO memberVo) {
		sessionFactory.getCurrentSession().persist(memberVo);
	}

	@Override
	public void update(MembersVO memberVo) {
		sessionFactory.getCurrentSession().saveOrUpdate(memberVo);
	}

	@Override
	public void deleteByPrimaryKey(String memberID) {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(MembersVO.class)
				.add(Restrictions.eq("memberID", memberID));
		MembersVO mvo = (MembersVO) cri.uniqueResult();
		sessionFactory.getCurrentSession().delete(mvo);
	}

	@Override
	public MembersVO findByID(String memberID) {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(MembersVO.class)
				.add(Restrictions.eq("memberID", memberID));
		MembersVO mvo = (MembersVO) cri.uniqueResult();
		return mvo;
	}
	
	@Override
	public MembersVO findByFirstName(String firstName) {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(MembersVO.class)
				.add(Restrictions.eq("firstName", firstName));
		MembersVO mvo = (MembersVO) cri.uniqueResult();
		return mvo;
	}

	@Override
	public List<MembersVO> getAll() {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(MembersVO.class);
		@SuppressWarnings("unchecked")
		List<MembersVO> mvos = (List<MembersVO>)cri.list();
		return mvos;
	}
	
	@Override
	public MembersVO findByAccount(String account) {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(MembersVO.class)
				.add(Restrictions.eq("account", account));
		MembersVO mvo = (MembersVO) cri.uniqueResult();
		return mvo;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MembersVO> findByFirstNameOrLastName(String name) {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(MembersVO.class)
				.add(Restrictions.disjunction()
						.add(Restrictions.like("firstName", "%" + name + "%"))
						.add(Restrictions.like("lastName", "%" + name + "%"))
						);
		List<MembersVO> mvos = (List<MembersVO>) cri.list();
		return mvos;
	}
}
