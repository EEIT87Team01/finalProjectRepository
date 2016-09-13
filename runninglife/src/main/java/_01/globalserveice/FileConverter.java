package _01.globalserveice;

import java.io.*;

public class FileConverter {
	static public File isToFile(byte[] isString){
		File f = new File("");
		
		try {
			InputStream is = new ByteArrayInputStream(isString);
			OutputStream out = new FileOutputStream(f);
			
			byte[] br = new byte[4 * 1024];
			int len = 0;
			while((len = is.read(br)) != -1){
				out.write(br, 0, len);
			}
			
			out.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return f;
	}
}
