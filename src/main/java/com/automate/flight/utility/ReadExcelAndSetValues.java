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

import com.automate.flight.registerpage.RegisterPageSetGetValues;

public class ReadExcelAndSetValues {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow xssfRow;
	public static XSSFRow xssfRow0;
	public static FileInputStream fis;
	public static File filePath;
	public static int rowCount;
	public static int colCount;

	public static Object gettingData[][];
	public static RegisterPageSetGetValues registerpage;

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
					result = String.valueOf((int) cell.getNumericCellValue());
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

	public static Object[][] getData() {

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
		System.out.println("total rows is" + totalRows);
		final int totalColumns = getColumnCount(sheetName, path);
		System.out.println("total columns is" + totalColumns);
		gettingData = new Object[totalRows - 1][totalColumns - 1];
		registerpage = new RegisterPageSetGetValues();
		for (int i = 0; i < totalRows - 1; i++) {
			for (int j = 0; j < totalColumns - 1; j++) {
				xssfRow0 = sheet.getRow(i);
				//
				final XSSFCell columnValue = xssfRow0.getCell(j);
				final String title = getCellData(columnValue);
				System.out.println(columnValue);

				xssfRow = sheet.getRow(1);
				final XSSFCell cell = xssfRow.getCell(j);
				final String value = getCellData(cell);
				System.out.println(value);

				if (!(columnValue.getCellType() == CellType.BLANK) || !(columnValue == null)) {
					switch (title) {
					case "FirstName":
						registerpage.setFirstName(value);
						System.out.println("Register get first name" + registerpage.getFirstName());
						break;
					case "lastName":
						registerpage.setLastName(value);
						System.out.println("Register get last name" + registerpage.getLastName());
						break;
					case "Phone":
						registerpage.setPhone(Integer.parseInt(value));
						System.out.println("Register phone" + registerpage.getPhone());
						break;
					case "Email":
						registerpage.setEmail(value);
						System.out.println("Register get email name" + registerpage.getEmail());
						break;
					case "Address1":
						registerpage.setAddress1(value);
						break;
					case "Address2":
						registerpage.setAddress2(value);
						break;
					case "City":
						registerpage.setCity(value);
						break;
					case "State":
						registerpage.setState(value);
						break;
					case "Postal Code":
						registerpage.setPostalCode(Integer.parseInt(value));
						break;
					case "Username":
						registerpage.setUsername(value);
						break;
					case "Password":
						registerpage.setPassword(value);
						break;
					case "Confirm Password":
						registerpage.setConfirmPassword(value);
						break;
					default:
						System.out.println("No matches found");
						break;
					}
				}
				System.out.println(registerpage);
				gettingData[0][0] = registerpage;

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
		System.out.println(registerpage.getAddress1());
		return gettingData;

	}

	public static int getRowCount(String sheetName, String path) {
		sheet = workbook.getSheet(sheetName);
		rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		return rowCount;
	}

	public XSSFCell cell;

	public RegisterPageSetGetValues setGetValues() {
		return registerpage;
	}

}
