package Helpers;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class WebElementActions {


    public static void TryClick(WebElement elem) throws WebDriverException, InterruptedException {
        int i = 0;
        boolean result = false;
        while (i < 30)

            try {
                i++;
                elem.click();
                result = true;
            } catch (WebDriverException e) {
            }
        Thread.sleep(300);
    }


}
