package _04.model.articles;

import java.util.*;
import javax.sql.rowset.serial.SerialException;
import java.sql.*;
import org.hibernate.*;
import _04.hibernate.util.HibernateUtil;

public class ArticlesDAO implements IarticleDAO {
	private static final String INSERT_STMT = "insert into Articles values(?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT = "from ArticlesVO order by ArticleID";
	private static final String GET_WRITER_STMT = "from ArticlesVO where writerAccount = :writer";
	private static final String CHANGE_STATUS_STMT = "update articles set status= :newStatus where ArticleID = :articleID";

	@Override
//	public void insert(String writerAccount,Clob content,String title,String photoPath,java.sql.Timestamp createTime,String status,int good) {
	public void insert(String writerAccount,String content,String title,String photoPath,String status,int good) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Timestamp d=new Timestamp(System.currentTimeMillis());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.fff");
//		String dateString = sdf.format(d);
		Clob content1=null;
		try {
			session.beginTransaction();
			content1 = new javax.sql.rowset.serial.SerialClob(content.toCharArray());
			Query query = session.createSQLQuery(INSERT_STMT)
					             .setParameter(0, writerAccount)
					             .setParameter(1, content1)
					             .setParameter(2, title)
					             .setParameter(3, photoPath)
					             .setParameter(4, d)
					             .setParameter(5, status)
					             .setParameter(6, good);
			System.out.println("a");
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(ArticlesVO articlesVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(articlesVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

//	@Override
//	public void delete(String articlesVO) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			ArticlesVO articlesVO = new ArticlesVO();
//			articlesVO.getArticlesID(articlesVO);
//			session.delete(articlesVO);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//	}

	@Override
	public ArticlesVO findByPrimaryKey(String articlesID) {
		ArticlesVO articlesVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			articlesVO = (ArticlesVO) session.get(ArticlesVO.class, articlesID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return articlesVO;
	}

	@Override
	public List<ArticlesVO> getAll() {
		List<ArticlesVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
	@Override
	public List<ArticlesVO> findByWriter(String writerAccount) throws SQLException {
		List<ArticlesVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_WRITER_STMT).setParameter("writer", writerAccount);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
	@Override
	public void changeStatus(int articleID,String status) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(CHANGE_STATUS_STMT).setParameter("status", status).setParameter("articleID", articleID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	public static void main(String[] args) {

		// ● 新增
		// com.dept.model.DeptVO deptVO = new com.dept.model.DeptVO(); // 部門POJO
		// deptVO.setDeptno(10);

		// EmpVO empVO1 = new EmpVO();
		// empVO1.setEname("吳永志1");
		// empVO1.setJob("MANAGER");
		// empVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
		// empVO1.setSal(new Double(50000));
		// empVO1.setComm(new Double(500));
		// empVO1.setDeptVO(deptVO);
		// dao.insert(empVO1);
		
//		ArticlesVO articles1=new ArticlesVO();
		new ArticlesDAO().insert("Billwriter","ZZZZZZZZZZZZGarmin旗艦自行車錶Edge 1000，除了記錄騎乘的資訊完整之外同時還內建了地圖與導航，也為車錶的使用帶來更多便利與變化；不過雖然功能完整，但應該還是有些車友會覺得Edge 1000裝上車後體積略大了點。而這次最新推出的Garmin Edge 820 自行車衛星導航，便具備了與Edge 1000相近的功能，更加入了事故通知與多人即時追蹤等全新功能，但在體積與重量上則更為輕巧。'+char(13)+'這次開箱試用分成下列四個部分進行介紹，分別為：'+char(13)+'1.開箱'+char(13)+' 2.操作介面與功能'+char(13)+'3.實際使用'+char(13)+' 4.結論'+char(13)+'這次Garmin同樣製作了中文的簡介影片，在正式開箱前先看一下可以快速瞭解到這次Edge 820的重點特色功能。包含了進階騎乘資訊、多人即時追蹤、緊急訊息發送功能、內建地圖，並且能支援Varia自行車雷達等。","小體積 大功能 Garmin Edge 820自行車衛星導航","c:/test/Photo/20160907000001.jpg","1",128);
		

		// ● 修改
		// EmpVO empVO2 = new EmpVO();
		// empVO2.setEmpno(7001);
		// empVO2.setEname("吳永志2");
		// empVO2.setJob("MANAGER2");
		// empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
		// empVO2.setSal(new Double(20000));
		// empVO2.setComm(new Double(200));
		// empVO2.setDeptVO(deptVO);
		// dao.update(empVO2);

		// ● 刪除(小心cascade - 多方emp2.hbm.xml如果設為 cascade="all"或
		// cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除)
		// dao.delete(7014);

		// ● 查詢-findByPrimaryKey (多方emp2.hbm.xml必須設為lazy="false")(優!)
		// EmpVO empVO3 = dao.findByPrimaryKey(7001);
		// System.out.print(empVO3.getEmpno() + ",");
		// System.out.print(empVO3.getEname() + ",");
		// System.out.print(empVO3.getJob() + ",");
		// System.out.print(empVO3.getHiredate() + ",");
		// System.out.print(empVO3.getSal() + ",");
		// System.out.print(empVO3.getComm() + ",");
		// // 注意以下三行的寫法 (優!)
		// System.out.print(empVO3.getDeptVO().getDeptno() + ",");
		// System.out.print(empVO3.getDeptVO().getDname() + ",");
		// System.out.print(empVO3.getDeptVO().getLoc());
		// System.out.println("\n---------------------");

		// ● 查詢-getAll (多方emp2.hbm.xml必須設為lazy="false")(優!)
		IarticleDAO dao = new ArticlesDAO();
		List<ArticlesVO> list = null;
		try {
			list = dao.getAll();
			for (ArticlesVO aad : list) {
				System.out.print("id=" + aad.getArticleID() + ",");
				System.out.print("name=" + aad.getWriterAccount() + ",");
				System.out.print("division=" + aad.getContent() + ",");
				System.out.print("link=" + aad.getTitle() + ",");
				System.out.print("et=" + aad.getPhotoPath() + ",");
				System.out.print("st=" + aad.getCreateTime() + ",");
				System.out.print("st=" + aad.getStatus() + ",");
				System.out.print("priority=" + aad.getGood());
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("a");
			e.printStackTrace();
		}

	}
	


//	@Override
//	public String countDateAd(String adTime) throws SQLException {
//
//		String seq = "";
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			Query query = session.createQuery(GET_DATE_STMT);
//			int max = Integer.valueOf(query.list().toString().substring(9, 14));
//			seq = String.format("%05d", max + 1);
//			System.out.println(query.list().toString());
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//		return seq;
//
//	}

}
