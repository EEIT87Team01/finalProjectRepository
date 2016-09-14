package iii.runninglife._01.model.writer;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface WriterInterface {
	public void insert(WriterVO writerVO);
	public void update(WriterVO writerVO);
	public void delete(String writerVO);
	public WriterVO selectOne(String writerVO);
	public List<WriterVO> selectAll();
}
