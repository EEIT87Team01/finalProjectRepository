package _04.model.members;

import java.sql.SQLException;
import java.util.*;

public interface ImembersDAO {
//	public void getConnection() throws SQLException;
	public void insert(MembersVO members) throws SQLException;
	public void update(MembersVO members) throws SQLException;
	public void delete(String membersID) throws SQLException;
	public MembersVO findByPrimaryKey(String membersID) throws SQLException;
	public List<MembersVO> getAll() throws SQLException;
//	public void closeConn() throws SQLException;
//	public int countDateChallenge(String challenDate) throws SQLException;
} // end of class IEmpDAO