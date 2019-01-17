package com.automate.flight.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow xssfRow;
	public static XSSFRow xssfRow0;
	public static FileInputStream fis;
	public static File filePath;
	public static int rowCount;
	public static int colCount;
	public static Object data[][];

	public static Object gettingData[][];

	public static String getCellData(XSSFCell cell) {
		Object result = null;
		try {
			final CellType type = cell.getCellType();
			if (type == CellType.STRING) {
				System.out.println("[" + cell.getRowIndex() + ", " + cell.getColumnIndex() + "] = STRING; Value = "
						+ cell.getStringCellValue());
				result = cell.getStringCellValue();
				System.out.println("Result" + result);
			} else if (type == CellType.NUMERIC) {
				if (DateUtil.isCellDateFormatted(cell)) {
					System.out.println("[" + cell.getRowIndex() + ", " + cell.getColumnIndex() + "] = Date; Value = "
							+ cell.getDateCellValue());
					result = cell.getDateCellValue();
				} else {
					System.out.println("[" + cell.getRowIndex() + ", " + cell.getColumnIndex() + "] = NUMERIC; Value = "
							+ cell.getNumericCellValue());
					result = cell.getNumericCellValue();
				}

			} else if (type == CellType.BOOLEAN) {
				System.out.println("[" + cell.getRowIndex() + ", " + cell.getColumnIndex() + "] = BOOLEAN; Value = "
						+ cell.getBooleanCellValue());
				result = cell.getBooleanCellValue();
			} else if (type == CellType.BLANK) {
				System.out.println("[" + cell.getRowIndex() + ", " + cell.getColumnIndex() + "] = BLANK CELL");
				result = "";
			}
		} catch (final Exception e) {
			e.printStackTrace();
			return "row " + cell.getRowIndex() + " or column " + cell.getColumnIndex() + " does not exist in xls";
		}
		return result.toString();
	}

	public static int getColumnCount(String sheetName, String path) {
		sheet = workbook.getSheet(sheetName);
		colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(colCount);
		return colCount;
	}

//	@DataProvider(name = "getData")
	public static Object[][] getExcelData() {

		final String sheetName = "Sheet1";
		final File excelPathFromResources = new File("src/main/resources/excelfiles/Register.xlsx");
		final String path = excelPathFromResources.getAbsolutePath();
		System.out.println(path);

		filePath = new File(path);
		try {
			fis = new FileInputStream(filePath);
		} catch (final FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final int totalRows = getRowCount(sheetName, path);
		final int totalColumns = getColumnCount(sheetName, path);
		data = new Object[totalRows - 1][totalColumns - 1];
		for (int i = 1; i < totalRows; i++) {
			for (int j = 0; j < totalColumns - 1; j++) {

				xssfRow = sheet.getRow(i);
				final XSSFCell cell = xssfRow.getCell(j);
				final String value = getCellData(cell);
				System.out.println(value);

				data[0][j] = value;
			}
		}
		try {
			fis.close();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public static int getRowCount(String sheetName, String path) {
		sheet = workbook.getSheet(sheetName);
		rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		return rowCount;
	}

	public XSSFCell cell;

}
