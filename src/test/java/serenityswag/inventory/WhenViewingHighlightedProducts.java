package serenityswag.inventory;

import groovy.util.logging.Slf4j;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.LoginActions;
import serenityswag.authentication.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
@Slf4j
public class WhenViewingHighlightedProducts {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    LoginActions login;

    ProductListPageObject productList;


    @Test
    public void shouldDisplayHighlightedProductsOnTheWelcomePage(){
        login.as(User.STANDARD_USER);
        List<String> productsOnDisplay = productList.titles();
        assertThat(productsOnDisplay).hasSize(6)
                .contains("Sauce Labs Backpack");

    }
    @Test
    public void highlightedProductsShouldDisplayTheCorrespondingImages(){
      login.as(User.STANDARD_USER);
        List<String> productsOnDisplay = productList.titles();
        SoftAssertions softly = new SoftAssertions();

        productsOnDisplay.forEach(
                productName -> softly.assertThat(productList.imageTextForProduct(productName))
                        .isEqualTo(productName)
        );
        softly.assertAll();

    }
}
