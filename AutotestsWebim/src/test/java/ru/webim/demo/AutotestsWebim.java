package ru.webim.demo;

import Helpers.Tabs;
import org.junit.Assert;
import org.junit.Test;
import ru.webim.demo.POM.Driver;
import ru.webim.demo.POM.Pages.MainPage;
import ru.webim.demo.POM.Pages.OperatorPage;
import ru.webim.demo.POM.Windows.ChatWindow;


public class AutotestsWebim extends Base {


    @Test
    public void userLogin() throws InterruptedException {
        String VisitorMessage = "Hello world!";
        String OperatorMessage = "Hello darling";
        String name = "o@webim.ru";
        String password = "password";
        String operatorLoginUrl = "https://login.webim.ru/operator";
        String operatorWorkplaceUrl = "https://demo.webim.ru/operator/track.php";

        Tabs.OpenNewTab();
        Tabs.SwitchToSecondTab();

        Driver.GetDriver().get(operatorLoginUrl);
        OperatorPage.Login(name, password);
        Driver.GetDriver().get(operatorWorkplaceUrl);

        Tabs.SwitchToFirstTab();

        MainPage.ChatOpen();
        Assert.assertTrue(MainPage.IsChatOpen());
        MainPage.ChatClose();
        Assert.assertFalse(MainPage.IsChatOpen());
        MainPage.ChatOpen();
        ChatWindow.SendMessage(VisitorMessage);
        String ActualMessage = ChatWindow.GetUserMessage();
        Assert.assertEquals(VisitorMessage, ActualMessage);
        ChatWindow.UploadFile();
        ChatWindow.WaitDownload();
        Assert.assertTrue(ChatWindow.CheckPicture());

        Tabs.SwitchToSecondTab();
        OperatorPage.VisitorSectionOpen();
        OperatorPage.SendOperatorMessage(OperatorMessage);
        OperatorPage.WaitMessage();
        String ActualOperatorMessage = OperatorPage.GetOperatorMessage();
        Assert.assertEquals(OperatorMessage,ActualOperatorMessage);
        OperatorPage.WaitDownload();
        Assert.assertTrue(OperatorPage.CheckPicture());

        Tabs.SwitchToFirstTab();
        ChatWindow.WaitOperator();
        ChatWindow.RateOperator(5);
        Assert.assertTrue(ChatWindow.CheckRating());


    }


}
