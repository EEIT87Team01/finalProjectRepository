package iii.runninglife.model.posts;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostsDAO implements PostsDAO_interface {
	private static final String GET_ALL_STMT = "from PostsVO order by postID desc";
	private static final String GET_ONE_MEMBER_POST_ALL = "from PostsVO where postMemberID=:postMemberID and status = 1 order by postID desc";
	private static final String GET_RESPONSEAll = "from PostsVO where parent is not NULL and status = 1 order by time";
	private static final String CHANGE_STATUS = "UPDATE PostsVO SET status=:status where postID=:postID or parent =:parent";
	
	@Autowired
	SessionFactory sessionFactory;
	
	public PostsDAO(){super();}
	public PostsDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	
	@Override
	 public void insert(PostsVO postsVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(postsVO);	
	}

	@Override
	public void update(PostsVO postsVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(postsVO);
	}

	@Override
	public void delete(String postsID) {
			PostsVO postsVO = (PostsVO) sessionFactory.getCurrentSession().get(PostsVO.class, postsID);
			sessionFactory.getCurrentSession().delete(postsVO);
	}

	@Override
	public PostsVO findByPrimaryKey(String postID) {
		return (PostsVO) sessionFactory.getCurrentSession().get(PostsVO.class, postID);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PostsVO> getAll() {
		return sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PostsVO> getMemberPostAll(String memberID) {
		Query query = sessionFactory.getCurrentSession().createQuery(GET_ONE_MEMBER_POST_ALL);
		query.setString("postMemberID", memberID);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PostsVO> getResponseAll() {
		return sessionFactory.getCurrentSession().createQuery(GET_RESPONSEAll).list();
	}
	@Override
	public void changeStatus(PostsVO postsVO) {
		Query query = sessionFactory.getCurrentSession().createQuery(CHANGE_STATUS);
		query.setString("status", postsVO.getStatus());
		query.setString("postID", postsVO.getPostID());
		query.setString("parent", postsVO.getPostID());
		query.executeUpdate();
	}	
}