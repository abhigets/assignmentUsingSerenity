package test.fire.demo.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import test.fire.demo.ui.Header;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Go implements Task {

    private final String type;

    @Step("Go to #Type Banking")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Header.getHeaderMenu(type))
        );
    }

    protected Go(String type) {
        this.type = type;
    }

    public static Go banking(String type) {
        return instrumented(Go.class, type);
    }


}
