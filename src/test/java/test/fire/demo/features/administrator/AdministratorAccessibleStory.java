package test.fire.demo.features.administrator;

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
import test.fire.demo.tasks.Login;
import test.fire.demo.tasks.OpenTheApplication;
import test.fire.demo.tasks.AddUser;
import test.fire.demo.tasks.WanaGo;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class AdministratorAccessibleStory {

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
    public void administrator_banking_tab_should_show_all_the_links() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(WanaGo.banking("Online Banking Login"));
        when(anna).attemptsTo(Login.withUserNameAndPassword("Admin", "admin"));
        when(anna).attemptsTo(AddUser.with("Anna", "Doe", "Anna", "anna"));

        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("Altoro Mutual: Administration"))));
    }
}