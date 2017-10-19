package test.expense.traker.features.administrator;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import test.expense.traker.tasks.*;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class UserManagement {

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
    public void change_password_journey() {
        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(RegisterNewUser.with("Jonny", "jane"));
        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("Expense tracker"))));

        when(anna).attemptsTo(ChangePassword.from("jane", "jonny"));
        and(anna).attemptsTo(Logout.fromTheSystem());

        and(anna).attemptsTo(Login.with("Jonny", "jonny"));
        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("Expense tracker"))));
    }
}