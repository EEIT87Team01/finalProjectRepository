package iii.runninglife.globalservice;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class GlobalService {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public GlobalService(){super();}
	public GlobalService(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	
	public String findMaxSeq(String clumeName , Object tableName) {
		int seqLen = 8;
		String queryResult = (String) sessionFactory.getCurrentSession().createCriteria(tableName.getClass())
				.setProjection(Projections.max(clumeName)).uniqueResult();
		
		Date date  =new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateString = sdf.format(date);
		String MaxValue = String.valueOf(Long.parseLong(queryResult)+1);
		String MaxSeq = dateString + MaxValue.substring(seqLen);
		System.out.println(MaxSeq);
		
		return MaxSeq;
	}
	
	//ChangeMD5
	public byte[] changeMD5Encoding(String password){
//		String regex = "^.*(?=.{6,})(?=.[a-z])";
		//java.security.MessageDigest
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(password!=null && password.length()!=0) {
			byte[] temp = password.getBytes();	//明碼  //使用者輸入byte[]
			temp = md.digest(temp); 		//亂碼
			return temp;
		}else{
			return null;
		}
	}
	
	//轉型
	public String encodeStr(String str){
		try{
		return new String(str.getBytes("ISO-8859-1"),"UTF-8");
		}catch (UnsupportedEncodingException e){
			e.printStackTrace();
			return null;
		}
	}
	
	//FileConverter
	public File isToFile(byte[] isString){
		File f = new File("");
		
		try {
			InputStream is = new ByteArrayInputStream(isString);
			OutputStream out = new FileOutputStream(f);
			
			byte[] br = new byte[4 * 1024];
			int len = 0;
			while((len = is.read(br)) != -1){
				out.write(br, 0, len);
			}
			
			out.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return f;
	}
}