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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dashboard 
{
    private static int      DISPLAY_NUMBER  = 99;
    private static String   XVFB            = "/usr/bin/Xvfb";
    private static String   XVFB_COMMAND    = XVFB + " :" + DISPLAY_NUMBER;
    private static String   URL             = "http://kaichih.github.io/FxOS-Dashboard/";
    private static String   RESULT_FILENAME = "/Users/Joshwalker/Google 雲端硬碟/Mozilla/screenshot.png";

    public static void main ( String[] args ) throws IOException, InterruptedException
    {
    	
    	
        //Process p = Runtime.getRuntime().exec(XVFB_COMMAND);
        FirefoxBinary firefox = new FirefoxBinary();
        //firefox.setEnvironmentProperty("DISPLAY", ":" + DISPLAY_NUMBER);
        WebDriver driver = new FirefoxDriver(firefox, null);
        driver.manage().window().setSize(new Dimension(320, 480));
        driver.get(URL);
        Thread.sleep(10000);
        
        File scrFile = ( (TakesScreenshot) driver ).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(RESULT_FILENAME));
        driver.close();
        //p.destroy();
    }
}