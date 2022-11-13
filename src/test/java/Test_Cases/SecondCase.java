package Test_Cases;

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


public class SecondCase {


    public String baseUrl = "https://www.saucedemo.com/";
    String driverPath = "C:\\Users\\jovanovicm\\Documents\\QA_fajlovi\\Selenium_Chrome_Driver\\chromedriver_win32\\chromedriver.exe";
    public WebDriver driver ;
    public WebDriverWait wait;


    // Constants
    By item_box = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]");
    By backpack_link= By.xpath("//*[@id=\"item_4_img_link\"]");
    By backpack_title = By.xpath("//*[@id='inventory_item_container']/div/div/div[2]/div[1]");
    By backpack_desc = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]");
    By backpack_price = By.cssSelector(".inventory_details_price");
    By backpack_to_cart = By.cssSelector("#add-to-cart-sauce-labs-backpack");
    By back_link = By.cssSelector("#back-to-products");
    By jacket_to_cart = By.cssSelector("#add-to-cart-sauce-labs-fleece-jacket");
    By cart_link = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    By checkout_link = By.cssSelector("button[name='checkout']");
    By first_name_tb = By.cssSelector("input[placeholder='First Name']");
    By surname_tb = By.cssSelector("input[placeholder='Last Name']");
    By zip_code_tb = By.cssSelector("input[placeholder='Zip/Postal Code']");
    By continue_link= By.cssSelector("input[name='continue']");
    By finish_link = By.cssSelector("button[name='finish']");
    By header_tnx = By.cssSelector("h2[class='complete-header']");
    By burger_menu = By.cssSelector("#react-burger-menu-btn");
    By logout_link = By.cssSelector("a[id='logout_sidebar_link']");

    String expected_title = "Sauce Labs Backpack";
    String expected_desc = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
    String expected_price = "$29.99";

    String thank_you_header= "THANK YOU FOR YOUR ORDER";


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

        //Verifying login page

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

        // Clicking on the 'login' button
        login_button.click();
        System.out.println("Congrats you have successfully logged in!");



        //Verifying that the page is loaded and clicking on the backpack item
        wait.until(ExpectedConditions.presenceOfElementLocated(item_box));
        WebElement item = driver.findElement(backpack_link);
        item.click();

        //Verifying that backpack product page is loaded and the title of the product
        wait.until(ExpectedConditions.presenceOfElementLocated(backpack_title));
        String title_product = driver.findElement(backpack_title).getText();
        Assert.assertEquals(title_product, expected_title);
        System.out.println("Title of the product is: "+ title_product);

        //Verifying a description of the backpack
        wait.until(ExpectedConditions.presenceOfElementLocated(backpack_desc));
        String description_product = driver.findElement(backpack_desc).getText();
        Assert.assertEquals(description_product, expected_desc);
        System.out.println("Description of the product is: "+ description_product);


        //Verifying a price of the backpack
        wait.until(ExpectedConditions.presenceOfElementLocated(backpack_price));
        String price_product = driver.findElement(backpack_price).getText();
        Assert.assertEquals(price_product, expected_price);
        System.out.println("Price of the product is: "+ price_product);


        //Verifying the "add to cart" button and clicking it
        wait.until(ExpectedConditions.presenceOfElementLocated(backpack_to_cart));
        WebElement add_cart = driver.findElement(backpack_to_cart);
        add_cart.click();
        System.out.println("Clicked add to cart");

        //Verifying the return button and clicking it
        wait.until(ExpectedConditions.presenceOfElementLocated(back_link));
        WebElement back = driver.findElement(back_link);
        back.click();
        System.out.println("Clicked back home");

        //Verifying that fleece jacket is loaded and adding it to the cart
        wait.until(ExpectedConditions.presenceOfElementLocated(jacket_to_cart));
        WebElement add_cart_home = driver.findElement(jacket_to_cart);
        add_cart_home.click();
        System.out.println("Clicked add to cart at homepage");

        //Verifying the shopping cart button and clicking it
        wait.until(ExpectedConditions.presenceOfElementLocated(cart_link));
        WebElement cart = driver.findElement(cart_link);
        cart.click();
        System.out.println("Clicked on shooping cart");

        //Verifying the checkout button and clicking it
        wait.until(ExpectedConditions.presenceOfElementLocated(checkout_link));
        WebElement checkout = driver.findElement(checkout_link);
        checkout.click();
        System.out.println("Clicked on checkout");

        //Verifying the "first name" input textbox and filling it in
        wait.until(ExpectedConditions.presenceOfElementLocated(first_name_tb));
        WebElement name = driver.findElement(first_name_tb);
        name.sendKeys("Mateja");
        System.out.println("Typed first name");


        //Verifying the "surname" input textbox and filling it in
        wait.until(ExpectedConditions.presenceOfElementLocated(surname_tb));
        WebElement surname = driver.findElement(surname_tb);
        surname.sendKeys("Jovanovic");
        System.out.println("Typed surname");


        //Verifying the "zip code" input textbox and filling it in
        wait.until(ExpectedConditions.presenceOfElementLocated(zip_code_tb));
        WebElement postal_code = driver.findElement(zip_code_tb);
        postal_code.sendKeys("11000");
        System.out.println("Typed postal code");


        //Verifying  "continue to the checkout" button and clicking it
        wait.until(ExpectedConditions.presenceOfElementLocated(continue_link));
        WebElement continue_checkout = driver.findElement(continue_link);
        continue_checkout.click();
        System.out.println("Clicked continue to the checkout");


        //Verifying  "finish" button and clicking it
        wait.until(ExpectedConditions.presenceOfElementLocated(finish_link));
        WebElement finish = driver.findElement(finish_link);
        finish.click();
        System.out.println("Clicked on finish");


        //Verifying  header text
        wait.until(ExpectedConditions.presenceOfElementLocated(header_tnx));
        Assert.assertEquals(driver.findElement(header_tnx).getText(),  thank_you_header);
        System.out.println("Text verified successfully");


        //Verifying  burger menu and clicking it
        wait.until(ExpectedConditions.presenceOfElementLocated(burger_menu));
        WebElement brgr = driver.findElement(burger_menu);
        brgr.click();


        //Verifying logout option from the burger menu and clicking it
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
