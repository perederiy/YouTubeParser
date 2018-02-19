package service;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class FileOExel {
	
	public static final String PATH = System.getProperty("user.dir") + System.getProperty("file.separator") +"parsing.hls";

	public static void saveExelFile(HSSFWorkbook workbook) {
		
		FileOutputStream out = null;
		
		try {
			out = new FileOutputStream(PATH, true);
			workbook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
