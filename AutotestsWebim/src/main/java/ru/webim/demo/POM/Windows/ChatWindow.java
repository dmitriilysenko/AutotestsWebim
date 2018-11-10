package ru.webim.demo.POM.Windows;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.webim.demo.POM.Driver;

import java.util.List;

public class ChatWindow {
    private static WebDriver driver = Driver.GetDriver();

    private static WebElement ChatTextArea = driver.findElement(By.xpath("//div[@class='webim-dialogue-message-block']//div[contains(@class,'webim-message-area')]"));
    private static WebElement OperatorRateButton = driver.findElement(By.xpath("//li[@class='webim-chat-action webim-chat-action-rate']"));
    private static WebElement SendRateButton = driver.findElement(By.xpath("//button[@data-webim-widget-action='send-rate']"));
    private static WebElement MoreButton = driver.findElement(By.xpath("//span[@class='webim-icon webim-icon-actions']"));
    private static WebElement UploadFileButton = driver.findElement(By.xpath("//li[@class='webim-chat-action webim-chat-action-upload']//input[@type='file']"));
    private static String rateXpath = "//ul[@class='webim-form-control webim-operator-rate']/li";
    private static String MessagesXpath = "//li[@class='webim-message webim-visitor-message webim-ready']/div";
    private static String PictureXpath = "//div[@class='webim-message-body']//img[contains(@src,'https://demo.webim.ru/l/v/download')]";
    private static String TruePictureXpath = "//div[@class='webim-message-body']//img[contains(@src,'test.jpg')]";
    private static String SuccessRatingXpath = "//div[@class='webim-overlays-wrapper']//div[@class='webim-overlay webim-rate-block webim-success']";
    private static String OperatorNotificationXpath = "//div[@class='webim-message-body']//span[contains(@span,'включился в разговор')]";


    public static void SendMessage(String message) {
        ChatTextArea.sendKeys(message);
        ChatTextArea.sendKeys(Keys.ENTER);
    }

    public static void UploadFile() {
        File picture = new File("./test.jpg");
        String path = picture.getAbsolutePath();
        MoreButton.click();
        UploadFileButton.sendKeys(path);
    }

    public static void WaitDownload() throws InterruptedException {
        int i = 0;
        WebElement Picture = driver.findElement(By.xpath(PictureXpath));
        while (!Picture.isDisplayed() && i < 20) {
            i++;
            Thread.sleep(300);
        }
    }

    public static boolean CheckPicture() {

        WebElement TruePicture = driver.findElement(By.xpath(TruePictureXpath));
        boolean PictureIsTrue = TruePicture.isDisplayed();
        return PictureIsTrue;

    }

    public static String GetUserMessage() {
        List<WebElement> Messages = driver.findElements(By.xpath(MessagesXpath));
        String message = Messages.get(2).getText();
        return message;


    }

    public static void RateOperator(int rate) {
        OperatorRateButton.click();
        List<WebElement> OperatorRateStars = driver.findElements(By.xpath(rateXpath));
        OperatorRateStars.get(rate - 1).click();
        SendRateButton.click();
    }

    public static boolean CheckRating() {
        WebElement SuccessfulRating = driver.findElement(By.xpath(SuccessRatingXpath));
        boolean RatingIsSuccessful = SuccessfulRating.isDisplayed();
        return RatingIsSuccessful;

    }
    public static void WaitOperator() throws InterruptedException {
        int i = 0;
        WebElement OperatorNotification = driver.findElement(By.xpath(OperatorNotificationXpath));
        while (!OperatorNotification.isDisplayed() && i < 20) {
            i++;
            Thread.sleep(300);
        }
    }
}
