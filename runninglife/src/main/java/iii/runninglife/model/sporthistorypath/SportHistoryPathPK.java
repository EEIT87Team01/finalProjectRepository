package iii.runninglife.model.sporthistorypath;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import iii.runninglife.model.sporthistory.SportHistoryVO;

@Embeddable
public class SportHistoryPathPK implements Serializable {

	@ManyToOne
	@JoinColumn(name = "recordID")
	private SportHistoryVO sportHistoryVO;
	private int seq;

	// import getter(), setter(), equals(), hashCode()
	// right click/source/(generate getter() and setter() / generate equals()
	// and hashCode())
	
	public SportHistoryVO getSportHistoryVO() {
		return sportHistoryVO;
	}

	public void setSportHistoryVO(SportHistoryVO sportHistoryVO) {
		this.sportHistoryVO = sportHistoryVO;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sportHistoryVO == null) ? 0 : sportHistoryVO.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SportHistoryPathPK))
			return false;
		SportHistoryPathPK other = (SportHistoryPathPK) obj;
		if (sportHistoryVO == null) {
			if (other.sportHistoryVO != null)
				return false;
		} else if (!sportHistoryVO.equals(other.sportHistoryVO))
			return false;
		return true;
	}
}
