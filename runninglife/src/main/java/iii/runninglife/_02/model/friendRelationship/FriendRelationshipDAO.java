package iii.runninglife._02.model.friendRelationship;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import iii.runninglife._02.model.members.MembersVO;

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
	}

	@Override
	public void deleteByPrimaryKey(FriendRelationshipPK friendRelationshipPK) {
		sessionFactory.getCurrentSession().delete(new FriendRelationshipVO (friendRelationshipPK));
	}

	@Override
	public FriendRelationshipVO findByPrimaryKey(FriendRelationshipPK friendRelationshipPK) {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(FriendRelationshipVO.class)
				   .add(Restrictions.eq("friendRelationshipPK", friendRelationshipPK));
		return (FriendRelationshipVO) cri.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FriendRelationshipVO> findByMemberID(MembersVO memberID) {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(FriendRelationshipVO.class)
				.add(Restrictions.eq("friendRelationshipPK.memberID", memberID));
		return (List<FriendRelationshipVO>)cri.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FriendRelationshipVO> getAll() {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(FriendRelationshipVO.class);
		return (List<FriendRelationshipVO>)cri.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MembersVO> findByMemberIDALLFriendID(MembersVO memberID) {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(FriendRelationshipVO.class)
				.add(Restrictions.eq("friendRelationshipPK.memberID", memberID));
		List<FriendRelationshipVO> lfrsvo = cri.list();
		List<MembersVO> mvos = new ArrayList<MembersVO>();
		for (FriendRelationshipVO frsvo : lfrsvo) mvos.add(frsvo.getFriendRelationshipPK().getFriendID());
		return mvos;
	}

}
