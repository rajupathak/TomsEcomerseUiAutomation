package com.toms.qa.util;

import java.util.ArrayList;

public class ExcelReaderUtility {
	static Xls_Reader reader;

	public static ArrayList<Object[]> getDatafromExcel() {

		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		try {
			reader = new Xls_Reader("File");

		} catch (Exception e) {
			e.printStackTrace();

		}

		for (int rowNum = 2; rowNum <= reader.getRowCount("SheetName"); rowNum++) {

			String firstName = reader.getCellData("", "", rowNum);
			String lastName = reader.getCellData("", "", rowNum);
			Object[] obj = { firstName, lastName };
			myData.add(obj);

		}
		return myData;

	}
}
