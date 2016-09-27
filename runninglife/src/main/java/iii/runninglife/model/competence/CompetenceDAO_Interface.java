package iii.runninglife.model.competence;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CompetenceDAO_Interface {
	
	    public void insert(CompetenceVO competenceVO);
	    public void update(CompetenceVO competenceVO);
	    public void delete(Integer competenceID);
	    public CompetenceVO findByPrimaryKey(Integer competenceID);
	    public List<CompetenceVO> getAll();

}
