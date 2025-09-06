package gettingStarted;

import Pages.HomePage;
import Pages.LoginPage;
import model.CreateEmployee;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestNGTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(TestNGTest.class);

    @BeforeTest
    public void RunBeforeMethod() {
        driver = new ChromeDriver();
        logger.info("Opening login page...");

        driver.navigate().to("http://eaapp.somee.com/");
    }

    @Test
    public void test_1_Login() {
        this.homePage = new HomePage(driver);
        this.loginPage = this.homePage.clickLogin();
    }


//    @Test(dataProvider="EmployeeData")
//    public void test_2_CreateEmployee(String name, String durationWorked, String email, String salary, String role){
//        homePage = loginPage.performLogin("admin","password");
//        var employeeListPage = homePage.clickEmployeeList();
//        var createEmployeePage = employeeListPage.performCreateEmployee(driver);
//        createEmployeePage.createEmployee(driver,name, durationWorked, email, salary, role);
//
//    }

//    @DataProvider(name = "EmployeeData")
//    public Object[][] createEmployeeData() {
//        return new Object[][] {
//                { "testing", "10101","11", "testing@gmail.com", "Senior"}
//        };
//    }

    @Test(dataProvider = "EmployeeData")
    public void test_2_CreateEmployee(CreateEmployee employee) {
        logger.info("Entering credentials...");

        homePage = loginPage.performLogin("admin", "password");
        var employeeListPage = homePage.clickEmployeeList();
        var createEmployeePage = employeeListPage.performCreateEmployee(driver);
        createEmployeePage.createEmployee(driver, employee.getName(), employee.getDurationWorked(), employee.getEmail(), employee.getSalary(), employee.getRole());
        logger.info("Employee Created: ");

    }

    @DataProvider(name = "EmployeeData")
    public CreateEmployee[] createEmployeeData() {
        return new CreateEmployee[]{
                new CreateEmployee("testing", "10101", "11", "testing@gmail.com", "Senior"),
        };
    }

    @Test
    public void testLogin2() {
        System.out.println("Testing the login operation2");
    }

    @Test
    public void testLogin3() {
        System.out.println("Testing the login operation3");
    }

    @BeforeTest
    public void RunBeforeTest() {
        System.out.println("Running before");
    }

    @AfterTest
    public void AfterTestExecution() {
        System.out.println("Quitting the webdriver");
        driver.quit();
    }
}
