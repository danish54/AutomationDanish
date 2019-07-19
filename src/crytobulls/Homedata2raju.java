package crytobulls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Homedata2raju

{

  WebDriver driver;

  JavascriptExecutor js;

  String path ="C:\\Users\\Node-01\\Desktop\\tender document\\testdata.xlsx";

  String path1="C:\\Users\\Node-01\\Desktop\\tender document\\test.xlsx";

  String text, text1,text2,text3,text4;

@BeforeTest

public void openapp()

{

    System.setProperty("webdriver.chrome.driver","E:\\jar file\\chromedriver.exe");

     driver=new ChromeDriver();

     driver.get("https://www.cryptobulls.exchange/");

     driver.manage().window().maximize();

     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

    

       }

    

 @Test

 

  public void operation() throws InterruptedException, IOException

  {

        WebElement element=driver.findElement(By.xpath("//tbody[@id='viewpair']"));

        java.util.List<WebElement> countrow=element.findElements(By.tagName("tr"));

        System.out.println(countrow.size());

        String pairent="/html[1]/body[1]/section[2]/div[2]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[";

        String child="]/td[3]";

        

       // String mid="]/td[";

       //String child1="]";

        js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,400)");

      

        for(int i=1; i<countrow.size(); i++)

         {           

         String s1="/html[1]/body[1]/section[2]/div[2]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[";

         String s2="]/td[";

         String s3="]";

            for(int j=4; j<=8; j++)

            {

                text=driver.findElement(By.xpath(s1+i+s2+j+s3)).getText();

                

                

                System.out.println(text);

                

                File fso = new File(path1);

                FileInputStream fis = new FileInputStream(fso);

                XSSFWorkbook wb = new XSSFWorkbook(fis);

                XSSFSheet s = wb.getSheet("Sheet1");

                

                 Row r=s.createRow(i);

                 

                 r.createCell(j).setCellValue(text);

                  Thread.sleep(3000);

                

                FileOutputStream fo = new FileOutputStream(path1);

               wb.write(fo);

               fo.close();  

                

                

                

                

            }

                /*   text=element.findElement(By.xpath("/html[1]/body[1]/section[2]/div[2]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[4]")).getText();

                   

            

                    text1=element.findElement(By.xpath("/html[1]/body[1]/section[2]/div[2]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[5]")).getText();

                 

                    text2=element.findElement(By.xpath("/html[1]/body[1]/section[2]/div[2]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[6]")).getText();

                    

                    text3=element.findElement(By.xpath("/html[1]/body[1]/section[2]/div[2]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[7]")).getText();

                   

                    text4=element.findElement(By.xpath("/html[1]/body[1]/section[2]/div[2]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[8]")).getText();

                

             System.out.println("LAST PRICE ="+text);

             System.out.println("24H CHANGE ="+text1);

             System.out.println("24H HIGH    ="+text2);

             System.out.println("24H LOW    ="+text3);

             System.out.println("24H VOLUME(BTC)="+text4);

            

            

               */

              

            pairent="/html[1]/body[1]/section[2]/div[2]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[";

            child="]/td[3]";

              Thread.sleep(4000);

           driver.findElement(By.xpath(pairent+i+child)).click();

           Thread.sleep(8000);

           String linkname=driver.findElement(By.xpath("//span[@class='poppins g-font-size-16 g-font-weight-600 g-color-gray-dark-v5 capitalize g-line-height-1_8']")).getText();

           System.out.println("Coin Name ="+linkname);

           String twentyFourH=driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/h4[1]/span[1]")).getText();

           System.out.println("24HHValue"+twentyFourH);

           String twentyFourL=driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/h4[1]/span[1]")).getText();

           System.out.println("24HLValue ="+twentyFourL);

           String Lastprice=driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/h4[1]")).getText();

           System.out.println("Last price ="+Lastprice);

           String Sevendayschange=driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/h5[1]")).getText();

           System.out.println("7dayschange ="+Sevendayschange);

           String twentyFourHchange=driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[5]/div[1]/h5[1]")).getText();

           System.out.println("24HHchange ="+twentyFourHchange);

           String twentyFourHVolume=driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[6]/div[1]/h5[1]")).getText();

           System.out.println("24HHVolume ="+twentyFourHVolume);

           String twentyFourHFee=driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[7]/div[1]/h5[1]")).getText();

           System.out.println("24HFee ="+twentyFourHFee);

    

        /*    if(text1.equals(twentyFourHchange))

            {

                

                System.out.println("PASS");

                

            }else

            {

                

                System.out.println("FALS");

                

            } */

           

            

            

    /*       File fso = new File(path);

           FileInputStream fis = new FileInputStream(fso);

           XSSFWorkbook wb = new XSSFWorkbook(fis);

           XSSFSheet s = wb.getSheet("Homepagedata");

           

            Row r=s.createRow(i);

            

            r.createCell(0).setCellValue(linkname);

            

            r.createCell(1).setCellValue(twentyFourH);

            

            r.createCell(2).setCellValue(twentyFourL);

            

            r.createCell(3).setCellValue(Lastprice);

            

            r.createCell(4).setCellValue(Sevendayschange);

            

            r.createCell(5).setCellValue(twentyFourHchange);

            

            r.createCell(6).setCellValue(twentyFourHVolume);

            

            r.createCell(7).setCellValue(twentyFourHFee);

            

          

            

           FileOutputStream fo = new FileOutputStream(path);

           wb.write(fo);

           fo.close();  

             */

            driver.navigate().back();

          //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            js.executeScript("window.scrollBy(0,500)");

             Thread.sleep(6000);

            

       

              }

         

         }

        

         //java.util.List<WebElement> countcol=element.findElements(By.tagName("td"));

           

         //System.out.println(countcol.size());

         

 

 @AfterTest

 

 public void closeapp()

 {

     

 driver.close();

     

 }

     

  

    

}
