package pl.inpost.home.task.ui.utils;

import pl.inpost.home.task.config.Config;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

      public static void takeScreenshot(WebDriver driver, String scenarioName){
        if (driver == null) {
            System.err.println("WebDriver is null, cannot take screenshot!");
            return;
        }
        
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = scenarioName.replaceAll(" ", "_") + "_" + timestamp + ".png";
            String filePath = Config.getReportsDirectory() + "screenshots/" + fileName;
            FileUtils.copyFile(srcFile, new File(filePath));
            System.out.println("Screenshot saved: " + filePath);
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
