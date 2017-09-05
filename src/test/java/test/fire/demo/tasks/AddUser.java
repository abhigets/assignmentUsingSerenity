package test.fire.demo.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import test.fire.demo.ui.EditUserInfoPane;
import test.fire.demo.ui.SideBar;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddUser implements Task {

    String firstName, lastName, userName, password;

    public AddUser(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    @Step("Create User #userName")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SideBar.getLink("Edit Users"))
        );
        actor.attemptsTo(
                Enter.theValue(firstName)
                        .into(EditUserInfoPane.FIRST_NAME)
        );
        actor.attemptsTo(
                Enter.theValue(lastName)
                        .into(EditUserInfoPane.LAST_NAME)
        );
        actor.attemptsTo(
                Enter.theValue(userName)
                        .into(EditUserInfoPane.USER_NAME)
        );
        actor.attemptsTo(
                Enter.theValue(password)
                        .into(EditUserInfoPane.ADD_USER_PASSWORD_FIELD)
        );
        actor.attemptsTo(
                Enter.theValue(password)
                        .into(EditUserInfoPane.ADD_USER_CONFIRM_PASSWORD_FIELD)
        );
        actor.attemptsTo(
                Click.on(EditUserInfoPane.ADD_USER_BUTTON)
        );
    }

    public static AddUser with(String firstName, String lastName, String userName, String password) {
        return instrumented(AddUser.class, firstName, lastName, userName, password);
    }
}
