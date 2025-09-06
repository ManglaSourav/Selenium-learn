package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateEmployeePage {

    WebDriver driver;


    private By txtName  = By.id("Name");
    private By txtSalary  = By.id("Salary");
    private By txtDurationWorked  = By.id("DurationWorked");
    private By txtEmail  = By.id("Email");
    private By lnkGrade = By.id("Grade");
    private Select selectGrade;
    private By btnCreate = By.cssSelector(".btn");

    public CreateEmployeePage(WebDriver driver){
        this.driver = driver;
        this.selectGrade = new Select(driver.findElement(this.lnkGrade));
    }

    public EmployeeListPage createEmployee(WebDriver driver, String name, String salary, String durationWorked, String email, String grade){
        driver.findElement(txtName).sendKeys(name);
        driver.findElement(txtSalary).sendKeys(salary);
        driver.findElement(txtDurationWorked).sendKeys(durationWorked);
        driver.findElement(txtEmail).sendKeys(email);
        selectGrade.selectByVisibleText(grade);

        driver.findElement(btnCreate).click();
        return new EmployeeListPage(driver);
    }




}
