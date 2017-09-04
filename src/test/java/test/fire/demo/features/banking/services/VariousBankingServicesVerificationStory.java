package test.fire.demo.features.banking.services;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import test.fire.demo.questions.MainContainerContainsLink;
import test.fire.demo.tasks.Go;
import test.fire.demo.tasks.OpenTheApplication;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
public class VariousBankingServicesVerificationStory {

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
    public void personal_banking_tab_should_show_all_the_links() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(Go.banking("Personal"));

        then(anna).should(eventually(seeThat(new MainContainerContainsLink("Deposit Products"), is(true))));
        then(anna).should(eventually(seeThat(new MainContainerContainsLink("Checking"), is(true))));
        then(anna).should(eventually(seeThat(new MainContainerContainsLink("Loans"), is(true))));
        then(anna).should(eventually(seeThat(new MainContainerContainsLink("Cards"), is(true))));
        then(anna).should(eventually(seeThat(new MainContainerContainsLink("Investments"), is(true))));
    }


    @Test
    public void small_business_banking_tab_should_show_all_the_links() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(Go.banking("Small Business"));

        then(anna).should(eventually(seeThat(new MainContainerContainsLink("Deposit Products"), is(true))));
        then(anna).should(eventually(seeThat(new MainContainerContainsLink("Lending"), is(true))));
        then(anna).should(eventually(seeThat(new MainContainerContainsLink("Cards"), is(true))));
        then(anna).should(eventually(seeThat(new MainContainerContainsLink("Insurance"), is(true))));
        then(anna).should(eventually(seeThat(new MainContainerContainsLink("Retirement"), is(true))));
    }
}