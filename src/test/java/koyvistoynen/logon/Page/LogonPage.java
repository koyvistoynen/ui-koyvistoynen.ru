package koyvistoynen.logon.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogonPage extends BasePage {

    public LogonPage(WebDriver driver) {
        super(driver);
    }

    Variables variables = new Variables(); //создаем объект для работы с переменными с variable-класса
    Links links = new Links(); //создаем объект для работы с переменными с links-класса
    String url = links.getAuthPage();

    By username = By.id("user_login");
    By password = By.id("user_pass");
    By buttonSubmit = By.id("wp-submit");
    By errorMessage = By.id("login_error");
    By rememberMe = By.id("rememberme");

    /**Задаём имя пользователя**/
    public LogonPage setUserName(String userName){
        find(username).sendKeys(userName);
        return this;
    }

    /**Задаём пароль пользователя пользователя**/
    public LogonPage setPassword(String userPassword){
        find(password).sendKeys(userPassword);
        return this;
    }

    /**Открываем url**/
    public LogonPage open() {
        driver.get(this.url);
        return this;
    }

    /**Нажимаем кнопку**/
    public LogonPage submit() {
        find(buttonSubmit).submit();
        return this;
    }

    /**Проверка отображения флажка "Запомнить меня"**/
    public void rememberMeCheck() {
        find(rememberMe).isDisplayed();
    }

    /**Проверка отображения ошибки авторизации**/
    public void view_error() {
        find(errorMessage).isDisplayed();
    }

    /**Некорректная авториацзия**/
    public void negativeAuth(){
        open();
        setUserName(variables.userEmailNegative); //значения userEmailNegative берем из Variable
        setPassword(variables.userPasswordNegative); //значения userPasswordNegative берем из Variable
        rememberMeCheck();
        submit();
        view_error();
    }

    /**Корректная авториацзия**/
    public void positiveAuth(){
        open();
        setUserName(variables.userEmailPositive); //значения userEmailPositive берем из Variable
        setPassword(variables.userPasswordPositive); //значения userPasswordPositive берем из Variable
        rememberMeCheck();
        submit();
        view_error();
    }

    /**Отправка пустых полей**/
    public void blankField(){
        open();
        submit();
        view_error();
    }
}
