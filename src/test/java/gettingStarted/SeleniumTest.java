package gettingStarted;

import Pages.EmployeeListPage;
import Pages.HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import com.intuit.karate.Runner;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        Runner.path("src/test/java/gettingStarted").parallel(0);

        WebDriver driver = new ChromeDriver();

//        driver.manage().window().fullscreen();
//        driver.navigate().to("https://bing.com");
        driver.navigate().to("http://eaapp.somee.com/");
        HomePage homePage = new HomePage(driver);
        var loginPage = homePage.clickLogin();
        homePage = loginPage.performLogin("admin", "password");
        var employeeListPage = homePage.clickEmployeeList();
        var createEmployeePage = employeeListPage.performCreateEmployee(driver);
        employeeListPage = createEmployeePage.createEmployee(driver, "testing", "10101", "11", "testing@gmail.com", "Senior");


        //        Login(driver);
//        CreateUser(driver);
//        Logoff(driver);
    }


    public static void Login(WebDriver driver) {

//        System.out.println("here se"+driver.getPageSource());
//        click on login link
//        1. identify the login link using its ID
//        By locator = By.id("loginLink");
        By locator2 = By.linkText("Login");

//        2. pass this locator to webdriver which can help me to do operation on it
        WebElement element = driver.findElement(locator2);

//        3. perform operation on the UI - click
        element.click();

//        4. fill data
        driver.findElement(By.id("UserName")).sendKeys("admin");
        driver.findElement(By.id("Password")).sendKeys("password");
//        driver.findElement((By.id("loginIn"))).click();
        driver.findElement(By.cssSelector(".btn")).submit();

    }

    public static void CreateUser(WebDriver driver) {

        driver.findElement(By.linkText("Employee List")).click();
        driver.findElement(By.linkText("Create New")).click();

        driver.findElement(By.id("Name")).sendKeys("Testt1");
        driver.findElement(By.id("DurationWorked")).sendKeys("12");
        driver.findElement(By.id("Email")).sendKeys("Test@gmail.com");
        Select selector = new Select(driver.findElement(By.id("Grade")));
        selector.selectByIndex(3);
        selector.selectByVisibleText("Middle");
        driver.findElement(By.cssSelector(".btn")).click();

        if (driver.findElement(By.xpath("//span[text()='The Salary field is required.']")).isDisplayed()) {
            System.out.println("No xpath found");

            driver.findElement(By.id("Salary")).sendKeys("1221212");

            driver.findElement(By.cssSelector(".btn")).click();

        } else {
            System.out.println("No xpath found");
        }


    }

    public static void Logoff(WebDriver driver) {
        driver.findElement(By.linkText("Log off")).click();
    }
}

