package cucumber;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pageObjects.GoogleHomePage;
import pageObjects.GoogleResultsPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;

public class Steps {

        @Given("We set base url for {string} page")
        public void openPage(String page) {
            Configuration.baseUrl = "https://" + page;
            Configuration.headless = true;
            clearBrowserCookies();
        }

        @When("We search for {string} word")
        public void weSearchForWord(String word) {
            new GoogleHomePage().open().search(word);
        }

        @Then("{string} text will be visible in results")
        public void textWillBeVisibleInResults(String result) {
            new GoogleResultsPage()
                    .searchForTextInElement(0, result);
        }

        @And("Google logo will be visible")
        public void googleLogoWillBeVisible() {
            $(By.id("logo")).shouldBe(Condition.visible);
        }
}

