package koyvistoynen.logon.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    Variables variables = new Variables(); //создаем объект для работы с переменными с variable-класса
    Links links = new Links(); //создаем объект для работы с переменными с links-класса
    String url = links.getSearchPage();

    By search_field = By.className("search-field");
    By icon_search = By.className("search-submit");

    /**Открываем url со страницей пользователя**/
    public SearchPage open() {
        driver.get(this.url);
        return this;
    }

    /**Проверка отображения поля для ввода строки поиска**/
    public void Search_field() {
        find(search_field).isDisplayed();
    }

    /**Проверка отображения иконки поиска**/
    public void Icon_search_icon() {
        find(icon_search).isDisplayed();
    }

    /**Ввод случайного текста в поле ввода**/
    public SearchPage setRandomTest(String randomTest) {
        find(search_field).sendKeys(randomTest);
        find(icon_search).sendKeys(Keys.ENTER);
        return this;
    }

    /**Запуск проверки страницы поиска**/
    public void check_search() {
        open();
        Search_field();
        Icon_search_icon();
        setRandomTest(variables.searchRandomText);
    }

}
