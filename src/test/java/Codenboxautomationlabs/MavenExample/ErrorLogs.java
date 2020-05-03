package Codenboxautomationlabs.MavenExample;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class ErrorLogs extends Base {
	
	@Test
	public void ErrorLogsTest() throws IOException {
		
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
//		LandingPage l=new LandingPage(driver);
//		Assert.assertEquals(l.getTitle().getText(), "Automation Practice123*****");
		
		List<LogEntry> entries = driver.manage().logs().get(LogType.BROWSER).getAll();
		System.out.println(entries.size() + " " + LogType.BROWSER + " log entries found");
		for (LogEntry entry : entries) {
			System.out.println(entry.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	
	@AfterMethod 
	
	public void tearDown() {
		driver.close();
		driver = null; // All the objects are alive in memory that can full. So clean memory.
	}

}
