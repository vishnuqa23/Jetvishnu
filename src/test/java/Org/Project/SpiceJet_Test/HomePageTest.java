package Org.Project.SpiceJet_Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Org.Project.Spicejet.Baseclass;
import Org.Project.Spicejet.UtilityFunctions;
import Org.Project.SpicejetPageObjects.Homepage_Objects;

public class HomePageTest extends Baseclass {
	UtilityFunctions util = new UtilityFunctions();
	static Homepage_Objects homepage;

	@BeforeTest
	public void setup() throws IOException{
		String driverPath = "C://Users//Vishnu P C//Desktop//Gecko//";
		System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
		driver = new FirefoxDriver();
		String url = util.readProperties().getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterTest
	
	public void teardown() throws Exception{
		
	util.takeScreenshot(driver,"VerifyOriginAndDestinationCities");
		driver.close();
	}
	
	@Test
	public static void verifyAllState() throws InterruptedException{
		
		homepage = PageFactory.initElements(driver, Homepage_Objects.class);
		homepage.clickorigincitydropdown();
		List<WebElement> col  = homepage.getoriginallstatesindia();
		for(int i=1; i<=col.size();i++){
			List<WebElement> rows=driver.findElements(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']/table/tbody/tr[2]/td/div[3]/div[1]/div/ul["+i+"]/li"));
			for(int j=1;j<=rows.size();j++){
			WebElement first=driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']/table/tbody/tr[2]/td/div[3]/div[1]/div/ul["+i+"]/li["+j+"]"));
			homepage.selectState(first.getText());
			Thread.sleep(2000);
			homepage.compareStates(first.getText());
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			Thread.sleep(2000);
				}
			
			}
	}
	
}
