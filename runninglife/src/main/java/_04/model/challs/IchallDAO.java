package _04.model.challs;

import java.sql.SQLException;
import java.util.*;

public interface IchallDAO {
	public void insert(ChallsVO chall) throws SQLException;
	public void delete(String challenID) throws SQLException;
	public ChallsVO findByPrimaryKey(String challenID) throws SQLException;
	public List<ChallsVO> getAll() throws SQLException;
	public String countDateChallenge(String challenDate) throws SQLException;
} // end of class IEmpDAO