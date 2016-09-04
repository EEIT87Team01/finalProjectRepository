package _05service.photo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class Photo {

	public static void main(String[] args) {
		String filename = "c:/Run1/1.jpg";
		File file = new File(filename);
		Photo test = new Photo();
		test.writeToDisk(file);
//		for (int i = 0; i < 5; i++) {
//			try {
//
//				// 將檔案透過imageio轉成byte
//				String filename = "c:/Run/IMAGE_2.jpg";
//				BufferedImage img = ImageIO.read(new File(filename));
//				ByteArrayOutputStream bos = new ByteArrayOutputStream();
//
//				ImageIO.write(img, "jpg", bos);
//				byte[] imageBytes = bos.toByteArray();
//				bos.close();
//
//				// 將byte執行編碼
//				String imageString = Base64.encodeBase64String(imageBytes);
//
//				// 印出編碼結果
//				System.out.println("length=" + imageString.length());
//				System.out.println("string=" + imageString);
//
//				//產生檔案名稱
//				SimpleDateFormat sdf = new SimpleDateFormat("yyDDDssmmSSSS");
//				Date date=new Date(System.currentTimeMillis());
//				String pictureName=sdf.format(date)+".jpg";
//				
//				// 再將編碼後的字串轉成圖檔
//				String path = "c:/Run/";
//				BufferedImage bufferedImage = null;
//				byte[] imageByte = Base64.decodeBase64(imageString);
//				ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
//				bufferedImage = ImageIO.read(bis);
//				bis.close();
//
//				ImageIO.write(bufferedImage, "jpg", new File(path+pictureName));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}
	public String writeToDisk(Object photo){
		try {
			// 將檔案透過imageio轉成byte
			ImageInputStream iis = ImageIO.createImageInputStream(photo);
			BufferedImage img = ImageIO.read(iis);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			ImageIO.write(img, "jpg", bos);
			byte[] imageBytes = bos.toByteArray();
			bos.close();

			// 將byte執行編碼
			String imageString = Base64.encodeBase64String(imageBytes);

			// 印出編碼結果
			System.out.println("length=" + imageString.length());
//			System.out.println("string=" + imageString);

			//產生檔案名稱
			SimpleDateFormat sdf = new SimpleDateFormat("yyDDDssmmSSSS");
			Date date=new Date(System.currentTimeMillis());
			String pictureName=sdf.format(date)+".jpg";
			
			// 再將編碼後的字串轉成圖檔
			File path =new File("c:/run");
			if(!path.exists()){
				if(path.mkdirs()){
					System.out.println("資料夾建立成功!");
				}else{
					System.out.println("資料夾建立失敗!");
				}
			}
			BufferedImage bufferedImage = null;
			byte[] imageByte = Base64.decodeBase64(imageString);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
			bufferedImage = ImageIO.read(bis);
			bis.close();
			ImageIO.write(bufferedImage, "jpg", new File(path+"/"+pictureName));
			return pictureName;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "fail";
		
	}
	public String readFromDisk(String photoPath){

		try {
			String filename = photoPath;
			BufferedImage img;
			img = ImageIO.read(new File(filename));
			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			ImageIO.write(img, "jpg", bos);
			byte[] imageBytes = bos.toByteArray();
			bos.close();

			// 將byte執行編碼
			String photoString = Base64.encodeBase64String(imageBytes);

			// 印出編碼結果
			System.out.println("length=" + photoString.length());
			System.out.println("string=" + photoString);
			return photoString;
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
		return "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";
	}
}
