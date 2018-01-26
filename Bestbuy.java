package Selenium;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Bestbuy {
	//public static void Main(String[] args) throws IOException
	
		public static XSSFWorkbook wb;

	    public static XSSFSheet sheet;

	    public static XSSFRow row;

	    public static XSSFCell cell;
	    public static WebDriver driver;
	    public static FileInputStream fisexcel;
	    public static FileInputStream fisexcel1;
  
	    @Test
		      public void test() throws IOException, AWTException {
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\anagh\\Selenium\\chromedriver_win32\\chromedriver.exe");
	    	driver = new ChromeDriver();
				 Properties prop = new Properties();
				 FileInputStream fis = new FileInputStream("C:\\Users\\anagh\\eclipse-workspace\\Automation\\src\\Selenium\\datadriver.properties");
				 prop.load(fis);
				 String u = prop.getProperty("Username");
					String p = prop.getProperty("Password");
					String url = prop.getProperty("url"); 
				 //String baseUrl = "http://www.bestbuy.com/";
				 driver.get(url);
				 driver.findElement(By.xpath("//*[@class='modal fade email-submission-modal in']/div/div/div[1]/button/span[2]")).click();
			
			 
				 WebElement element = driver.findElement(By.xpath("//*[@id=\"profileMenuWrap1\"]")); // located when button visible
				 WebElement element1 = driver.findElement(By.xpath("//*[@id=\"profileMenu1\"]/div/div[3]/div/a")); // located when button visible
				 
				 Actions actions = new Actions(driver);
				    System.out.println(element);    
				  Action clickel=  actions.moveToElement(element).click(element).build();
				 
				  System.out.println(clickel);
				    clickel.perform();
				    actions.doubleClick(element).build().perform();
				    
				    driver.manage().deleteAllCookies();
				
//				 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		             
				 System.out.println(element1);
				 Actions actions1 = new Actions(driver);
				  Action clicksign = actions1.moveToElement(element1).click(element1).build();
				 actions.click(element1).click().build();
				  System.out.println(clicksign);
				  clicksign.perform();
				 
				 driver.findElement(By.xpath(".//*[@id='fld-e']")).clear();
				 driver.findElement(By.xpath(".//*[@id='fld-e']")).sendKeys(u);
				 driver.findElement(By.xpath(".//*[@id='fld-p1']")).sendKeys(p);
				 driver.findElement(By.xpath("html/body/section/main/div[1]/div[1]/div/div/form/button")).click();
			     driver.findElement(By.xpath("/html/body/header/div/div/a[2]")).click();
				 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	          getCelldata(0,0);
			  getCelldata(1,0);
			  getCelldata(2,0);
			  //  String value3=getCelldata(3,0);
			   // String value4=getCelldata(4,0);
			    //*/
//			    String valueset=setCelldata("automation",0,0);		
		}
		
		public String getCelldata(int rownum, int col) throws IOException, AWTException {
			// TODO Auto-generated method stub
		     	fisexcel = new FileInputStream("D:\\laptoplist.xlsx");
		      wb = new XSSFWorkbook(fisexcel);
		      sheet = wb.getSheet("script");
		      row = sheet.getRow(rownum);
		      cell=row.getCell(col);
		      String laptopname = cell.getStringCellValue();
		    System.out.println(laptopname);
		    
			driver.findElement(By.xpath("//*[@id='gh-search-input']")).click();	
		    driver.findElement(By.xpath("//*[@id='gh-search-input']")).clear();
		    driver.findElement(By.xpath("//*[@id='gh-search-input']")).sendKeys(laptopname);
		    driver.findElement(By.xpath(".//*[@id='header']/div[1]/div[2]/div[2]/form/button[2]")).click();
		    /*WebElement prod = driver.findElement(By.xpath(".//*[@id='main-results']/div[3]/div[1]/div/div[2]/div/div[1]/h4/a"));
			
			Actions a = new Actions(driver);
		
			//a.moveToElement(driver.findElement(By.xpath(".//*[@id='main-results']/div[3]/div[1]/div/div[2]/div/div[1]/h4/a"))).contextClick().build().perform();
			a.moveToElement(prod);
			a.contextClick(prod).build().perform(); 
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			a.contextClick().release();*/
			//return value;	     
			return laptopname;
		}


	/*	public static  String setCelldata(String text, int rownum1,int col1) throws IOException
		{
			fisexcel1 = new FileInputStream("D:\\SeleniumTraining\\laptoplist.xlsx");
		wb=new XSSFWorkbook(fisexcel1);
		sheet=wb.getSheet("script");
		
		 sheet.getRow(rownum1).createCell(col1).setCellValue(text);
		row=sheet.getRow(rownum1);
		cell=row.getCell(col1);
		
		FileOutputStream fout=new FileOutputStream("D:\\SeleniumTraining\\laptoplist.xlsx"); 
		// finally write content 
		 wb.write(fout);
		 System.out.println(cell.getStringCellValue());
		 	return cell.getStringCellValue();
		}*/
	  
	}
