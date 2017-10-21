package demo_packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FlightLogin_Multiple_Parameter {
	
	@Test(dataProvider="SearchProvider")
		public void Flight_Login(String uname,String password) {
			WebDriver driver = new FirefoxDriver();
			String baseurl = "http://newtours.demoaut.com/mercurywelcome.php";
			driver.get(baseurl);
			driver.manage().window().maximize();
			driver.findElement(By.name("userName")).click();
			driver.findElement(By.name("userName")).sendKeys(uname);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("login")).click();
			driver.findElement(By.linkText("SIGN-OFF")).click();
			driver.quit();
		}

    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(){

        return new Object[][] {

                { "testing", "testing"},

                { "selenium", "selenium" }

                };

    }
}
