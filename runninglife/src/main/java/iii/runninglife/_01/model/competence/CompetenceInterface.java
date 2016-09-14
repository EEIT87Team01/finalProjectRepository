package iii.runninglife._01.model.competence;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CompetenceInterface {
	public void insert(CompetenceVO competenceVO);
	public void update(CompetenceVO competenceVO);
	public void delete(String competenceVO);
	public CompetenceVO selectOne(int competenceVO);
	public List<CompetenceVO> selectAll();
}
