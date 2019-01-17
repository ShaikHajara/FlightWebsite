package com.automate.flight.utility;

import org.testng.annotations.Test;

public class GetValues {

	@Test
	public void get() {
		int i;
		int j;
		Object[][] data;
		data = ReadExcelAndSetValues.getData();

		for (i = 0; i < 1; i++) {
			for (j = 0; j < 1; j++) {

				System.out.println("Data from object is " + data[i][j]);

			}
		}

		final ReadExcelAndSetValues readExcel = new ReadExcelAndSetValues();
		System.out.println("Address 1 is : " + readExcel.setGetValues().getAddress1());

	}

}
