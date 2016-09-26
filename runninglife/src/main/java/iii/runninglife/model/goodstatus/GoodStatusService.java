package iii.runninglife.model.goodstatus;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iii.runninglife.globalservice.GlobalService;
@Service
public class GoodStatusService {
	@Autowired
	GlobalService glovbalService;
	@Autowired
	private GoodStatusDAO_interface goodStatusDAO;
	
	static GoodStatusVO goodStatusVO = new GoodStatusVO();
	static GoodStatusPK goodStatusPK = new GoodStatusPK();
	
	
	public void insert(GoodStatusVO goodStatusVO) {
		goodStatusDAO.insert(goodStatusVO);
	}
	
	public void update(GoodStatusVO goodStatusVO) {
		goodStatusDAO.update(goodStatusVO);
	}
	public void delete(GoodStatusVO goodStatusVO) {
		goodStatusDAO.delete(goodStatusVO);
	}
	public GoodStatusVO findByPrimaryKey(GoodStatusPK goodStatusPK){
		return goodStatusDAO.findByPrimaryKey(goodStatusPK);
	}
	public Long goodCount(String postID) {
		return goodStatusDAO.goodCount(postID);
	}
}
