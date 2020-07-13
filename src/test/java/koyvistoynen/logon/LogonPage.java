package koyvistoynen.logon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogonPage extends BasePage {

    public LogonPage(WebDriver driver) {
        super(driver);
    }

    String url = "https://koyvistoynen.ru/admin";
    By username = By.id("user_login");
    By password = By.id("user_pass");
    By buttonSubmit = By.id("wp-submit");
    By errorMessage = By.id("login_error");
    By rememberMe = By.id("rememberme");

    public LogonPage setUserName(String userName){
        find(username).sendKeys(userName);
        return this;
    }

    public LogonPage setPassword(String userPassword){
        find(password).sendKeys(userPassword);
        return this;
    }

    public LogonPage open() {
        driver.get(this.url);
        return this;
    }

    public LogonPage submit() {
        find(buttonSubmit).submit();
        return this;
    }

    public void rememberMeCheck() {
        find(rememberMe).isDisplayed();
    }

    public void view_error() {
        find(errorMessage).isDisplayed();
    }

    public void negativeAuth(){
        open();
        setUserName("BadLogin");
        setPassword("BadPassword");
        rememberMeCheck();
        submit();
        view_error();

    }
}