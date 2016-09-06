package _01.model.location;

import java.util.List;

public interface LocationInterface {
	public void insert(LocationVO locationVO);
	public int update(LocationVO locationVO);
	public int delete(LocationPK locationPK);
	public LocationVO selectOne(LocationPK locationPK);
	public List<LocationVO> selectAll(LocationVO locationVO);
}

