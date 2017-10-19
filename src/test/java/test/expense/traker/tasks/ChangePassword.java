package test.expense.traker.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import test.expense.traker.ui.Header;
import test.expense.traker.ui.UserPane;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChangePassword implements Task {

    String oldPassword, newPassword;

    public ChangePassword(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    @Step("Change password from #oldPassword to #newPassword")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Header.EDIT_ACCOUNT)
        );
        actor.attemptsTo(
                Enter.theValue(oldPassword).
                        into(UserPane.PASSWORD)
        );
        actor.attemptsTo(
                Enter.theValue(newPassword).
                        into(UserPane.NEW_PASSWORD_TO_CHANGE)
        );
        actor.attemptsTo(
                Enter.theValue(newPassword).
                        into(UserPane.NEW_CONFIRM_PASSWORD_TO_CHANGE)
        );
        actor.attemptsTo(
                Click.on(UserPane.SUBMIT)
        );
    }

    public static ChangePassword from(String oldPassword, String newPassword) {
        return instrumented(ChangePassword.class, oldPassword, newPassword);
    }
}
