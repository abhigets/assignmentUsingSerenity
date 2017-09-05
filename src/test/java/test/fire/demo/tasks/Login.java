package test.fire.demo.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import test.fire.demo.ui.LoginBox;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

public class Login implements Task {

    String userName, password;

    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Step("Login with user name: #userName and password #password")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(userName)
                .into(LoginBox.USER_NAME)
        );
        actor.attemptsTo(Enter.theValue(userName)
                .into(LoginBox.PASSWORD)
                .thenHit(ENTER)
        );
    }

    public static Login withUserNameAndPassword(String userName, String password) {
        return instrumented(Login.class, userName, password);
    }
}
