package test.expense.traker.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CategoryPane {
    public static Target AddCategoryButton = Target.the("Add Category Button").located(By.id("go_add_category"));
    public static Target CATEGORY_NAME_BOX = Target.the("Category Name box").located(By.id("name"));
}
