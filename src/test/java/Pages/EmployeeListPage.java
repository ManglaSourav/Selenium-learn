package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeListPage {

    private WebDriver driver;
    private By lnkCreateEmployee = By.linkText("Create New");

    public EmployeeListPage(WebDriver driver){
        this.driver = driver;
    }

    public CreateEmployeePage performCreateEmployee(WebDriver driver){
       driver.findElement(lnkCreateEmployee).click();
       return new CreateEmployeePage(driver);
    }





}
