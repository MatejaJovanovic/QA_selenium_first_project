package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\jovanovicm\\Documents\\QA_fajlovi\\Selenium_Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://facebook.com");
        System.out.println(driver.getTitle());
     //   wait = new WebDriverWait(driver)
        driver.quit();
    }
}
