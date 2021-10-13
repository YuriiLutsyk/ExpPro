package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import pages.IncorrectLoginPassword;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ErrorLoginTest extends ConfigurationIUA {
    MainPage mainPage = new MainPage();
    IncorrectLoginPassword incorrectLoginPassword = new IncorrectLoginPassword();

    @Test(description = "Incorrect login", priority = 1)
    public void incorrectLoginFlow() {
        mainPage
                .fillOutIncorrectLogin()
                .fillOutPassword(props.getProperty("firstUser.password"))
                .clickOnUviithu();
        incorrectLoginPassword
                .checkError();
    }

    @Test(description = "Incorrect password", priority = 2)
    public void incorrectPasswordFlow() {
        incorrectLoginPassword
                .fillOutLoginErrorPage()
                .fillOutIncPasswordErrorPage()
                .clickOnUviithu();
        incorrectLoginPassword
                .checkError();
    }

    @Test(description = "Send nothing", priority = 3)
    public void sendNothing() {
        incorrectLoginPassword
                .fillOutNothing()
                .clickOnUviithu();
        switchTo().alert().accept();
    }

    @Test(description = "Correct login", priority = 4)
    public void correctLogin() {
        incorrectLoginPassword
                .fillOutLoginErrorPage()
                .fillOutPasswordErrorPage()
                .clickOnUviithu();
        $ (".user .user_name").shouldHave(Condition.text("Yurii773"));
    }
}
