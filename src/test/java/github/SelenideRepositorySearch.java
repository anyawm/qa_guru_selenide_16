package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SelenideRepositorySearch {
    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        //ARRANGE
        step("Открыть браузер на странице гитхаб", () -> {
            open("https://github.com/");
        });
        //ACT
        step("Найти selenide", () -> {
            $("[data-test-selector='nav-search-input']").setValue("selenide").pressEnter();
            $$("ul.repo-list li").first().$("a").click();
        });
        //ASSERT
        step("В кнопке репозитория текст selenide/selenide", () -> {
            $("#repository-container-header").shouldHave(text("selenide / selenide"));
        });
    }
}
