package iii.runninglife.model.sporthistorypath;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Entity 
@Table(name = "sportHistoryPath") 
public class SportHistoryPathVO implements java.io.Serializable {
	
	@EmbeddedId	
	private SportHistoryPathPK sportHistoryPathPK;
	private String path;

	public SportHistoryPathVO() {
	}

	public SportHistoryPathPK getSportHistoryPathPK() {
		return sportHistoryPathPK;
	}

	public void setSportHistoryPathPK(SportHistoryPathPK sportHistoryPathPK) {
		this.sportHistoryPathPK = sportHistoryPathPK;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public String toJson(){
		List<PathVO> pathList = new Gson().fromJson(path, new TypeToken<List<PathVO>>(){}.getType());
		StringBuilder points = new StringBuilder();
		
		for(PathVO path:pathList){
			if(points.length()>0)
				points.append(",");
			points.append("{lat: " + path.getLat() + ", lng: " + path.getLng() + "}");
		}

//		    {lat: -18.142, lng: 178.431},
//		    {lat: -27.467, lng: 153.027}

		return points.toString();
	}
	
	@Override
	public String toString(){
		List<PathVO> pathList = new Gson().fromJson(path, new TypeToken<List<PathVO>>(){}.getType());
		StringBuilder points = new StringBuilder();
		
		Iterator<PathVO> iterator = pathList.iterator();
		if(iterator.hasNext()){
			PathVO path = iterator.next();
			points.append(path.getLat() + ":" + path.getLng());
			
			while(iterator.hasNext()){
				path = iterator.next();
				points.append("-" + path.getLat() + ":" + path.getLng());
			}
		}

		return points.toString();
	}
 
	
}
