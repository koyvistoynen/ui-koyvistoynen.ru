package koyvistoynen.logon.Page;

public class Links {
    private String homePage = "https://koyvistoynen.ru";
    public String getHomePage() {
        return homePage;
    }

    private String authPage = homePage + "/admin";
    public String getAuthPage() {
        return authPage;
    }

    private String searchPage = homePage + "/?s=";
    public String getSearchPage() {
        return searchPage;
    }

}
