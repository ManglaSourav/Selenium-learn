package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By lnkLogin = By.linkText("Login");
    private By lnkEmloyeeList = By.linkText("Employee List");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickLogin(){
        driver.findElement(lnkLogin).click();
        return new LoginPage(driver);
    }

    public EmployeeListPage clickEmployeeList(){
        driver.findElement(lnkEmloyeeList).click();
        return new EmployeeListPage(driver);
    }

}
