package koyvistoynen.logon;

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
    @Test
    public void negativeLogonPage() {
        LogonPage page = new LogonPage(driver);
        page.negativeAuth();
    }

    /**Тест главной страницы*/
    @Test
    public void homePage() {
        HomePage page = new HomePage(driver);
        page.start();
    }

}
