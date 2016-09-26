package iii.runninglife.model.photobase;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PhotoBaseDAO_interface {
    public void insert(PhotoBaseVO photoBaseVO);
    public void update(PhotoBaseVO photoBaseVO);
    public void delete(String photoID);
    public PhotoBaseVO findByPrimaryKey(String photoID);
    public List<PhotoBaseVO> getAll();
}
//test all ok save20160904