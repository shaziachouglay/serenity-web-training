package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class InventoryPage extends PageObject {
    public String getHeading() {
        return find(By.cssSelector(".title")).getText();
    }
}
