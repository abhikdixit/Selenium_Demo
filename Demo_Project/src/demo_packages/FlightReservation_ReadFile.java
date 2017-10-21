package demo_packages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightReservation_ReadFile {
	@Test	
	public void bookticket() throws IOException, InterruptedException {
	WebDriver driver = new FirefoxDriver();
	File file = new File("D:\\F Drive\\Selenium Training Data\\Selenium Training\\Demo_Project\\src\\demo_packages\\datafile.properties");
	Properties prop = new Properties();
	FileInputStream fileInput = new FileInputStream(file);
	prop.load(fileInput);
	driver.get(prop.getProperty("URL"));
	driver.manage().window().maximize();
	driver.findElement(By.linkText(prop.getProperty("lksignon"))).click();
	driver.findElement(By.name(prop.getProperty("FLInUname"))).sendKeys("selenium");
	driver.findElement(By.name(prop.getProperty("FLInUpass"))).sendKeys("selenium");
	driver.findElement(By.name("login")).click();
	WebElement element = driver.findElement(By.linkText("SIGN-OFF"));
	//Thread.sleep(60);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	String strng = element.getText();
	System.out.println(strng);
	Assert.assertEquals("SIGN-OFF", strng);
	driver.findElement(By.xpath("//input[@value='oneway']")).click();
	Select oSelect = new Select(driver.findElement(By.name("fromPort")));
 	oSelect.selectByValue("London");
	driver.findElement(By.name("findFlights")).click();
	String depart = driver.findElement(By.xpath("//td[@class='title']/font/b/font[contains(text(), 'DEPART')]")).getText();
	System.out.println(depart);
	Assert.assertEquals("DEPART", depart);
	driver.findElement(By.name("reserveFlights")).click();
	driver.findElement(By.name("passFirst0")).sendKeys("Demo");
	driver.findElement(By.name("passLast0")).sendKeys("Selenium");
	driver.findElement(By.name("creditnumber")).sendKeys("1234567891234567");
	driver.findElement(By.name("buyFlights")).click();
	driver.findElement(By.linkText("SIGN-OFF")).click();
	//driver.navigate().back();
	driver.quit();
	}
}
