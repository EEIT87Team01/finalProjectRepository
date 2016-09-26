package iii.runninglife.model.adsClick;

import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IadClickDAO {
	public void insert(AdsClickVO ad);
	public void update(AdsClickVO ad);
	public AdsClickVO findByPrimaryKey(AdsClickPK adsClick_PK);
	public List<AdsClickVO> getAll();
	public List<AdsClickVO> findByTimeRange(String adID, Date startTime, Date endTime);
} // end of class IEmpDAO