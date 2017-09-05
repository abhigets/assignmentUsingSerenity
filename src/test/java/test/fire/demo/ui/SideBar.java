package test.fire.demo.ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SideBar {
    private static String linkLocator = "//td[@class='cc br bb']//*[contains(text(),'%s')]";

    public static Target getLink(String linkName) {
        String xpath = String.format(linkLocator, linkName);
        return Target.the("Sidebar " + linkName + " Link").located(By.xpath(xpath));
    }
}
