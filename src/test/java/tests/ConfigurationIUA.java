package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;

public class ConfigurationIUA extends TestRunner{
    @BeforeTest
    public void openPage () {
        Configuration.timeout=10000;
        open ("https://www.i.ua/");
    }
}
