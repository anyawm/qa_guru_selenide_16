package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SelenideContributors {
    @Test
    void solntsevShouldBeTheTopContributor() {
        step("Открываем страницу selenide/selenide", () -> {
            open("https://github.com/selenide/selenide");
        });
        // hover mouse over the first avatar in contributors block
        $("div.Layout-sidebar").find(byText("Contributors"))
                .ancestor("div").$$("ul li").first().hover();

        // check: the popup window has text Andrei Solntsev
        $$(".Popover").findBy(visible).shouldHave(text(("Andrei Solntsev")));

    }
}
