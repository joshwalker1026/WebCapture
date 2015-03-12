package com.mozilla.dashboard;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class dashboard 
{
    private static String   OS_URL             = "file:///home/josh/Documents/workspace/FxOS-Dashboard/index.html";
    private static String   DEV_URL             = "file:///home/josh/Documents/workspace/charts/devices/dashboard.html";
    private static String   OS_RESULT_FILENAME = "/home/josh/Dropbox/Mozilla/DBscreenshot.png";
    private static String   DEV_RESULT_FILENAME = "/home/josh/Dropbox/Mozilla/Devscreenshot.png";
    private static int   Timeout = 150; //minutes
    static File scrFile = null;
    
    public static void main ( String[] args ) throws IOException, InterruptedException
    {
        FirefoxBinary firefox = new FirefoxBinary();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(480, 640));

        while(true)
        {
        
        // capture OS image
        driver.get(OS_URL);
        System.out.println("OS URL Opened:"+OS_URL );
        System.out.println("Sleep for "+Timeout+" Seconds");
        Thread.sleep(Timeout*1000);
        System.out.println("Taking OS screenshot");
        
        scrFile = ( (TakesScreenshot) driver ).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(OS_RESULT_FILENAME));
        
        // capture DEV image
        driver.get(DEV_URL);
        System.out.println("DEV URL Opened:"+ DEV_URL );
        System.out.println("Sleep for "+Timeout+" Seconds");
        Thread.sleep(Timeout*1000);
        System.out.println("Taking DEV screenshot");
        
        scrFile = ( (TakesScreenshot) driver ).getScreenshotAs(OutputType.FILE);
        
        BufferedImage img = ImageIO.read(scrFile);

        BufferedImage dest = img.getSubimage(45, 70, 320,   
                                 240);

        ImageIO.write(dest, "png", scrFile);
        
        FileUtils.copyFile(scrFile, new File(DEV_RESULT_FILENAME));
        }
    }
}