package info.kinhho.check_status_at_school;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Task implements Job {

	public static final String USERNAME = "51603174";
	public static final String PASSWORD = "51603174K";
	public static final String ORDER_ID = "609127";
	public static final String VALID = "Hợp lệ";
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		URL phantomExeURL = this.getClass()
                .getClassLoader().getResource("phantomjs.exe");
		System.out.println("URL: " + phantomExeURL.getPath());
    	DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true);
		caps.setCapability("takesScreenshot", true);
		caps.setCapability(
		PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
		phantomExeURL.getPath()
		);
		PhantomJSDriver driver = new PhantomJSDriver(caps);
		
		driver.get("https://stdportal.tdtu.edu.vn/taikhoan/dangnhap");
		
		WebElement username = driver.findElement(By.id("MSSV"));
		username.sendKeys(USERNAME);
		
		WebElement password = driver.findElement(By.id("MK"));
		password.sendKeys(PASSWORD);
		
		
		WebElement submit = driver.findElement(By.cssSelector("p > input[type='submit']"));
		submit.click();
		
		System.out.println(driver.getCurrentUrl());
		
		WebElement studentCertificate = driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div[7]/div"));
		studentCertificate.click();
		
		System.out.println(driver.getWindowHandles());
		
		String newWindow = driver.getWindowHandles().toArray(new String[0])[1];
		driver.switchTo().window(newWindow);
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		WebElement kqgn = driver.findElementByCssSelector("#modernbricksmenu > ul > li:nth-child(2) > a");
		kqgn.click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<WebElement> tbodys = driver.findElements(By.tagName("tbody"));
		WebElement tbody = tbodys.get(3);
		
		List<WebElement> trs = tbody.findElements(By.tagName("tr"));
		for (WebElement tr : trs) {
			WebElement orderId = tr.findElement(By.xpath("td[1]"));
			WebElement status = tr.findElement(By.xpath("td[7]"));
			
			System.out.println("Order Id: " + orderId.getText());
			System.out.println("Status: " + status.getText());
			
			if (orderId.getText().equals(ORDER_ID) && status.getText().equals(VALID)) {
				context.put("message", "success");
				break;
			}
			else {
				context.put("message", "fail");
			}
		}
		driver.quit();
	}
}
