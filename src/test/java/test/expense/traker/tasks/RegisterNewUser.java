package test.expense.traker.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import test.expense.traker.ui.UserPane;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterNewUser implements Task {

    String userName, password;

    public RegisterNewUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Step("Create User #userName")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(UserPane.REGISTER_NEW_USER)
        );
        actor.attemptsTo(
                Enter.theValue(userName)
                        .into(UserPane.USER_NAME)
        );
        actor.attemptsTo(
                Enter.theValue(password)
                        .into(UserPane.NEW_PASSWORD)
        );
        actor.attemptsTo(
                Enter.theValue(password)
                        .into(UserPane.NEW_CONFIRM_PASSWORD)
        );
        actor.attemptsTo(
                Click.on(UserPane.SUBMIT)
        );
    }

    public static RegisterNewUser with(String userName, String password) {
        return instrumented(RegisterNewUser.class, userName, password);
    }
}
