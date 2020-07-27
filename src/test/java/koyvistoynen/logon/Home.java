package koyvistoynen.logon;

import koyvistoynen.logon.Page.HomePage;
import koyvistoynen.logon.Page.LogonPage;
import koyvistoynen.logon.Page.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class Home {

    public WebDriver driver;
    public WebDriverWait wait;

    /**Первоначальная настройка*/
    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    /**Закрываем chromedriver после выполнения всех тестов*/
    @AfterSuite
    public void close() {
        driver.quit();
    }

    /**Проверка некорректной авторизации*/
    @Test(description = "Проверка на некорректную авторизацию"
            ,dependsOnMethods = "homePage")
    public void negativeLogonPage() {
        LogonPage page = new LogonPage(driver);
        page.negativeAuth();
    }

    /**Проверка сообщений ошибок авторизации**/
    @Test(description = "Проверка на некорректную авторизацию"
            ,dependsOnMethods = "homePage")
    public void blankField() {
        LogonPage page = new LogonPage(driver);
        page.blankField();
    }

    /**Проверка корректной авторизации*/
    @Test(description = "Проверка на корректную авторизацию"
            ,dependsOnMethods = "homePage")
    public void positiveLogonPage() {
        LogonPage page = new LogonPage(driver);
        page.positiveAuth();
    }

    /**Тест главной страницы*/
    @Test(description = "Тест главной страницы")
    public void homePage() {
        HomePage page = new HomePage(driver);
        page.start();
    }

    /**Тест страницы поиска*/
    @Test(description = "Тест страницы поиска")
    public void check_search() {
        SearchPage page = new SearchPage(driver);
        page.check_search();

    }

}
