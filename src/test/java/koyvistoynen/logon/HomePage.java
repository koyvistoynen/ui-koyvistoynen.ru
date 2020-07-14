package koyvistoynen.logon;

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

    public HomePage open() {
        driver.get(this.url);
        return this;
    }

    public void checkSiteTitle() {
        find(siteTitle).isDisplayed();
    }

    public void checkNewEntries() {
        find(newEntries).isDisplayed();
    }

    public void checkRubric() {
        find(rubric).isDisplayed();
    }

    public void checkTags() {
        find(tags).isDisplayed();
    }

    public void additionalPage() {
        find(docker).isDisplayed();
        find(backup).isDisplayed();
    }

    public void start() {
        open();
        checkSiteTitle();
        checkNewEntries();
        checkRubric();
        checkTags();
        additionalPage();
    }

}
