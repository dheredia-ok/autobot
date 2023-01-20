package seleniumgluecode;

import cucumber.api.java.eo.Se;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.LoginPage;
import pom.SetupPage;
import pom.WspDefaultPage;

public class TestBase {
    protected ChromeDriver driver=Hooks.getDriver();
    protected WspDefaultPage wspDefaultPage=new WspDefaultPage();

}
