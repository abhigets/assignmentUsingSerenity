package test.fire.demo.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import test.fire.demo.ui.Header;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WanaGo implements Task {

    private final String type;

    protected WanaGo(String type) {
        this.type = type;
    }

    @Step("WanaGo to #type Banking")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Header.getHeaderMenu(type))
        );
    }

    public static WanaGo banking(String type) {
        return instrumented(WanaGo.class, type);
    }


}
