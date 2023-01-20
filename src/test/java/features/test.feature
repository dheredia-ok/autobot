Feature: Chatbot Automation
  As a user, I'd like to login to WhatsApp Web and talk to the Chatbot

  Scenario: Say Hello and Retrieve the Main Menu
    Given The user is in the WhatsApp Web Page
    When the user searches for the chatbot contact: "+51 958 438 106"
    Then writes in "hola"
    Then the main menu should be shown
    Then writes in "cancelar"