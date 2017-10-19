package test.expense.traker.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;
import test.expense.traker.ui.ExpensePane;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteExpense implements Task{

    String reason;

    DeleteExpense(String reason){
        this.reason = reason;
    }

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ExpensePane.getDeleteExpenseLink(reason))
        );
        BrowseTheWeb.as(actor).waitFor(5000);
        actor.attemptsTo(
                Hit.the(Keys.ENTER)
                        .into(ExpensePane.getEditExpenseLink(reason))
        );
    }

    public static DeleteExpense forThe(String reason) {
        return instrumented(DeleteExpense.class,reason);
    }
}
