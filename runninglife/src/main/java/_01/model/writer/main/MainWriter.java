package _01.model.writer.main;

import _01.model.adminsPriority.AdminsPriorityVO;
import _01.model.writer.WriterDAO;
import _01.model.writer.WriterVO;

public class MainWriter {

	public static void main(String[] args) {
		//hibernateDAO test
		WriterDAO writerDao = new WriterDAO();
		WriterVO writerVO = new WriterVO();
		
		//insert or update
//		writerVO.setWriterAccount("JOHNWRITER");
//		writerVO.setPassword("TEST987");
//		writerVO.setName("JOHN");
//		writerVO.setEmail("writer@gmail.com");
//		writerVO.setPhone("0987987879");
//		writerVO.setAddress("東京都87巷426號");
//		writerVO.setStatus("1");
//		writerDao.insert(writerVO);
		//delete
		writerDao.delete("Billwriter");
		//selectOne
//		writerDao.selectOne("Billwriter");
		//selectAll
//		writerDao.selectAll();
		
		//Unit test
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = null;
//		try{
//			tx = session.beginTransaction();
//			
//			
//			tx.commit();
//		}catch(RuntimeException ex){
//			if (tx != null){
//				tx.rollback();
//				System.out.println("runtime error!");
//				throw ex;
//			}
//		} finally{
//			HibernateUtil.getSessionFactory().close();
//		}
//
	}

}
