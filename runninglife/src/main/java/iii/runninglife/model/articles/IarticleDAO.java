package iii.runninglife.model.articles;


import java.sql.SQLException;
import java.util.*;

public interface IarticleDAO {
//	public void insert(String writerAccount,Clob content,String title,String photoPath,java.sql.Timestamp createTime,String status,int good);
	public void insert(String writerAccount,String content,String title,String photoPath,String status,int good);
	public void update(ArticlesVO articlesVO);
//	public void delete(String adID);
	public ArticlesVO findByPrimaryKey(String adID);
	public List<ArticlesVO> getAll();
	public List<ArticlesVO> findByWriter(String writerAccount);
	public void changeStatus(int articleID,String status);
//	public String countDateAd(String adTime);
} // end of class IEmpDAO