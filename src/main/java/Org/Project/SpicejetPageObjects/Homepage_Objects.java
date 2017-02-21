package Org.Project.SpicejetPageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Org.Project.Spicejet.Baseclass;

public class Homepage_Objects extends Baseclass {

	@FindBy(id = "ctl00_mainContent_ddl_originStation1_CTXT")
	private WebElement originstation;
	
	public WebElement getorigincity(){
		return originstation;
	}
	
	public void clickorigincitydropdown(){
		
		getorigincity().click();
	}

	@FindBy(xpath = "//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']/table/tbody/tr[2]/td/div[3]/div[1]/div/ul")
	private static List<WebElement> originallstatesindia;
	
	public List<WebElement> getoriginallstatesindia(){
		return originallstatesindia;
	}
	
	@FindBy(xpath = "//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']/table/tbody/tr[2]/td/div[3]/div[1]/div/ul")
	private static List<WebElement> destinationstatesindia;
	
	public List<WebElement> getdestinationstatesindia(){
		return destinationstatesindia;
	}
	
	public void selectState(String state){
		
		//d.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		List<WebElement> col1  = originallstatesindia;
		for(int l=1; l<=col1.size();l++){
			List<WebElement> rows1=driver.findElements(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']/table/tbody/tr[2]/td/div[3]/div[1]/div/ul["+l+"]/li"));
			for(int m=1;m<=rows1.size();m++){
			WebElement first1=driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']/table/tbody/tr[2]/td/div[3]/div[1]/div/ul["+l+"]/li["+m+"]"));
			if(first1.getText().contains(state)){
				first1.click();
				return;
			}
				}
			
			}	
	}
	
	public void compareStates(String state) throws InterruptedException{
		
		//System.out.println("Method passing value = " +state);
		List<WebElement> col2  = destinationstatesindia;
		Thread.sleep(2000);
		for(int n=1; n<=col2.size();n++){
			List<WebElement> rows2=driver.findElements(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']/table/tbody/tr[2]/td/div[3]/div[1]/div/ul["+n+"]/li"));
			for(int p=1;p<=rows2.size();p++){
			WebElement first2=driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']/table/tbody/tr[2]/td/div[3]/div[1]/div/ul["+n+"]/li["+p+"]"));
			//System.out.println("Loop Value = " + first2.getText());
			Assert.assertNotEquals(first2.getText(), state);
				}
		}
	}

}
