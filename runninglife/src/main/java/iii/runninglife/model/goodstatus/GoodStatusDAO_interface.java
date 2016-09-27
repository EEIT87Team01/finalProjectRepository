package iii.runninglife.model.goodstatus;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GoodStatusDAO_interface {
    public void insert(GoodStatusVO goodStatusVO);
    public void update(GoodStatusVO goodStatusVO);
    public void delete(GoodStatusVO goodStatusVO);
    public GoodStatusVO findByPrimaryKey(GoodStatusPK goodStatusPK);
    public List<GoodStatusVO> getAll();
    public Long goodCount(String postID);
}
