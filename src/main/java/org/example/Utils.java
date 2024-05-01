package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils extends BasePage
{
    //// Create Object For Load Properties Class
    static LoadProp loadProp = new LoadProp();

    // Store Email Id In Variable
    public static String email = loadProp.getProperty("EmailPart1")+randomDate()+loadProp.getProperty("EmailPart2");

    // Create New Click On Element Method For Reusability
    public static void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }
    // Create New Type Text Method For Reusability
    public static void typeText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    // Create New Get Text From Element Method For Reusability
    public static String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }
    public static String randomDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyhhmm");
        Date date = new Date();
        return dateFormat.format(date);
    }
    //Create New Select By Visible Text Method For DropDown list For Reusability
    public static void selectByVisibleText(By by, String text)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }
    // Create Method For Screen Shot
    public  static void takeSnapShot(String text)
    {
        //Convert Web Driver Object To Take Screen Shot
        TakesScreenshot scrShot =((TakesScreenshot)driver );
        //Call Get Screenshot As Method To Create Image File
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        // Copy File Destination
        try
        {
            FileUtils.copyFile(SrcFile, new File("src/ScreenShot"+text+randomDate()+".png"));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    //Create Implicit Wait Method For Reusability
    public static void toDriverWaitForFewSecond()
    {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
}
