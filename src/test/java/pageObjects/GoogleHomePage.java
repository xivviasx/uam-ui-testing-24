package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class GoogleHomePage {

    public GoogleHomePage open() {
        Selenide.open("/");

        return this;
    }

    public GoogleHomePage acceptCookies() {
        $(byId("L2AGLb")).click();

        return this;
    }

    public void search(String text) {
        $(byName("q")).shouldBe(Condition.visible)
                .setValue(text).pressEnter();
    }


}
