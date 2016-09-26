package iii.runninglife.model.photobase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iii.runninglife.globalservice.GlobalService;
import iii.runninglife.model.members.MembersVO;

@Service
public class PhotoBaseService {
	
	@Autowired
	GlobalService glovbalService;
	
	PhotoBaseVO photoBaseVO = new PhotoBaseVO();
	MembersVO memberVO = new MembersVO();
	
	@Autowired
	private PhotoBaseDAO_interface photoBaseDAO;

	public String newPhoto(String imgPath) {
		String photoID = glovbalService.findMaxSeq("photoID", new PhotoBaseVO());
		photoBaseVO.setPhotoID(photoID);
		photoBaseVO.setImgPath(imgPath);
		photoBaseDAO.insert(photoBaseVO);
		
		return photoID;

	}

	public String getPhoto(String photoID) throws IOException {
		photoBaseVO.setPhotoID(photoID);
		photoBaseVO = photoBaseDAO.findByPrimaryKey(photoID);
		BufferedReader reader = null;
		StringBuffer sb = new StringBuffer();
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(photoBaseVO.getImgPath()), "UTF-8")); // 指定讀取文件的編碼格式，以免出現中文亂碼
		String str = null;
		while ((str = reader.readLine()) != null) {
			sb.append(str);
		}
		reader.close();
		return sb.toString();
	}

	public String getTestPhoto(String photoID) throws IOException {
		photoBaseVO.setPhotoID(photoID);
		photoBaseVO=photoBaseDAO.findByPrimaryKey(photoID);
        File f =  new File(photoBaseVO.getImgPath());
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(f);
            byte[] bytes = new byte[(int)f.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return encodedfile;
	}
}
