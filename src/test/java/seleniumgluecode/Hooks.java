package seleniumgluecode;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.util.concurrent.TimeUnit;

public class Hooks {

    //private static ChromeDriver driver;
    private static ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver");

        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();

        //Profile 2 ("Test")
        options.addArguments("user-data-dir=/Users/david.heredia/Library/Application Support/Google/Chrome/");
        options.addArguments("profile-directory=Profile 3");


        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        //Starting Driver Object:
        //CORREGIR ACÁ
        driver=new ChromeDriver(options);
        //driver=new ChromeDriver();


        //Setting implicit wait time:
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Getting into the page:
        driver.get("https://web.whatsapp.com/");


        //sleep to scan QR code

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //Maximizing the page:
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    public static ChromeDriver getDriver(){
        return driver;
    }


}
