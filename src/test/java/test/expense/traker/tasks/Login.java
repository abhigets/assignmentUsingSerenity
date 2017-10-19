package test.expense.traker.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import test.expense.traker.ui.UserPane;

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
                .into(UserPane.USER_NAME)
        );
        actor.attemptsTo(Enter.theValue(password)
                .into(UserPane.PASSWORD)
                .thenHit(ENTER)
        );
    }

    public static Login with(String userName, String password) {
        return instrumented(Login.class, userName, password);
    }
}
