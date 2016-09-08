package _04.model.ads;

import java.sql.SQLException;
import java.util.*;

public interface IadDAO {
	public void insert(AdVO ad) throws SQLException;
	public void update(AdVO ad) throws SQLException;
	public void delete(String adID) throws SQLException;
	public AdVO findByPrimaryKey(String adID) throws SQLException;
	public List<AdVO> getAll() throws SQLException;
	public String countDateAd(String adTime) throws SQLException;
} // end of class IEmpDAO