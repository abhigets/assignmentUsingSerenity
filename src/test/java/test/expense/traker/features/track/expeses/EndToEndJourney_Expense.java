package test.expense.traker.features.track.expeses;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import test.expense.traker.questions.ExpensePaneContainsText;
import test.expense.traker.tasks.*;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
public class EndToEndJourney_Expense {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void addExpense_modifyExpense() {

        givenThat(anna).wasAbleTo(openTheApplication);

        and(anna).attemptsTo(Login.with("John", "doe1"));

        when(anna).attemptsTo(AddExpense.with("01", "02", "2016", "Trekking", 100, "Breakfast"));

        //based on reason the information will be edited
        and(anna).attemptsTo(ModifiesExpense.to("", "", "2017", "Travelling", 0, "Breakfast"));
        and(anna).attemptsTo(ModifiesExpense.to("01", "", "2017", "", 200, "Breakfast"));

        then(anna).should(eventually(seeThat(new ExpensePaneContainsText("200"), is(true))));
    }
}