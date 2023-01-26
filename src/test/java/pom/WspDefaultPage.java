package pom;

import org.openqa.selenium.By;

public class WspDefaultPage {

    private By searchBar = By.xpath("//div[@data-testid='chat-list-search']");

    private By inputTextBox=By.xpath("//div[@data-testid='conversation-compose-box-input']");

    private By contact=By.xpath("//div[@data-testid='cell-frame-container']");

    private By lastMessage=By.xpath("(//div[@data-testid='msg-container'])[last()]");

    private By sendButton=By.xpath("//span[@data-testid='send']");

    private String strMenu=
            "Hola, que deseas realizar?\n" +
            "1. Asignar turnos\n" +
            "2. Ver mis turnos\n" +
            "3. Cancelar turnos\n" +
            "4. Intercambiar turnos";

    public By getSearchBar() {
        return searchBar;
    }

    public By getInputTextBox() {
        return inputTextBox;
    }

    public By getContact() {
        return contact;
    }

    public By getLastMessage() {
        return lastMessage;
    }

    public By getSendButton() {
        return sendButton;
    }

    public String getStrMenu() {
        return strMenu;
    }
}
