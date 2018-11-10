package Helpers;

import org.openqa.selenium.JavascriptExecutor;
import ru.webim.demo.POM.Driver;

import java.util.ArrayList;

public class Tabs {

    public static void SwitchToSecondTab() {
        ArrayList<String> tabs = new ArrayList<String>(Driver.GetDriver().getWindowHandles());
        Driver.GetDriver().switchTo().window(tabs.get(1));
    }

    public static void SwitchToFirstTab() {
        ArrayList<String> tabs = new ArrayList<String>(Driver.GetDriver().getWindowHandles());
        Driver.GetDriver().switchTo().window(tabs.get(0));
    }

    public static void OpenNewTab() {
        ((JavascriptExecutor) Driver.GetDriver()).executeScript("window.open()");

    }
}
