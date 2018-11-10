package ru.webim.demo.POM.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.webim.demo.POM.Driver;


import java.util.List;

public class OperatorPage {
    private static WebDriver driver = Driver.GetDriver();

    private static WebElement NameTextField = driver.findElement(By.id("login_or_email"));
    private static WebElement PasswordTextField = driver.findElement(By.id("password"));
    private static WebElement SubmitButton = driver.findElement(By.xpath("//button[@type='submit']"));
    private static String OperatorChatXpath = "//div[@class='input_panel']//textarea[@name='chat_message_textarea']";
    private static String PictureXpath = "//div[@class='message_inner']//img[contains(@src,'download')]";
    private static String TruePictureXpath = "//div[@class='message_inner']//img[contains(@src,'test.jpg')]";
    private static String OperatorMessageXpath = "//div[@op-id='33202']//span[@class='message_text']";


    public static void SetName(String name) {
        NameTextField.sendKeys(name);
    }

    public static void SetPassword(String password) {
        PasswordTextField.sendKeys(password);
    }


    public static void ClickSubmitButton() {
        SubmitButton.click();
    }

    public static void Login(String name, String password) {
        SetName(name);
        SetPassword(password);
        ClickSubmitButton();
    }

    public static void VisitorSectionOpen() {
        List<WebElement> VisitorSection = driver.findElements(By.xpath("//section[@id='visitors_list']/div/ul/li"));
        VisitorSection.get(0).click();

    }

    public static void SendOperatorMessage(String message) {
        WebElement OperatorChatTextArea = driver.findElement(By.xpath(OperatorChatXpath));
        OperatorChatTextArea.sendKeys(message);
        OperatorChatTextArea.sendKeys(Keys.ENTER);
    }

    public static boolean CheckPicture() {

        WebElement TruePicture = driver.findElement(By.xpath(TruePictureXpath));
        boolean PictureIsTrue = TruePicture.isDisplayed();
        return PictureIsTrue;

    }

    public static void WaitDownload() throws InterruptedException {
        int i = 0;
        WebElement Picture = driver.findElement(By.xpath(PictureXpath));
        while (!Picture.isDisplayed() && i < 20) {
            i++;
            Thread.sleep(300);
        }
    }
    public static void WaitMessage() throws InterruptedException {
        int i = 0;
        WebElement OperatorMessage = driver.findElement(By.xpath(OperatorMessageXpath));
        while (!OperatorMessage.isDisplayed() && i < 20) {
            i++;
            Thread.sleep(300);
        }
        Thread.sleep(1000);
    }
    public static String GetOperatorMessage() {
        WebElement OperatorMessage = driver.findElement(By.xpath(OperatorMessageXpath));
        String message = OperatorMessage.getText();
        return message;


    }


}


