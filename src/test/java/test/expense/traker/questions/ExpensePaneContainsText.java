package test.expense.traker.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Presence;
import net.thucydides.core.annotations.Step;
import test.expense.traker.ui.ExpensePane;

public class ExpensePaneContainsText implements Question<Boolean> {
    String textOnPane;

    public ExpensePaneContainsText(String textOnPane) {
        this.textOnPane = textOnPane;
    }

    @Override
    @Step("contains #textOnPane")
    public Boolean answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).containsText(textOnPane);
    }
}
