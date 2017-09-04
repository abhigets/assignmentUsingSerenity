package test.fire.demo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import test.fire.demo.ui.TestFireHomePage;

public class OpenTheApplication implements Task {

    TestFireHomePage testFireHomePage;

    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(testFireHomePage)
        );
    }
}
