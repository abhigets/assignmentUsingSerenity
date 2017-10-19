package test.expense.traker.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;
import test.expense.traker.ui.ExpensePane;
import test.expense.traker.ui.Header;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

public class AddExpense implements Task {

    private final String category, reason, day, month, year;
    private final int amount;


    protected AddExpense(String day, String month, String year, String category, int amount, String reason) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.category = category;
        this.amount = amount;
        this.reason = reason;
    }

    @Step("AddExpense to #type Banking")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Header.ADD_EXPENSE_LINK)
        );
        actor.attemptsTo(
                Enter.theValue(day).
                        into(ExpensePane.DAY_INPUT_BOX)
        );
        actor.attemptsTo(
                Enter.theValue(month).
                        into(ExpensePane.MONTH_INPUT_BOX)
        );
        actor.attemptsTo(
                Enter.theValue(year).
                        into(ExpensePane.YEAR_INPUT_BOX)
        );
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(category).
                        from(ExpensePane.CATEGORY_DROPDOWN)
        );
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

    public static AddExpense with(String day, String month, String year, String category, int amount, String reason) {
        return instrumented(AddExpense.class, day, month, year, category, amount, reason);
    }


}
