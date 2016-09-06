package _02.model.friendRelationship;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("friendRelationshipDAO")
public class FriendRelationshipDAO implements FriendRelationshipDAO_interface {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public FriendRelationshipDAO() {super();}
	public FriendRelationshipDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

	@Override
	public void insert(FriendRelationshipVO friendRelationshipVO) {
		sessionFactory.getCurrentSession().persist(friendRelationshipVO);
		sessionFactory.getCurrentSession().persist(new FriendRelationshipVO (
										new FriendRelationshipPK(
												friendRelationshipVO.getFriendRelationshipPK().getFriendID(),
												friendRelationshipVO.getFriendRelationshipPK().getMemberID())));
	}

	@Override
	public void deleteByPrimaryKey(FriendRelationshipPK friendRelationshipPK) {
		sessionFactory.getCurrentSession().delete(new FriendRelationshipVO (friendRelationshipPK));
		sessionFactory.getCurrentSession().delete(new FriendRelationshipVO (
										new FriendRelationshipPK(
												friendRelationshipPK.getFriendID(),
												friendRelationshipPK.getMemberID())));
	}

	@Override
	public FriendRelationshipVO findByPrimaryKey(FriendRelationshipPK friendRelationshipPK) {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(FriendRelationshipVO.class)
				   .add(Restrictions.eq("friendRelationshipPK", friendRelationshipPK));
		return (FriendRelationshipVO) cri.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FriendRelationshipVO> getAll() {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(FriendRelationshipVO.class);
		return (List<FriendRelationshipVO>)cri.list();
	}

}
