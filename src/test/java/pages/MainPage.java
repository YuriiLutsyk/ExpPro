package pages;

import com.codeborne.selenide.SelenideElement;
import tests.TestRunner;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;


public class MainPage extends TestRunner {
    private final SelenideElement
            vhid = $(".first [href=\"https://passport.i.ua/login/\"]"),
            login = $("li [name=\"login\"]"),
            password = $("li [name=\"pass\"]"),
            uviithu = $("p [value=\"Увійти\"]"),
            loginInFrame = $(".form p [name=\"login\"]"),
            passwordInFrame = $("#FloatLogin * > p [name=\"pass\"]"),
            uviithuInFrame = $(".form [value=\"Увійти\"]"),
            iuaIcon = $(".ho_logo"),
            vuchid = $(".right [title=\"вийти\"]"),
            searchField = $("#searchQ"),
            znaithu = $("* > form > input[type=submit]"),
            organaizer = $("li > [title=\"Органайзер\"]"),
            profil = $("li > [title=\"профіль\"]"),
            poshta = $("li > [title=\"Пошта\"]");


    public SelenideElement getVhid() {
        return vhid;
    }

    public SelenideElement getLogin() {
        return login;
    }

    public SelenideElement getPassword() {
        return password;
    }

    public SelenideElement getUviithu() {
        return uviithu;
    }

    public SelenideElement getLoginInFrame() {
        return loginInFrame;
    }

    public SelenideElement getPasswordInFrame() {
        return passwordInFrame;
    }

    public SelenideElement getUviithuInFrame() {
        return uviithuInFrame;
    }

    public SelenideElement getIuaIcon() {
        return iuaIcon;
    }

    public SelenideElement getVuchid() {
        return vuchid;
    }

    public SelenideElement getSearchField() {
        return searchField;
    }

    public SelenideElement getZnaithu() {
        return znaithu;
    }

    public SelenideElement getOrganaizer() {
        return organaizer;
    }

    public SelenideElement getProfil() {
        return profil;
    }

    public SelenideElement getPoshta() {
        return poshta;
    }

    public MainPage clickOnOrganaizer() {
        getOrganaizer().shouldBe(enabled).click();
        return this;
    }

    public void clickOnProfil() {
        getProfil().shouldBe(enabled).click();
    }

    public void clickOnVhid() {
        getVhid().shouldBe(enabled).click();
    }

    public MainPage clickOnUviithu() {
        getUviithu().shouldBe(enabled).click();
        return this;
    }

    public void clickOnUviithuUpper() {
        getUviithuInFrame().shouldBe(enabled).click();
    }

    public MainPage clickOnGetIuaIcon() {
        getIuaIcon().shouldBe(enabled).click();
        return this;
    }

    public void clickOnVuchid() {
        getVuchid().shouldBe(enabled).click();
    }

    public void fillOutLoginUpper() {
        getLoginInFrame().shouldBe(enabled).setValue("yurii.test7");
    }

    public void fillOutPasswordUpper() {
        getPasswordInFrame().shouldBe(enabled).setValue("7721qweQ");
    }

    public MainPage fillOutLogin(String login) {
        getLogin().shouldBe(enabled).setValue(login);
        return this;
    }

    public MainPage fillOutIncorrectLogin() {
        getLogin().shouldBe(enabled).setValue("yurii.test");
        return this;
    }

    public MainPage fillOutIncorrectPassword() {
        getPassword().shouldBe(enabled).setValue("7721qweW");
        return this;
    }

    public MainPage fillOutPassword(String password) {
        getPassword().shouldBe(enabled).setValue(password);
        return this;
    }

    public void fillOutSearchField() {
        getSearchField().shouldBe(enabled).setValue("cat");
    }

    public void clickOnZnaithu() {
        getZnaithu().shouldBe(enabled).click();
    }

    public void clickOnPoshta() {
        getPoshta().shouldBe(enabled).click();
    }


    public MainPage firstLoginFlow() {
        fillOutLogin(props.getProperty("firstUser.username"));
        fillOutPassword(props.getProperty("firstUser.password"));
        clickOnUviithu();
        return this;
    }

    public MainPage logOutFlow() {
        clickOnGetIuaIcon();
        clickOnVuchid();
        return this;
    }

    public MainPage secondLoginFlow() {
        clickOnVhid();
        switchTo().parentFrame();
        fillOutLoginUpper();
        fillOutPasswordUpper();
        clickOnUviithuUpper();
        return this;
    }

    public MainPage searchCat() {
        fillOutSearchField();
        clickOnZnaithu();
        return this;
    }

    public MainPage incorrectLogin() {
        fillOutIncorrectLogin();
        fillOutPassword(props.getProperty("firstUser.password"));
        clickOnUviithu();
        return this;
    }
}



