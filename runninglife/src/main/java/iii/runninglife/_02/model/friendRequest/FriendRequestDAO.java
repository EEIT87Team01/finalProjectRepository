package iii.runninglife._02.model.friendRequest;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import iii.runninglife._02.model.members.MembersVO;

@Repository("friendRequestDAO")
public class FriendRequestDAO implements FriendRequestDAO_interface {
	
	@Autowired
	private SessionFactory sessionFactory;
	 
	public FriendRequestDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public FriendRequestDAO() {super();}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	
	@Override
	public void insert(FriendRequestVO friendRequestVO) {
		sessionFactory.getCurrentSession().persist(friendRequestVO);
	}

	@Override
	public void update(FriendRequestVO friendRequestVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(friendRequestVO);
	}

	@Override
	public void deleteByPrimaryKey(FriendRequestPK friendRequestPK) {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(FriendRequestVO.class)
					   .add(Restrictions.eq("friendRequestPK", friendRequestPK));
		FriendRequestVO frvo = (FriendRequestVO) cri.uniqueResult();
		sessionFactory.getCurrentSession().delete(frvo);
	}

	@Override
	public FriendRequestVO findByPrimaryKey(FriendRequestPK friendRequestPK) {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(FriendRequestVO.class)
				   .add(Restrictions.eq("friendRequestPK", friendRequestPK));
		return (FriendRequestVO) cri.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FriendRequestVO> getAll() {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(FriendRequestVO.class);
		return (List<FriendRequestVO>)cri.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FriendRequestVO> findByRequesterID(MembersVO requesterID) {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(FriendRequestVO.class)
				   .add(Restrictions.eq("friendRequestPK.requesterID", requesterID));
		return (List<FriendRequestVO>)cri.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MembersVO> findByRequesterIDALLReceiver(MembersVO requesterID) {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(FriendRequestVO.class)
				.add(Restrictions.eq("friendRequestPK.requesterID", requesterID));
		List<FriendRequestVO> lfrvo = (List<FriendRequestVO>)cri.list();
		List<MembersVO> mvos = new ArrayList<MembersVO>();
		for(FriendRequestVO fr : lfrvo) mvos.add(fr.getFriendRequestPK().getReceiverID());
		return mvos;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FriendRequestVO> findByReceiverID(MembersVO receiverID) {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(FriendRequestVO.class)
				   .add(Restrictions.eq("friendRequestPK.receiverID", receiverID));
		return (List<FriendRequestVO>)cri.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MembersVO> findByReceiverIDALLRequester(MembersVO receiverID) {
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(FriendRequestVO.class)
				.add(Restrictions.eq("friendRequestPK.receiverID", receiverID));
		List<FriendRequestVO> lfrvo = (List<FriendRequestVO>)cri.list();
		List<MembersVO> mvos = new ArrayList<MembersVO>();
		for(FriendRequestVO fr : lfrvo) mvos.add(fr.getFriendRequestPK().getRequesterID());
		return mvos;
	}
}
