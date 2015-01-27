package com.mozilla.dashboard;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.fluentlenium.adapter.FluentTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class dashboard 
{
    private static String   URL             = "http://kaichih.github.io/FxOS-Dashboard/";
    //private static String   URL             = "http://www.yahoo.com";
    private static String   RESULT_FILENAME = "C:\\Users\\user\\Dropbox\\Mozilla\\DBscreenshot.png";
    private static int   Timeout = 300;
    
    public static void main ( String[] args ) throws IOException, InterruptedException
    {
        FirefoxBinary firefox = new FirefoxBinary();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(480, 640));
        driver.get(URL);
        System.out.println("URL Opened:"+URL );
        
        while(true)
        {
        System.out.println("Sleep for "+Timeout+" Seconds");
        Thread.sleep(Timeout*1000);
        System.out.println("Taking screenshot");
        
        File scrFile = ( (TakesScreenshot) driver ).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(RESULT_FILENAME));
        System.out.println("Refresh page");
        driver.navigate().refresh();
        }
    }
}