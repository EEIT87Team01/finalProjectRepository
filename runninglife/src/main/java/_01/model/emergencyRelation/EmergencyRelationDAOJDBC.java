package _01.model.emergencyRelation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmergencyRelationDAOJDBC implements EmergencyRelationInterface{

	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=RunningLife";
	String userid = "sa";
	String passwd = "P@ssw0rd";
	
	private static final String INSERT_STMT =
				"INSERT INTO emergencyRelation VALUES(?,?)";
	
	private static final String UPDATE_STMT =
			"UPDATE emergencyRelation set "
					+ "where relationID = ?";

	private static final String DELETE_STMT = "DELETE FROM emergencyRelation where relationID = ?";
	
	private static final String GET_ONE_STMT = "SELECT "
											 + " FROM emergencyRelation where relationID = ?";
	
	private static final String GET_ALL_STMT = "SELECT "
											 + "FROM emergencyRelation";
	@Override
	public int insert(EmergencyRelationVO emergencyRelationVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = DriverManager.getConnection(url, userid, passwd);
			pstmt = conn.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, emergencyRelationVO.getRelationID());
			pstmt.setString(1, emergencyRelationVO.getRelationName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public int update(EmergencyRelationVO emergencyRelationVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int emergencyRelationVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EmergencyRelationVO selectOne(int emergencyRelationVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmergencyRelationVO> selectAll(EmergencyRelationVO emergencyRelationVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
