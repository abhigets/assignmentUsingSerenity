package test.fire.demo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginBox {
    public static Target USER_NAME = Target.the("User Name").located(By.id("uid"));
    public static Target PASSWORD = Target.the("Password").located(By.id("passw"));
}
