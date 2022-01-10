package severstal_badikov;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class selenide_lesson_3 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1980x1080";
        Configuration.holdBrowserOpen = false;
    }
    @BeforeEach
    void init(TestInfo testInfo) {
        String callingTest = testInfo.getTestMethod().get().getName();
        System.out.println(callingTest);
    }

    @Test
    @Order(1)
    void testSearchSelenideInGithub() {

        //открываем страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        //Переходим в раздел Wiki проекта
        $("#wiki-tab").click();

        //Assert что в списке страниц (Pages) есть страница c
        $("#wiki-pages-filter").val("SoftAssertions").pressEnter();

        $("[data-filterable-for='wiki-pages-filter']").shouldHave(text("SoftAssertions"));

        //SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $("[data-filterable-for='wiki-pages-filter']").$(byText("SoftAssertions")).click();

        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));

    }


    @Test
    @Order(2)
    void testDragAndDrop() {
        //Открываем страницу
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //Drag And Drop
        $("#column-a").dragAndDropTo($("#column-b"));

        //Assert
        $("#column-a").shouldHave(text("b"));
        $("#column-b").shouldHave(text("a"));

    }
}
