package koyvistoynen.logon.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    Links links = new Links();
    String url = links.getHomePage();

    By siteTitle = By.linkText("Admin Blog");
    By newEntries = By.xpath(".//*[text()='Свежие записи']/.");
    By rubric = By.xpath(".//*[text()='Рубрики']/.");
    By tags = By.xpath(".//*[text()='Метки']/.");
    By docker = By.xpath(".//*[text()='Docker']/.");
    By backup = By.xpath(".//*[text()='Резервное копирование']/.");

    /**Открываем страницу**/
    public HomePage open() {
        driver.get(this.url);
        return this;
    }

    /**Проверка отображения заглавия сайта"**/
    public void checkSiteTitle() {
        find(siteTitle).isDisplayed();
    }

    /**Проверка отображения "Свежих записей"**/
    public void checkNewEntries() {
        find(newEntries).isDisplayed();
    }

    /**Проверка отображения блока "Рубрики"**/
    public void checkRubric() {
        find(rubric).isDisplayed();
    }

    /**Проверка отображения облака меток**/
    public void checkTags() {
        find(tags).isDisplayed();
    }

    /**Проверка отображения страниц**/
    public void additionalPage() {
        find(docker).isDisplayed(); //Страница Docker
        find(backup).isDisplayed(); //Страница Backup
    }

    /**Запуск проверки домашней страницы**/
    public void start() {
        open();
        checkSiteTitle();
        checkNewEntries();
        checkRubric();
        checkTags();
        additionalPage();

    }

}
