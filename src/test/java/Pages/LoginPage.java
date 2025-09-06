package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id="UserName")
    private WebElement userName;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(css = ".btn")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver){
        this.driver  = driver;
        PageFactory.initElements(driver, this);
    }


    public HomePage performLogin(String userName, String password){
//        driver.findElement(this.userName).sendKeys(userName);
//        driver.findElement(this.password).sendKeys(password);
//        driver.findElement(this.loginBtn).click();
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.loginBtn.click();
        return new HomePage(driver);
    }




}
