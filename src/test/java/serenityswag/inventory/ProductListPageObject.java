package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;

import java.util.List;

public class ProductListPageObject extends PageObject {
    public List<String> titles() {
        return findAll(".inventory_item_name").textContents();
    }

    public String imageTextForProduct(String productName) {
     return  $("//div[@class='inventory_item'][contains(.,'" + productName + "')]//img").getAttribute("alt");
    }
}
