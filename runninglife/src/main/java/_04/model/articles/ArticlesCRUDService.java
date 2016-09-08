package _04.model.articles;

import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;

public class ArticlesCRUDService {

	public static void main(String[] args) {
        
	}
	public int insertService(String writerAccount,String content,String title,String photoPath,java.sql.Timestamp createTime,String status,int good){
		IarticleDAO dao=new ArticlesDAO();
		try {
			dao.insert(writerAccount,content,title,photoPath,status,good);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int updateService(int ArticleID,String writerAccount,Clob content,String title,String photoPath,java.sql.Timestamp createTime,String status,int good){
		IarticleDAO dao=new ArticlesDAO();
		try {
			ArticlesVO updateArticle=new ArticlesVO(ArticleID,writerAccount,content,title,photoPath,createTime,status,good);
			dao.update(updateArticle);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
//	public int deleteService(String ArticleID){
//		IarticleDAO dao=new ArticlesDAO();
//		try {
//			dao.delete(ArticleID);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}
	public ArticlesVO searchOneService(String ArticleID){
		IarticleDAO dao=new ArticlesDAO();
		try {
			ArticlesVO findAd=dao.findByPrimaryKey(ArticleID);
			return findAd;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<ArticlesVO> searchAllService(){
		IarticleDAO dao=new ArticlesDAO();
		try {
			List<ArticlesVO> adList=dao.getAll();
			return adList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<ArticlesVO> searchWriterService(String writerAccount){
		List<ArticlesVO> challDataList = null;
		IarticleDAO dao=new ArticlesDAO();
		try {
			challDataList=dao.findByWriter(writerAccount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
