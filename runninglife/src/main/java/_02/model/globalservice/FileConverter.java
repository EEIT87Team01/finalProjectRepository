package _02.model.globalservice;

import java.io.*;

public class FileConverter {

	static public File isToFile(byte[] isString, String memberID) {
		File f = new File("C:\\Project\\Project_friend\\WebContent\\images", memberID + ".png");
		try {
			InputStream is = new ByteArrayInputStream(isString);
			OutputStream out = new FileOutputStream(f);

			byte[] buffer = new byte[4 * 1024];
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}

			out.close();
			is.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error while converting...");
		}

		return f;
	}

}
