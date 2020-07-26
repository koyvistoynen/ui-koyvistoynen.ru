package koyvistoynen.logon.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    Links links = new Links();
    String url = links.getSearchPage();
    By search_field = By.className("search-field");
    By icon_search = By.className("search-submit");

    public SearchPage open() {
        driver.get(this.url);
        return this;
    }

    public void Search_field() {
        find(search_field).isDisplayed();
    }

    public void Icon_search_icon() {
        find(icon_search).isDisplayed();
    }

    public void check_search() {
        open();
        Search_field();
        Icon_search_icon();
    }

}
