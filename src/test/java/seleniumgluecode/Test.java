package seleniumgluecode;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Test extends TestBase{

    @Given("^The user is in the WhatsApp Web Page$")
    public void the_user_is_in_the_WhatsApp_Web_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement searchBar = driver.findElement(wspDefaultPage.getSearchBar());



        //wait until the searchbar is visible

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assert.assertTrue("Login Failed",searchBar.isDisplayed());
    }

    @When("^the user searches for the chatbot contact: \"([^\"]*)\"$")
    public void the_user_searches_for_the_chatbot_contact(String strContact) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement searchBar = driver.findElement(wspDefaultPage.getSearchBar());
        searchBar.sendKeys(strContact);

        //wait for the number of contacts to be 1
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //click on the first contact.

        WebElement contactCard=driver.findElement(wspDefaultPage.getContact());
        contactCard.click();


    }

    @Then("^writes in \"([^\"]*)\"$")
    public void writes_in(String strRequest) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement textBox = driver.findElement(wspDefaultPage.getInputTextBox());
        textBox.sendKeys(strRequest);

        WebElement sendButton=driver.findElement(wspDefaultPage.getSendButton());
        sendButton.click();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement lastMessage = driver.findElement(wspDefaultPage.getLastMessage());
        //System.out.println(lastMessage.getText() + "!=" + strRequest);

        Assert.assertNotEquals(strRequest,lastMessage.getText());
        //WhatsApp Messages contain the message itself and the time it was sent
        //Checking that the chatbot has responded

        Assert.assertFalse(lastMessage.getText().contains(strRequest));
    }

    @Then("^the main menu should be shown$")
    public void the_main_menu_should_be_shown() throws Throwable {
        WebElement lastMessage = driver.findElement(wspDefaultPage.getLastMessage());

        Assert.assertTrue(lastMessage.getText().contains(wspDefaultPage.getStrMenu()));

        System.out.println(lastMessage.getText());

    }
}
