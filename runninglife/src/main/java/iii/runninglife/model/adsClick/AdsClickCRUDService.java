package iii.runninglife.model.adsClick;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdsClickCRUDService {
	
	@Autowired
	IadClickDAO adClickDAO;

	public void insertService(String adID){
		Date d=new Date(System.currentTimeMillis());
		AdsClickVO addadClick = new AdsClickVO(setPKService(adID,d),0);
		adClickDAO.insert(addadClick);
	}
	public void updateService(String adID){
		Date d=new Date(System.currentTimeMillis());
		AdsClickPK adsClick_PK = setPKService(adID,d);
		AdsClickVO adsClickVO = searchOneService(adsClick_PK);
		adClickDAO.update(new AdsClickVO(adsClick_PK,(adsClickVO.getCountClick()+1)));
	}
	
	public AdsClickVO searchOneService(AdsClickPK adsClick_PK){
		return adClickDAO.findByPrimaryKey(adsClick_PK);
	}
	public List<AdsClickVO> searchAllService(){
		List<AdsClickVO> adList = adClickDAO.getAll();
		return adList;
	}
	
	public AdsClickPK setPKService(String adID,java.sql.Date clickDay){
		return new AdsClickPK(adID,clickDay);
	}
}
