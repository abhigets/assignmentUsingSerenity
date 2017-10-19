package test.expense.traker.ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UserPane {
    public static Target USER_NAME = Target.the("User Name").located(By.id("login"));
    public static Target PASSWORD = Target.the("Password").located(By.id("password"));
    public static Target SUBMIT = Target.the("Password").located(By.id("submit"));
    public static Target NEW_PASSWORD = Target.the("New Password").located(By.id("password1"));
    public static Target NEW_CONFIRM_PASSWORD = Target.the("New Confirm Password").located(By.id("password2"));
    public static Target NEW_PASSWORD_TO_CHANGE = Target.the("New Password").located(By.id("newpassword1"));
    public static Target NEW_CONFIRM_PASSWORD_TO_CHANGE = Target.the("New Confirm Password").located(By.id("newpassword2"));
    public static Target REGISTER_NEW_USER = Target.the("Register New User Link").located(net.serenitybdd.core.annotations.findby.By.linkText("Register new user"));
}
