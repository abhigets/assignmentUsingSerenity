package test.expense.traker.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Header {
    public static Target EDIT_ACCOUNT = Target.the("Edit Account Link").located(By.id("editaccount"));
    public static Target LOGOUT = Target.the("Logout Link").located(By.id("logout"));
    public static Target LIST_CATEGORY = Target.the("List Category link").located(By.id("go_list_categories"));
    public static Target ADD_EXPENSE_LINK = Target.the("Add Expense link").located(By.id("go_add_expense"));
}
