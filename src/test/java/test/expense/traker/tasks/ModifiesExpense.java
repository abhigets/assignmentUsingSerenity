package test.expense.traker.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import test.expense.traker.ui.ExpensePane;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

public class ModifiesExpense implements Task {

    String day, month, year, category, reason;
    int amount;

    ModifiesExpense(String day, String month, String year, String category, int amount, String reason) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.category = category;
        this.amount = amount;
        this.reason = reason;
    }

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ExpensePane.getEditExpenseLink(reason))
        );
        if (!day.isEmpty())
            actor.attemptsTo(
                    Enter.theValue(day).
                            into(ExpensePane.DAY_INPUT_BOX)
            );
        if (!month.isEmpty())
            actor.attemptsTo(
                    Enter.theValue(month).
                            into(ExpensePane.MONTH_INPUT_BOX)
            );
        if (!year.isEmpty())
            actor.attemptsTo(
                    Enter.theValue(year).
                            into(ExpensePane.YEAR_INPUT_BOX)
            );
        if (!category.isEmpty())
            actor.attemptsTo(
                    SelectFromOptions.byVisibleText(category).
                            from(ExpensePane.CATEGORY_DROPDOWN)
            );
        if (amount > 0)
            actor.attemptsTo(
                    Enter.theValue(Integer.toString(amount)).
                            into(ExpensePane.AMOUNT_TEXT_BOX)
            );
        actor.attemptsTo(
                Enter.theValue(reason).
                        into(ExpensePane.REASON_TEXT_BOX).
                        thenHit(ENTER)
        );
    }

    public static ModifiesExpense to(String day, String month, String year, String category, int amount, String reason) {
        return instrumented(ModifiesExpense.class, day, month, year, category, amount, reason);
    }
}
