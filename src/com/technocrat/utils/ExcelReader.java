package com.technocrat.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class ExcelReader {

	public static void main(String[] args) throws Exception {
		FileInputStream file = new FileInputStream("D:\\TestData\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Customer");

		ArrayList list = new ArrayList();

		/*for(int i= 0; i<sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);

			for(int j = 0; j<row.getPhysicalNumberOfCells();j++) {
				Cell cell = row.getCell(j);

				list.add(cell);
			}
		}*/

		/*
		Iterator rowItr = sheet.rowIterator();
		while(rowItr.hasNext()) {
			Row row = (Row)rowItr.next();
			Iterator cellItr = row.cellIterator();
			while(cellItr.hasNext()) {
				Cell cell = (Cell)cellItr.next();
				list.add(cell);
			}
		}*/


		Iterator rowItr = sheet.rowIterator();

		while(rowItr.hasNext()) {
			Row row = (Row) rowItr.next();
			Iterator cellItr = row.cellIterator();
			while(cellItr.hasNext()) {
				Cell cell = (Cell)cellItr.next();
				try {
					if(cell.getCellType() == CellType.FORMULA) {
						switch(cell.getCachedFormulaResultType()) {
						case STRING:
						case FORMULA:	
						case BOOLEAN:
							list.add(cell.getRichStringCellValue().toString());
							break;
						case NUMERIC:
						case BLANK:
							list.add(cell.getNumericCellValue());
							break;

						default:
							break;
						}     
					}	else {
						list.add(cell);
					}
				}							
				catch(NullPointerException e) {
					e.printStackTrace();
				}
			}
		}


		//System.out.println(list);
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}




	}
}
