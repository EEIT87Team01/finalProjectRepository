package _01.model.writer;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import _01.model.admins.AdminsVO;
import _01.model.hibernate.util.HibernateUtil;

public class WriterDAO implements WriterInterface {

	private static final String GET_ALL_STMT = "from WriterVO order by writerAccount";
	
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	Transaction tx = null;
	@Override
	public int insert(WriterVO writerVO) {
		int count = 0;
		try{
			tx = session.beginTransaction();
			session.saveOrUpdate(writerVO);
			tx.commit();
		} catch(RuntimeException ex){
			tx.rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public int update(WriterVO writerVO) {
		int count = 0;
		try{
			tx = session.beginTransaction();
			session.saveOrUpdate(writerVO);
			tx.commit();
		} catch(RuntimeException ex){
			tx.rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public int delete(String writerVO) {
		int count = 0;
		try{
			tx = session.beginTransaction();
			
			WriterVO adminsBean = (WriterVO)session.get(WriterVO.class,writerVO);
			session.delete(adminsBean);
			
			tx.commit();
			System.out.print("success delete");
		} catch(RuntimeException ex){
			tx.rollback();
			throw ex;
		} 
		count++;
		return count;
	}

	@Override
	public WriterVO selectOne(String writerVO) {
		try{
			tx = session.beginTransaction();
			
			WriterVO writerBean = (WriterVO)session.get(WriterVO.class,writerVO);
			System.out.println("WriterAccount: "+writerBean.getWriterAccount() +", ");
			System.out.println("Password: "+writerBean.getPassword() + ", ");
			System.out.println("Name: "+writerBean.getName() + ", ");
			System.out.println("Email: "+writerBean.getEmail() + ", ");
			System.out.println("Phone: "+writerBean.getPhone() + ", ");
			System.out.println("Address: "+writerBean.getAddress()+ ", ");
			System.out.println("Status: "+writerBean.getStatus());
			System.out.println(" ");
			
			tx.commit();
		} catch(RuntimeException ex){
			tx.rollback();
			throw ex;
		} 
		return null;
	}

	@Override
	public List<WriterVO> selectAll() {
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT); 
			List<WriterVO> list = query.list();
			for (WriterVO aWriter : list) {
				System.out.print(aWriter.getWriterAccount() + ", ");
				System.out.print(aWriter.getPassword() + ", ");
				System.out.print(aWriter.getName()+ ", ");
				System.out.print(aWriter.getEmail() + ", ");
				System.out.print(aWriter.getPhone() + ", ");
				System.out.print(aWriter.getAddress() + ", ");
				System.out.println(aWriter.getStatus());
			}
			
			tx.commit();
		} catch(RuntimeException ex){
			tx.rollback();
			throw ex;
		} 

		return null;
	}
	
}
