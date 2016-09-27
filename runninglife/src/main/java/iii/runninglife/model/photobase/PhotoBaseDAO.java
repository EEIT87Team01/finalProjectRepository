package iii.runninglife.model.photobase;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PhotoBaseDAO implements PhotoBaseDAO_interface {

	private static final String GET_ALL_STMT = "from PhotoBaseVO order by photoid";
	
	@Autowired
	SessionFactory sessionFactory;
	
	public PhotoBaseDAO(){super();}
	public PhotoBaseDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

	@Override
	public void insert(PhotoBaseVO photoBaseVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(photoBaseVO);	
	}

	@Override
	public void update(PhotoBaseVO photoBaseVO) {
		sessionFactory.getCurrentSession().saveOrUpdate(photoBaseVO);
	}

	@Override
	public void delete(String photoID) {
		PhotoBaseVO photoBaseVO = (PhotoBaseVO) sessionFactory.getCurrentSession().get(PhotoBaseVO.class, photoID);
		sessionFactory.getCurrentSession().delete(photoBaseVO);
	}

	@Override
	public PhotoBaseVO findByPrimaryKey(String photoID) {
		return (PhotoBaseVO) sessionFactory.getCurrentSession().get(PhotoBaseVO.class, photoID);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PhotoBaseVO> getAll() {
		return sessionFactory.getCurrentSession().createQuery(GET_ALL_STMT).list();
	}
}
//test all ok save20160904