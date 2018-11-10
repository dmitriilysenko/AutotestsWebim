package ru.webim.demo.POM.Pages;

import Helpers.WebElementActions;
import org.openqa.selenium.*;
import ru.webim.demo.POM.Driver;


public class MainPage {

    private static WebDriver driver = Driver.GetDriver();

    private static WebElement ChatOpenButton = driver.findElement(By.xpath("//a[@data-webim-container='Base']"));
    private static WebElement ChatCloseButton = driver.findElement(By.xpath("//div[@id='webim_chat']//div[@class='webim-action webim-action-close']"));
    private static WebElement WebimChat = driver.findElement(By.id("webim_chat"));

    public static void ChatOpen() throws InterruptedException {
        WebElementActions.TryClick(ChatOpenButton);
    }

    public static void ChatClose() {
        ChatCloseButton.click();
    }

    public static boolean IsChatOpen() {
        boolean WebimChatIsOpen = WebimChat.isDisplayed();
        return WebimChatIsOpen;
    }


}

