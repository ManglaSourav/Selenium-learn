package gettingStarted;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestNGTest1 {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeTest
    public void RunBeforeMethod(){
        driver = new ChromeDriver();

        driver.navigate().to("http://eaapp.somee.com/");
    }

    @Test
    public void testLogin(){
        this.homePage = new HomePage(driver);
        this.loginPage = this.homePage.clickLogin();
    }

    @Parameters({"username", "password"})
    @Test
    public void testCreateEmployee(String username, String password){
        homePage = loginPage.performLogin(username, password);
        var employeeListPage = homePage.clickEmployeeList();
        var createEmployeePage = employeeListPage.performCreateEmployee(driver);
        createEmployeePage.createEmployee(driver,"testing", "10101","11", "testing@gmail.com", "Senior");

    }

    @Test
    public void testLogin2(){
        System.out.println("Testing the login operation2");
    }
    @Test
    public void testLogin3(){
        System.out.println("Testing the login operation3");
    }

    @BeforeTest
    public void RunBeforeTest() {
        System.out.println("Running before");
    }

    @AfterTest
    public void AfterTestExecution(){
        System.out.println("Quitting the webdriver");
        driver.quit();
    }
}
