package test.fire.demo.ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EditUserInfoPane {
    public static Target FIRST_NAME = Target.the("First Name").located(By.name("firstname"));
    public static Target LAST_NAME = Target.the("First Name").located(By.name("lastname"));
    public static Target USER_NAME = Target.the("First Name").located(By.name("username"));
    public static Target ADD_USER_BUTTON = Target.the("First Name").located(By.name("add"));

    private static String xpathAddUserPassword = "//*[@name=\'username\']/../..//*[@name=\'%s\']";
    public static Target ADD_USER_PASSWORD_FIELD = Target.the("First Name").located(By.xpath(String.format(xpathAddUserPassword, "password1")));
    public static Target ADD_USER_CONFIRM_PASSWORD_FIELD = Target.the("First Name").located(By.xpath(String.format(xpathAddUserPassword, "password2")));
}
