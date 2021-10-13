package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class IncorrectLoginPassword {
    private final SelenideElement
            login = $(".form [name=\"login\"]"),
            password = $(".form [name=\"pass\"]"),
            errorMessage = $("#lform_errCtrl > div"),
            uviithu = $("* > form > input[type=submit]");

    public SelenideElement getLogin() {
        return login;
    }

    public SelenideElement getPassword() {
        return password;
    }

    public SelenideElement getUviithu() {
        return uviithu;
    }

    public SelenideElement getErrorMessage() {
        return errorMessage;
    }

    public IncorrectLoginPassword checkError() {
        getErrorMessage().shouldHave(Condition.text("Невірний логін або пароль"));
        return this;
    }

    public IncorrectLoginPassword fillOutLoginErrorPage() {
        getLogin().shouldBe(Condition.enabled).setValue("yurii.test7");
        return this;
    }

    public IncorrectLoginPassword fillOutPasswordErrorPage() {
        getPassword().shouldBe(Condition.enabled).setValue("7721qweQ");
        return this;
    }

    public IncorrectLoginPassword fillOutIncLoginErrorPage() {
        getLogin().shouldBe(Condition.enabled).setValue("yurii.test");
        return this;
    }

    public IncorrectLoginPassword fillOutNothing() {
        getLogin().shouldBe(Condition.enabled).clear();
        getPassword().shouldBe(Condition.enabled).clear();
        return this;
    }

    public IncorrectLoginPassword fillOutIncPasswordErrorPage() {
        getPassword().shouldBe(Condition.enabled).setValue("7721qweW");
        return this;
    }

    public void clickOnUviithu() {
        getUviithu().shouldBe(enabled).click();
    }

    public IncorrectLoginPassword refillCorrectData() {
        fillOutLoginErrorPage();
        fillOutPasswordErrorPage();
        clickOnUviithu();
        return this;
    }

}
