package com.Guru99Bank.utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	

	Workbook  book;
	Sheet sheet;
	int totalRows;
	int totalColumns;
	Row row;
	Cell rowCell,columCell;
	String key,vaule;
	
	Map<String,String> map=new HashMap<String,String>();  
	
	
	
	public ReadDataFromExcel() {
		try {
			//String path=System.getProperty("user.dir")+"src\\test\\resources\\inputDatas.xlsx";
			book=new XSSFWorkbook(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/inputDatas.xlsx"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Map<String, String> customerDetails() {
		try {
			sheet = book.getSheetAt(0);
			totalRows = sheet.getLastRowNum();
			System.out.println("totla rows : "+totalRows);
			for (int i = 0; i <=totalRows; i++) {
				row = sheet.getRow(i);
				rowCell = row.getCell(0);
				columCell = row.getCell(1);
				String key = rowCell.getStringCellValue();
				String value = null;
				

				if (columCell.getCellType() == CellType.STRING) {
					value = columCell.getStringCellValue();
				} else {
					value = NumberToTextConverter.toText(columCell.getNumericCellValue());
				}
				//System.out.println(" cell Key :" + key+ " cell Value :" + value);
				map.put(key, value);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

}
