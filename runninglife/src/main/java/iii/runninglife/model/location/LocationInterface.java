package iii.runninglife.model.location;

import java.util.List;

public interface LocationInterface {
	public void insert(LocationVO locationVO);
	public void update(LocationVO locationVO);
	public void delete(LocationPK locationPK);
	public LocationVO selectOne(LocationPK locationPK);
	public List<LocationVO> selectAll(String cityID);
}

