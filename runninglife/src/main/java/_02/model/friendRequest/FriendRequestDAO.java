package _02.model.friendRequest;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
