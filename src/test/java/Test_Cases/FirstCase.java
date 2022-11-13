package Test_Cases;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class FirstCase {

        public String baseUrl = "https://www.saucedemo.com/";
        String driverPath = "C:\\Users\\jovanovicm\\Documents\\QA_fajlovi\\Selenium_Chrome_Driver\\chromedriver_win32\\chromedriver.exe";
        public WebDriver driver ;

        public WebDriverWait wait;


        //Constants
        By products_header = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
        By cart_link = By.cssSelector(".shopping_cart_link");
        By twitter_link = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a");
        By facebook_link= By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a");

        By linkedin_link = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a");
        By burger_menu =By.cssSelector("#react-burger-menu-btn");
        By logout_link = By.cssSelector("a[id='logout_sidebar_link']");

        String twitter_homepage= "https://twitter.com/saucelabs";
        String facebook_homepage= "https://www.facebook.com/saucelabs";
        String linkedin_homepage= "https://www.linkedin.com/company/sauce-labs/";


        //Launching of the driver/browser
        @BeforeTest
        public void launchBrowser() {
                System.out.println("launching Chrome browser");
                System.setProperty("webdriver.chrome.driver", driverPath);
                driver = new ChromeDriver();
                driver.get(baseUrl);
                wait= new WebDriverWait(driver, Duration.ofMillis(5000));
                driver.manage().window().maximize();
        }



        //Main tests
        @Test
        public void verification_browser(){


                //Locating the email field element via Name tag and storing it in the webelement
                WebElement email_field=driver.findElement(By.name("user-name"));

                //Entering text into the email field
                email_field.sendKeys("standard_user");

                //Locating the password field element via Name tag and storing it in the webelement
                WebElement password_field=driver.findElement(By.name("password"));

                //Entering text into the password field
                password_field.sendKeys("secret_sauce");

                //Clicking on the login button to login to the application
                WebElement login_button=driver.findElement(By.cssSelector("#login-button"));

                //Clicking on the 'login' button
                login_button.click();
                System.out.println("Congrats you have successfully logged in!");

                //Verifying header text
                wait.until(ExpectedConditions.presenceOfElementLocated(products_header));
                WebElement header =  driver.findElement(products_header);
                Assert.assertEquals(header.getText(),  "PRODUCTS");
                System.out.println("Header successfully verified");

                //Verifying burger menu
                wait.until(ExpectedConditions.presenceOfElementLocated(burger_menu));
                WebElement brgr = driver.findElement(burger_menu);

                //Verifying the twitter link
                wait.until(ExpectedConditions.presenceOfElementLocated(cart_link));
                wait.until(ExpectedConditions.presenceOfElementLocated(twitter_link));
                WebElement twitter=driver.findElement(twitter_link);
                Assert.assertEquals( twitter.getAttribute("href"), twitter_homepage);

                //Verifying the facebook link
                wait.until(ExpectedConditions.presenceOfElementLocated(facebook_link));
                WebElement facebook=driver.findElement(facebook_link);
                Assert.assertEquals( facebook.getAttribute("href"), facebook_homepage);

                //Verifying the linked in link
                wait.until(ExpectedConditions.presenceOfElementLocated(linkedin_link));
                WebElement linkedin=driver.findElement(linkedin_link);
                Assert.assertEquals( linkedin.getAttribute("href"), linkedin_homepage);

                //Clicking on the burger menu, verifying logout option and clicking on it
                brgr.click();
                wait.until(ExpectedConditions.elementToBeClickable(logout_link));
                WebElement logout = driver.findElement(logout_link);
                logout.click();
                System.out.println("Logged out");
        }


        //Closing the browser/driver
        @AfterTest
        public void terminateBrowser(){
                driver.quit();
        }
}
