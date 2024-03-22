package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
    public static WebDriver driver;
    public Logger logger;
    public Properties p;
	
	@SuppressWarnings("deprecation")
	@BeforeClass (groups = {"regression", "master", "sanity"})
	@Parameters({"browser", "os"})
	public void setup(String browser, String os) throws InterruptedException, IOException
	{
		// Loading Properties File
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		
		
		// Loading Log4j2 XML File
		logger = LogManager.getLogger(this.getClass());
		
		// Launching Grid
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			//Launching browser remotely
			
			if(browser.equals("chrome"))
			{
				capabilities.setBrowserName("chrome");
			}
			else if(browser.equals("edge"))
			{
				capabilities.setBrowserName("Microsoft Edge");
			}
			else {
				System.out.println("No Matching Browser");
				return;
			}
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			
	    }
		
		
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		
		// Launching Browser Locally
		
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if(browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("No Matching Browser");
			return;
		}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get(p.getProperty("appURL"));
		driver.get("https://232app.azurewebsites.net/");
		//driver.get("https://demo.opencart.com/");
		
		driver.manage().window().maximize();
		Thread.sleep(4000);
	}
	
	@AfterClass(groups = {"regression", "master", "sanity"})
	public void shutdown()
	{
		driver.close();
	}
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	
	public String randomNumber()
	{
		String generatedString = RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric()
	{
		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);
		return (str + "@" + num);
	}
	
	
	// Capture Screenshots
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

}
}
