package iii.runninglife.model.articles;

import java.io.Reader;
import java.sql.Clob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iii.runninglife.model.writer.WriterInterface;

@Service
public class ArticlesCRUDService {
	
	@Autowired
	IarticleDAO dao;
	@Autowired
	WriterInterface wdao;
	
	public void insertService(String writerAccount,String content,String title,String photoPath,java.sql.Timestamp createTime,String status,int good){
		dao.insert(writerAccount,content,title,photoPath,status,good);
	}
	public void updateService(int ArticleID,String writerAccount,Clob content,String title,String photoPath,java.sql.Timestamp createTime,String status,int good){
		ArticlesVO updateArticle=new ArticlesVO(ArticleID,wdao.selectOne(writerAccount),content,title,photoPath,createTime,status,good);
		dao.update(updateArticle);
	}
	public ArticlesVO searchOneService(String ArticleID){
		ArticlesVO findAd=dao.findByPrimaryKey(ArticleID);
		return findAd;
	}
	public List<ArticlesVO> searchAllService(){
		List<ArticlesVO> adList=dao.getAll();
		return adList;
	}
	public List<ArticlesVO> searchWriterService(String writerAccount){
		List<ArticlesVO> challDataList = null;
		challDataList=dao.findByWriter(writerAccount);
		return challDataList;
	}
	
	//string to clob 
	public static Clob stringToClob(String str) {
	    if (null == str)
	        return null;
	    else {
	        try {
	            java.sql.Clob c = new javax.sql.rowset.serial.SerialClob(str
	                    .toCharArray());
	            return c;
	        } catch (Exception e) {
	            return null;
	        }
	    }
	}
	 
	//clob to string
	public static String clobToString(Clob clob) {
	    if (clob == null)
	        return null;
	 
	    StringBuffer sb = new StringBuffer(65535);// 64K
	    Reader clobStream = null;
	    try {
	        clobStream = clob.getCharacterStream();
	        char[] b = new char[60000];// 每次獲取60K
	        int i = 0;
	        while ((i = clobStream.read(b)) != -1) {
	            sb.append(b, 0, i);
	        }
	    } catch (Exception ex) {
	        sb = null;
	    } finally {
	        try {
	            if (clobStream != null) {
	                clobStream.close();
	            }
	        } catch (Exception e) {
	        }
	    }
	    if (sb == null)
	        return null;
	    else
	        return sb.toString();
	}
	
}
