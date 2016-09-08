package _04.model.ads;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import _04.hibernate.util.HibernateUtil;

public class AdDAO implements IadDAO {

	private static final String GET_ALL_STMT = "from AdVO order by adID";
	private static final String GET_DATE_STMT = "SELECT max(adId) FROM AdVO";

	@Override
	public void insert(AdVO adVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(adVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(AdVO adVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(adVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(String adID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			AdVO adVO = new AdVO();
			adVO.setAdID(adID);
			session.delete(adVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public AdVO findByPrimaryKey(String adID) {
		AdVO adVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			adVO = (AdVO) session.get(AdVO.class, adID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return adVO;
	}

	@Override
	public List<AdVO> getAll() {
		List<AdVO> list = null;
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
		IadDAO dao = new AdDAO();
		List<AdVO> list = null;
		try {
			list = dao.getAll();
			for (AdVO aad : list) {
				System.out.print("id=" + aad.getAdID() + ",");
				System.out.print("name=" + aad.getAdName() + ",");
				System.out.print("division=" + aad.getDivision() + ",");
				System.out.print("link=" + aad.getLink() + ",");
				System.out.print("st=" + aad.getAdStartTime() + ",");
				System.out.print("et=" + aad.getAdEndTime() + ",");
				System.out.print("priority=" + aad.getPriority());
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("a");
			e.printStackTrace();
		}

	}

	@Override
	public String countDateAd(String adTime) throws SQLException {

		String seq = "";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_DATE_STMT);
			int max = Integer.valueOf(query.list().toString().substring(9, 14));
			seq = String.format("%05d", max + 1);
			System.out.println(query.list().toString());
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return seq;

	}

}
