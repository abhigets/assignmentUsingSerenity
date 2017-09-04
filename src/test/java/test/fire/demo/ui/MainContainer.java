package test.fire.demo.ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.text.MessageFormat;

public class MainContainer {

    private static String HYPERLINK = "//span[@id='_ctl0__ctl0_Content_Main_lblContent']//a[contains(text(),'%s')]";

    public static Target getHyperlinkLocator(String linkText) {
        String xpath = String.format(HYPERLINK,linkText);
        return Target.the(linkText + " Hyper Link On page").located(By.xpath(xpath));
    }
}
