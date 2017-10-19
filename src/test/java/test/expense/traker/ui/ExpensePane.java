package test.expense.traker.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ExpensePane {
    public static Target DAY_INPUT_BOX = Target.the("Day").located(By.id("day"));
    public static Target MONTH_INPUT_BOX = Target.the("Month").located(By.id("month"));
    public static Target YEAR_INPUT_BOX = Target.the("Year").located(By.id("year"));
    public static Target CATEGORY_DROPDOWN = Target.the("Category dropdown").located(By.id("category"));
    public static Target AMOUNT_TEXT_BOX = Target.the("Amount text box").located(By.id("amount"));
    public static Target REASON_TEXT_BOX = Target.the("Reason text box").located(By.id("reason"));

    public static Target EDIT_EXPENSE_LINK;
    public static String EDIT_EXPENSE_LOCATOR = "//td[contains(text(),'%s')]/ancestor::tr//*[@title='edit expense']";
    public static Target getEditExpenseLink(String reason) {
        EDIT_EXPENSE_LOCATOR = String.format(EDIT_EXPENSE_LOCATOR, reason);
        EDIT_EXPENSE_LINK = Target.the("Edit expense for " + reason).located(By.xpath(EDIT_EXPENSE_LOCATOR));
        return EDIT_EXPENSE_LINK;
    }

    public static Target DELETE_EXPENSE_LINK;
    public static String DELETE_EXPENSE_LOCATOR = "//td[contains(text(),'%s')]/ancestor::tr//*[@title='delete expense']";
    public static Target getDeleteExpenseLink(String reason) {
        DELETE_EXPENSE_LOCATOR = String.format(DELETE_EXPENSE_LOCATOR, reason);
        DELETE_EXPENSE_LINK = Target.the("Edit expense for " + reason).located(By.xpath(DELETE_EXPENSE_LOCATOR));
        return DELETE_EXPENSE_LINK;
    }
}
