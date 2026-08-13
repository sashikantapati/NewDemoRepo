package genericLab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility {
	String url;
	String userName;
	String password;

	public Properties getProperties() throws IOException {
		FileInputStream fis= new FileInputStream(
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
}
