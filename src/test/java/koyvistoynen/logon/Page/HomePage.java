package koyvistoynen.logon.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    Links links = new Links();
    String url = links.getHomePage();

    By entry_title = By.className("entry-title");
    By siteTitle = By.linkText("Admin Blog");
    By page_links = By.className("nav-links");
    By page_next = By.xpath("//*[@id=\"main\"]/nav/div/a[4]");
    By page_prev = By.xpath("//*[@id=\"main\"]/nav/div/a[1]");
    By newEntries = By.xpath(".//*[text()='Свежие записи']/.");
    By rubric = By.xpath(".//*[text()='Рубрики']/.");
    By tags = By.xpath(".//*[text()='Метки']/.");
    By docker = By.xpath(".//*[text()='Docker']/.");
    By backup = By.xpath(".//*[text()='Резервное копирование']/.");
    By meta_data = By.className("meta-date");
    By meta_author = By.className("meta-author");
    By meta_category = By.className("meta-category");
    By more_link = By.className("more-link");


    /**Открываем страницу**/
    public HomePage open() {
        driver.get(this.url);
        return this;
    }

    /**Проверка отображения заглавия сайта"**/
    public void checkSiteTitle() {
        find(siteTitle).isDisplayed();
    }

    /**Проверка отображения заголовков 10 статей на странице сайта"**/
    public void checkCountTitle() {
        int count = driver.findElements(entry_title).size();
        Assert.assertEquals(10,count);

    }

    /**Проверка отображения метаданных статей (дата, автор, категория)"**/
    public void checkMetaEntry() {
        find(meta_data).isDisplayed();
        find(meta_author).isDisplayed();
        find(meta_category).isDisplayed();
        int count_meta_data = driver.findElements(meta_data).size();
        int count_meta_author = driver.findElements(meta_author).size();
        int count_meta_category = driver.findElements(meta_category).size();
        Assert.assertEquals(10,count_meta_data);
        Assert.assertEquals(10,count_meta_author);
        Assert.assertEquals(10,count_meta_category);
    }

    /**Проверка ссылки "Читать>>"**/
    public void checkMoreLink(){
        find(more_link).isDisplayed();
        int count = driver.findElements(more_link).size();
        Assert.assertEquals(10,count);
    }

    /**Проверка отображения переключения страниц"**/
    public void checkPageLink() {
        find(page_links).isDisplayed();
        find(page_next).click();
        find(page_prev).click();
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
        checkPageLink();
        checkCountTitle();
        checkMetaEntry();
        checkMoreLink();
    }

}
