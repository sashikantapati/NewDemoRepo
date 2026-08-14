package genericLab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataUtility {
	String url;
	String userName;
	String password;

	public Properties getProperties() throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\sashi\\eclipse-workspace\\SwagLabs\\src\\main\\java\\Properties");
		Properties pro = new Properties();
		pro.load(fis);
		url = pro.getProperty("URL");
		userName = pro.getProperty("userName");
		password = pro.getProperty("password");
		return pro;
	}

//	String firstName;
//	String lastName;
//	String pin;

	public String[] getTestData() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("D:\\Selenium\\OracleSwagLabs\\userData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("AppData");
		DataFormatter format = new DataFormatter();
		String firstName = format.formatCellValue(sh.getRow(1).getCell(0));
		String lastName = format.formatCellValue(sh.getRow(1).getCell(1));
		String pin = format.formatCellValue(sh.getRow(1).getCell(2));
		return new String[] { firstName, lastName, pin };
	}

	@DataProvider(name = "testData")
	public static Object[][] getDatadrivenValue() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("D:\\Selenium\\OracleSwagLabs\\userData.xlsx");
		DataFormatter format = new DataFormatter();
		Workbook book = WorkbookFactory.create(fis);
//		Sheet sh = book.getSheetAt(0);
		Sheet sh = book.getSheet("AppData");
		int rowCount = sh.getPhysicalNumberOfRows();
		Row firstRow = sh.getRow(0);
		int colCount = firstRow.getLastCellNum();
		Object data[][] = new Object[rowCount - 1][colCount];
		for (int i = 0; i < rowCount - 1; i++) {
			firstRow = sh.getRow(i + 1);
			for (int j = 0; j < colCount; j++) {
				Cell cell = firstRow.getCell(j);
				data[i][j] = format.formatCellValue(cell);
			}
		}
		return data;
	}

}
