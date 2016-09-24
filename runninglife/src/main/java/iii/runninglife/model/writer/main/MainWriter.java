package iii.runninglife.model.writer.main;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import iii.runninglife.model.adminsPriority.AdminsPriorityVO;
import iii.runninglife.model.writer.WriterDAO;
import iii.runninglife.model.writer.WriterVO;

public class MainWriter {

	public static void main(String[] args) throws UnsupportedEncodingException {
		//hibernateDAO test
		WriterDAO writerDao = new WriterDAO();
		WriterVO writerVO = new WriterVO();
		
		MessageDigest mDigest = null;
		try {
			mDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//insert or update
		writerVO.setWriterAccount("JOHNWRITER");
		String password = "8787AA";
		byte[] temp = password.getBytes("UTF-8");	//明碼  //使用者輸入byte[]
		temp = mDigest.digest(temp); 	
		writerVO.setPassword(temp);
		writerVO.setName("JOHN");
		writerVO.setEmail("writer@gmail.com");
		writerVO.setPhone("0987987879");
		writerVO.setAddress("東京都87巷426號");
		writerVO.setStatus("1");
		writerDao.insert(writerVO);
		//delete
//		writerDao.delete("Billwriter");
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
