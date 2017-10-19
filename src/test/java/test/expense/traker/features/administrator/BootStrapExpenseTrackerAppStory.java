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
public class BootStrapExpenseTrackerAppStory {

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
    public void end_to_end_journey_of_user_registration_and_add_categories() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(RegisterNewUser.with("John", "doe1"));
        and(anna).attemptsTo(CreateACategory.withName("Trekking"));
        and(anna).attemptsTo(CreateACategory.withName("Travelling"));
    }
}