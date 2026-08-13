package genericLab;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserServers {
	public WebDriver driver;
public WebDriver initializeDriver() throws IOException {
	DataUtility du = new DataUtility();
	String browserName=System.getProperty("browser")!=null?System.getProperty("browser"):du.getProperties().getProperty("browser");
	if(browserName.contains("chrome")) {
	Map<String, Object> abc = new HashedMap<String, Object>();
	abc.put("profile.password_manager_leak_detection", false);
	ChromeOptions opt = new ChromeOptions();
	opt.setExperimentalOption("prefs", abc);
	if(browserName.contains("headless")) {
	opt.addArguments("headless");
	}
	driver = new ChromeDriver(opt);

	}
	else if(browserName.equalsIgnoreCase("edge")){
		driver=new EdgeDriver();
	}
	return driver;
}
}
