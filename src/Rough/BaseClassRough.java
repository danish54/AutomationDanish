package Rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ByXPath;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BaseClassRough {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;

	public void Setup() throws IOException, InterruptedException {

		// loading config properties
		
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\Properties\\config.properties");
		config.load(fis);

		// loading OR properties
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\Properties\\OR.properties");
		OR.load(fis);
		// instentiating browser

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Danish\\Downloads\\chromedriver_win32\\chromedriver.exe");

		// launching browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		

	}

	public void login() throws IOException, InterruptedException {

		BaseClassRough base = new BaseClassRough();

		base.Setup();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(config.getProperty("baseurl"));
		driver.findElement(By.id(OR.getProperty("username_id"))).sendKeys(config.getProperty("username"));
		driver.findElement(By.id(OR.getProperty("password_id"))).sendKeys(config.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id(OR.getProperty("login_button_id"))).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void captureSnapShot() throws IOException {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		File ssFile = ((TakesScreenshot) (driver)).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		FileUtils.copyFile(ssFile, new File(
				"E:\\eclipse-jee-neon-3-win32-x86_64\\New folder\\Automation\\src\\excel\\" + sdf.format(d) + ".jpg"));
	}

	public void clickbyxpath(String xpath) {
		
		driver.findElement(By.xpath(xpath)).click();;
		//BaseClassRough xp = new BaseClassRough();
		//xp.clickbyxpath("click_xpath");
	}
	
public void sendbyxpath(String xpath, String value) {
		
		driver.findElement(By.xpath(xpath)).sendKeys(value);
		//BaseClassRough xp = new BaseClassRough();
		//xp.sendbyxpath("send_xpath", "value");
	}
	

public  boolean isElementPresent(WebDriver driver,By by)  
 {  
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
    try  
    {  
       driver.findElement(by);  
       return true;  
    }  
    
    catch(Exception e)  
    
    {  
    	
       return false;  
    }  
    
    finally  
    {  
    	
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
     }  
 }  


    @Test
	public void emailSend() {
    	
    	
    		 
    		// Create object of Property file
    		Properties props = new Properties();
     
    		// this will set host of server- you can change based on your requirement 
    		props.put("mail.smtp.host", "smtp.gmail.com");
     
    		// set the port of socket factory 
    		props.put("mail.smtp.socketFactory.port", "465");
     
    		// set socket factory
    		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
     
    		// set the authentication to true
    		props.put("mail.smtp.auth", "true");
     
    		// set the port of SMTP server
    		props.put("mail.smtp.port", "465");
     
    		// This will handle the complete authentication
    		Session session = Session.getDefaultInstance(props,
     
    				new javax.mail.Authenticator() {
     
    					protected PasswordAuthentication getPasswordAuthentication() {
     
    					return new PasswordAuthentication("add your email", "add your password");
     
    					}
     
    				});
     
    		try {
     
    			// Create object of MimeMessage class
    			Message message = new MimeMessage(session);
     
    			// Set the from address
    			message.setFrom(new InternetAddress("mukeshotwani.50@gmail.com"));
     
    			// Set the recipient address
    			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("mukesh.otwani50@gmail.com"));
                
                            // Add the subject link
    			message.setSubject("Testing Subject");
     
    			// Create object to add multiMedia type content
    			BodyPart messageBodyPart1 = new MimeBodyPart();
     
    			// Set the body of email
    			messageBodyPart1.setText("This is message body");
     
    			// Create another object to add another content
    			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
     
    			// Mention the file which you want to send
    			String filename = "G:\\a.xlsx";
     
    			// Create data source and pass the filename
    			DataSource source = new FileDataSource(filename);
     
    			// set the handler
    			messageBodyPart2.setDataHandler(new DataHandler(source));
     
    			// set the file
    			messageBodyPart2.setFileName(filename);
     
    			// Create object of MimeMultipart class
    			Multipart multipart = new MimeMultipart();
     
    			// add body part 1
    			multipart.addBodyPart(messageBodyPart2);
     
    			// add body part 2
    			multipart.addBodyPart(messageBodyPart1);
     
    			// set the content
    			message.setContent(multipart);
     
    			// finally send the email
    			Transport.send(message);
     
    			System.out.println("=====Email Sent=====");
     
    		} catch (MessagingException e) {
     
    			throw new RuntimeException(e);
     
    		}
     
    	}
    	

	
	public void Close() {

		driver.quit();
	}

}
