package iii.runninglife._01.model.location;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LocationInterface {
	public void insert(LocationVO locationVO);
	public void update(LocationVO locationVO);
	public void delete(LocationPK locationPK);
	public LocationVO selectOne(LocationPK locationPK);
	public List<LocationVO> selectAll(LocationVO locationVO);
}

