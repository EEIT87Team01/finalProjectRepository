package iii.runninglife.model.writer;

import java.util.List;

public interface WriterInterface {
	public void insert(WriterVO writerVO);
	public void update(WriterVO writerVO);
	public void delete(String writerVO);
	public WriterVO selectOne(String writerVO);
	public List<WriterVO> selectAll();
}
