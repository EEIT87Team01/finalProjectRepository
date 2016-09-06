package _01.model.competence;

import java.util.List;

public interface CompetenceInterface {
	public int insert(CompetenceVO competenceVO);
	public int update(CompetenceVO competenceVO);
	public int delete(String competenceVO);
	public CompetenceVO selectOne(int competenceVO);
	public List<CompetenceVO> selectAll();
}
