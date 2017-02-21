package Org.Project.Spicejet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityFunctions extends Baseclass{

	String Path_ScreenShot = "C://Users//Vishnu P C//workspace//Spicejet//screenshots//screenshots";
	
	 	public Properties readProperties() throws IOException{
		 
			 Properties prop =null;
			 FileInputStream propfile = new FileInputStream("src/test/resources/spicejet.properties");
			 prop = new Properties();
			 prop.load(propfile);
			 return prop; 
	 	}
	 	
	 	public ArrayList<String> readExcelData() throws IOException{
	 		
	 		int i,j;
			FileInputStream fis = new FileInputStream("resources/Spicejetusers.xls");
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sheet = wb.getSheet("sheet1");
			DataFormatter formatter = new DataFormatter();

			int rowCount = sheet.getLastRowNum();// getting no of rows
			
			ArrayList<String> list = new ArrayList<String>();
			
			for (i = 1; i <= rowCount; i++) {

				HSSFRow row = sheet.getRow(i);
				for (j = 0; j < row.getLastCellNum(); j++) {
					
					Cell cell = row.getCell(j);
					list.add(formatter.formatCellValue(cell));
				}
			}
			return list;	
	 	}
	 	
	 	 public void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
			 
				try{
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(Path_ScreenShot +"_"+sTestCaseName +".jpg"));	
				} catch (Exception e){
					throw new Exception();
				}
			
		}
}
