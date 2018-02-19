package service;

import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import model.Orators;

public class ServiceExel {
	
public static HSSFWorkbook SearchOrators(ArrayList <Orators>list) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Pages YouTube");
		
		int coll = 0;
		Row row;
		Cell cell;
		
		row = sheet.createRow(coll);
		
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("Name");
		
		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Name orators");
		
		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("URL");
		
		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Description");
		
		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Date of registration");
		
		for (Orators orators : list) {
			coll++;
			row = sheet.createRow(coll);
			
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(orators.getName());
			
			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(orators.getNameOrators());
			
			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(orators.getUrl());
			
			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(orators.getDescription());
			
			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue(orators.getDate());
			
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(4);
		}
		
		
		return workbook;
	}
}
