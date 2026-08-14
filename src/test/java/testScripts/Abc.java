package testScripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Abc {
	@Test(dataProvider ="testData")
	public void dataDriven(String firstName,String lastName, String pin) {
		System.out.println(firstName+lastName+pin);
	}
	@DataProvider(name="testData")
	public Object[][] getDatadrivenValue() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("D:\\Selenium\\OracleSwagLabs\\userData.xlsx");
		DataFormatter format = new DataFormatter();
		Workbook book = WorkbookFactory.create(fis);
//		Sheet sh =book.getSheetAt(0);
		Sheet sh = book.getSheet("AppData");
		int rowCount=sh.getPhysicalNumberOfRows();
		Row firstRow=sh.getRow(0);
		int colCount=firstRow.getLastCellNum();
		Object data[][]=new Object[rowCount-1][colCount];
		for(int i=0;i<rowCount-1;i++) {
			firstRow=sh.getRow(i+1);
			for(int j=0;j<colCount;j++) {
				Cell cell=firstRow.getCell(j);
				data[i][j]=format.formatCellValue(cell);
			}
		}
		return data;
}
	}
