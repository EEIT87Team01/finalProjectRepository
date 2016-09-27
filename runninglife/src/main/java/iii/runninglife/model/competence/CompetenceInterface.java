package iii.runninglife.model.competence;

import java.util.List;

public interface CompetenceInterface {
	public void insert(CompetenceVO competenceVO);
	public void update(CompetenceVO competenceVO);
	public void delete(String competenceVO);
	public CompetenceVO selectOne(int competenceVO);
	public List<CompetenceVO> selectAll();
}
