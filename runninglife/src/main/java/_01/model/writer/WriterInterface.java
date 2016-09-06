package _01.model.writer;

import java.util.List;

public interface WriterInterface {
	public int insert(WriterVO writerVO);
	public int update(WriterVO writerVO);
	public int delete(String writerVO);
	public WriterVO selectOne(String writerVO);
	public List<WriterVO> selectAll();
}
