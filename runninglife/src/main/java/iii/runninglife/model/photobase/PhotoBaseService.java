package iii.runninglife.model.photobase;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iii.runninglife.globalservice.GlobalService;
import iii.runninglife.model.members.MembersInterface;
import iii.runninglife.model.members.MembersVO;

@Service
public class PhotoBaseService {

	@Autowired
	GlobalService glovbalService;

	PhotoBaseVO photoBaseVO = new PhotoBaseVO();
	MembersVO membersVO = new MembersVO();
	
	@Autowired
	MembersInterface membersInterface;
	
	@Autowired
	private PhotoBaseDAO_interface photoBaseDAO;

	public String newPhoto(String imgPath) {
		String photoID = glovbalService.findMaxSeq("photoID", new PhotoBaseVO());
		System.out.println(photoID+"11111111111111111111111111111111111111111111111");
		photoBaseVO = new PhotoBaseVO();
		photoBaseVO.setPhotoID(photoID);
		photoBaseVO.setImgPath(imgPath);
		photoBaseDAO.insert(photoBaseVO);
		return photoID;
	}

	public byte[] getPhoto(String photoID, OutputStream out) throws IOException {
		photoBaseVO = photoBaseDAO.findByPrimaryKey(photoID);
		File f = new File(photoBaseVO.getImgPath());
		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(out);
		byte[] buffer = null;
		try {
			buffer = new byte[1024];
			int len = 0;
			while ((len = bis.read(buffer)) > -1)
				bos.write(buffer, 0, len);
		} finally {
			fis.close();
			out.close();
			bis.close();
			bos.close();
		}
		return buffer;
	}

	public String getPhotoBase64FromPath(String photoPath) throws IOException {
		File f = new File(photoPath);
		String encodedfile = null;
		try {
			FileInputStream fileInputStreamReader = new FileInputStream(f);
			byte[] bytes = new byte[(int) f.length()];
			fileInputStreamReader.read(bytes);
			encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return encodedfile;
	}
	public MembersVO getPostData(String postID) {
		return membersVO = membersInterface.selectOne(postID);
	}
}