package demo_packages;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Demo_Class {
@Test	
	public void checktitle() {
	
	// Method and Description - static DesiredCapabilities internetExplorer()
		 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability("ignoreProtectedModeSettings", true);
		 
		 //Among the facilities provided by the System class are standard input, standard output, and error output streams; access to externally defined "properties"; a means of loading files and libraries; and a utility method for quickly copying a portion of an array.
		 System.setProperty("webdriver.ie.driver","D:\\F Drive\\Selenium Training Data\\Selenium Training\\Demo_Project\\IEDriverServer.exe");
		 
		 //InternetExplorerDriver(Capabilities capabilities)
		 WebDriver driver = new InternetExplorerDriver(capabilities);
		//Test 
	//WebDriver driver = new FirefoxDriver();
	String baseurl = "https://www.shutterfly.com/";
	driver.get(baseurl);
	String expectedTitle = "Photo Books, Holiday Cards, Photo Cards, Birth Announcements, Photo Printing | Shutterfly";
	String actualTitle = "";
	driver.manage().window().maximize();
//	System.out.println(driver.getTitle());
	actualTitle = driver.getTitle();
	
    if (actualTitle.contentEquals(expectedTitle)){
        System.out.println("Test Passed!");
    } else {
        System.out.println("Test Failed");
    }
	
	driver.quit();
	}

}
