package _04.model.members;

import java.util.*;
import java.sql.*;
import org.hibernate.*;
import _04.hibernate.util.HibernateUtil;


public class MembersDAO implements ImembersDAO  {
	
	

			private static final String GET_ALL_STMT = 
				"from MembersVO order by memberID";
//			private static final String GET_DATE_STMT = 
//				"SELECT count(*) FROM challenge WHERE challenID  LIKE ?";
			
//			private static final String GET_ALL_STMT = "from EmpVO order by empno";

			@Override
			public void insert(MembersVO adVO) {
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
			public void update(MembersVO adVO) {
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
			public void delete(String memberID) {
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				try {
					session.beginTransaction();
					MembersVO adVO = new MembersVO();
					adVO.setMemberID(memberID);
					session.delete(adVO);
					session.getTransaction().commit();
				} catch (RuntimeException ex) {
					session.getTransaction().rollback();
					throw ex;
				}
			}

			@Override
			public MembersVO findByPrimaryKey(String memberID) {
				MembersVO adVO = null;
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				try {
					session.beginTransaction();
					adVO = (MembersVO) session.get(MembersVO.class, memberID);
					session.getTransaction().commit();
				} catch (RuntimeException ex) {
					session.getTransaction().rollback();
					throw ex;
				}
				return adVO;
			}

			@Override
			public List<MembersVO> getAll() {
				List<MembersVO> list = null;
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
			
//			public void closeConn() throws SQLException {
//				if (conn != null)
//					conn.close();
//			}

			public static void main(String[] args) {

				

				//● 新增
//				com.dept.model.DeptVO deptVO = new com.dept.model.DeptVO(); // 部門POJO
//				deptVO.setDeptno(10);

//				EmpVO empVO1 = new EmpVO();
//				empVO1.setEname("吳永志1");
//				empVO1.setJob("MANAGER");
//				empVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
//				empVO1.setSal(new Double(50000));
//				empVO1.setComm(new Double(500));
//				empVO1.setDeptVO(deptVO);
//				dao.insert(empVO1);



				//● 修改
//				EmpVO empVO2 = new EmpVO();
//				empVO2.setEmpno(7001);
//				empVO2.setEname("吳永志2");
//				empVO2.setJob("MANAGER2");
//				empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//				empVO2.setSal(new Double(20000));
//				empVO2.setComm(new Double(200));
//				empVO2.setDeptVO(deptVO);
//				dao.update(empVO2);



				//● 刪除(小心cascade - 多方emp2.hbm.xml如果設為 cascade="all"或
				// cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除)
//				dao.delete(7014);



				//● 查詢-findByPrimaryKey (多方emp2.hbm.xml必須設為lazy="false")(優!)
//				EmpVO empVO3 = dao.findByPrimaryKey(7001);
//				System.out.print(empVO3.getEmpno() + ",");
//				System.out.print(empVO3.getEname() + ",");
//				System.out.print(empVO3.getJob() + ",");
//				System.out.print(empVO3.getHiredate() + ",");
//				System.out.print(empVO3.getSal() + ",");
//				System.out.print(empVO3.getComm() + ",");
//				// 注意以下三行的寫法 (優!)
//				System.out.print(empVO3.getDeptVO().getDeptno() + ",");
//				System.out.print(empVO3.getDeptVO().getDname() + ",");
//				System.out.print(empVO3.getDeptVO().getLoc());
//				System.out.println("\n---------------------");



				//● 查詢-getAll (多方emp2.hbm.xml必須設為lazy="false")(優!)
				ImembersDAO dao = new MembersDAO();
				List<MembersVO> list = null;
				try {
					list = dao.getAll();
					for (MembersVO aad : list) {
						System.out.print("id="+aad.getMemberID() + ",");
						System.out.println();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("a");
					e.printStackTrace();
				}
				
			}



			
//			Connection conn = null;
//			@Override
//			public void getConnection() throws SQLException {
//				String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=runninglife";
//				conn = DriverManager.getConnection(connUrl, "sa", "P@ssw0rd");
//			}
//			
			

	}




