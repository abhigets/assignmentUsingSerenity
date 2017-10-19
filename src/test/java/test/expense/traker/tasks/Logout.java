package test.expense.traker.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import test.expense.traker.ui.Header;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Logout implements Task {

    @Step("Logout of application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Header.LOGOUT)
        );
    }

    public static Logout fromTheSystem() {
        return instrumented(Logout.class);
    }
}
