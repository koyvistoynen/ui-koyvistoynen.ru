package koyvistoynen.logon.Page;

public class Links {

    /**Домашняя страница"**/
    private String homePage = "https://koyvistoynen.ru";
    public String getHomePage() {
        return homePage;
    }

    /**Страница авторизации"**/
    private String authPage = homePage + "/admin";
    public String getAuthPage() {
        return authPage;
    }

    /**Страница поиска"**/
    private String searchPage = homePage + "/?s=";
    public String getSearchPage() {
        return searchPage;
    }

}
