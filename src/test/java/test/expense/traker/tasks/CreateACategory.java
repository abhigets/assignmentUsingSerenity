package test.expense.traker.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import test.expense.traker.ui.CategoryPane;
import test.expense.traker.ui.Header;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

public class CreateACategory implements Task {

    String categoryName;

    CreateACategory(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Header.LIST_CATEGORY)
        );
        actor.attemptsTo(
                Click.on(CategoryPane.AddCategoryButton)
        );
        actor.attemptsTo(
                Enter.theValue(categoryName).
                        into(CategoryPane.CATEGORY_NAME_BOX)
                        .thenHit(ENTER)
        );
    }

    public static CreateACategory withName(String categoryName) {
        return instrumented(CreateACategory.class, categoryName);
    }
}
