package iii.runninglife.model.sporthistorypath;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iii.runninglife.model.sporthistory.SportHistoryService;
import iii.runninglife.model.sporthistory.SportHistoryVO;

@Service
public class SportHistoryPathService{
	@Autowired
	private SportHistoryPathDAO_interface dao;
	@Autowired
	private SportHistoryService sportHistoryService ;
	
	public void batchUpdateSportHistoryPath(String memberID,
									   String path) {
		
		String currentRecordID = null; 
		if((currentRecordID = sportHistoryService.getMemberCurrentRecordID(memberID))!=null){
			
			SportHistoryPathVO sportHistoryPathVO = new SportHistoryPathVO();
			SportHistoryPathPK sportHistoryPathPK = new SportHistoryPathPK();

			sportHistoryPathPK.setSportHistoryVO(sportHistoryService.getOneSportHistory(currentRecordID));
			sportHistoryPathPK.setSeq(dao.getNextSeqByRecordID(currentRecordID));
			sportHistoryPathVO.setSportHistoryPathPK(sportHistoryPathPK);
			sportHistoryPathVO.setPath(path);
			
			dao.insert(sportHistoryPathVO);
		}
	}

	//理論上用不到
	public void updateSportHistoryPath(String recordID,
									   int seq,
									   String path) {
		
		SportHistoryPathVO sportHistoryPathVO = null;
		sportHistoryPathVO = new SportHistoryPathService().getOneSportHistoryPath(recordID, seq);
		sportHistoryPathVO.setPath(path);
		dao.update(sportHistoryPathVO);
	}

	//理論上用不到
	public void deleteSportHistoryPath(String recordID,
									   int seq) {
	
		SportHistoryVO sportHistoryVO = new SportHistoryVO();
		SportHistoryPathPK sportHistoryPathPK = new SportHistoryPathPK();
		
		sportHistoryVO.setRecordID(recordID);
		sportHistoryPathPK.setSportHistoryVO(sportHistoryVO);
		sportHistoryPathPK.setSeq(seq);
		dao.delete(sportHistoryPathPK);
	}

	public SportHistoryPathVO getOneSportHistoryPath(String recordID,
			   										 int seq) {
		
		SportHistoryPathPK sportHistoryPathPK = new SportHistoryPathPK();
		sportHistoryPathPK.setSportHistoryVO(sportHistoryService.getOneSportHistory(recordID));
		sportHistoryPathPK.setSeq(seq);
	
		return dao.findByPrimaryKey(sportHistoryPathPK);
	}
	
	public List<SportHistoryPathVO> getSportHistoryPaths(String recordID) {
		return dao.getPathsByRecordID(recordID);
	}
	
	public List<SportHistoryPathVO> getPathsByRecordID(String recordID){
		return dao.getPathsByRecordID(recordID);
	}

	public List<SportHistoryPathVO> getAll() {
		return dao.getAll();
	}
}
