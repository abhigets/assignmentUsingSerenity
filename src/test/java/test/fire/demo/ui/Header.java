package test.fire.demo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.apache.tools.ant.taskdefs.Tar;
import org.openqa.selenium.By;

import java.text.MessageFormat;

public class Header {
    private static String HEADER_MENU = "//*[contains(@id,'_ctl0__ctl0_Content_LinkHeader')and contains(text(),'%s')]";

    public static Target getHeaderMenu(String type){
        String xpath = String.format(HEADER_MENU,type.toUpperCase());
        return Target.the(type +"Header Menu").located(By.xpath(xpath));
    }
}
