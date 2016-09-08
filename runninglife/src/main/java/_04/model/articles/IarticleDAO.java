package _04.model.articles;


import java.sql.SQLException;
import java.util.*;

public interface IarticleDAO {
//	public void insert(String writerAccount,Clob content,String title,String photoPath,java.sql.Timestamp createTime,String status,int good) throws SQLException;
	public void insert(String writerAccount,String content,String title,String photoPath,String status,int good) throws SQLException;
	public void update(ArticlesVO articlesVO) throws SQLException;
//	public void delete(String adID) throws SQLException;
	public ArticlesVO findByPrimaryKey(String adID) throws SQLException;
	public List<ArticlesVO> getAll() throws SQLException;
	public List<ArticlesVO> findByWriter(String writerAccount) throws SQLException;
	public void changeStatus(int articleID,String status) throws SQLException;
//	public String countDateAd(String adTime) throws SQLException;
} // end of class IEmpDAO