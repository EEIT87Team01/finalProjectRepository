package _04.model.chall_data;

import java.sql.SQLException;
import java.util.*;

public interface IchallDataDAO {
	public void insert(ChallDataVO challDataVO) throws SQLException;
	public void update(ChallDataVO challDataVO) throws SQLException;
	public void delete(Two_ID two_ID) throws SQLException;
	public ChallDataVO findByPrimaryKey(Two_ID two_ID) throws SQLException;
	public List<ChallDataVO> getAll() throws SQLException;
	public List<ChallDataVO> findByChall(String challenID) throws SQLException;
	public List<ChallDataVO> findByMember(String memberID) throws SQLException;
} // end of class IEmpDAO