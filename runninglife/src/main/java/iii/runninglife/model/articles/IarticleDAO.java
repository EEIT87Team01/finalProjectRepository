package iii.runninglife.model.articles;


import java.util.*;

import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface IarticleDAO {
	public void insert(String writerAccount,String content,String title,String photoPath);
	public void update(ArticlesVO articlesVO);
	public ArticlesVO findByPrimaryKey(String adID);
	public List<ArticlesVO> getAll();
	public List<ArticlesVO> findByWriter(String writerAccount);
	public void changeStatus(int articleID,String status);
} // end of class IEmpDAO