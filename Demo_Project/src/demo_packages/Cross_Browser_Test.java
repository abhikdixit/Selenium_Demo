package demo_packages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross_Browser_Test {
	WebDriver driver;
	
	@BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception {
		

        if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
       else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","D:\\F Drive\\Selenium Training Data\\Selenium Training\\Demo_Project\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        else{

            //If no browser passed throw exception

            throw new Exception("Browser is not correct");

        }

       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
    
	@Test
	public void Flight_Login() {
		String baseurl = "http://newtours.demoaut.com/mercurywelcome.php";
		driver.get(baseurl);
		driver.navigate().to("");
		//driver.manage().window().maximize();
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("SIGN-OFF")).click();
		driver.quit();
	}

}
