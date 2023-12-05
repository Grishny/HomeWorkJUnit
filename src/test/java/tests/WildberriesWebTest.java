package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.WildberriesCatalogPage;

import java.util.stream.Stream;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class WildberriesWebTest extends TestBase {

    WildberriesCatalogPage wildberriesCatalogPage = new WildberriesCatalogPage();

    static Stream<Arguments> currencyCheckForCountries() {
        return Stream.of(
                Arguments.of("Казахстанский тенге", "KZT"),
                Arguments.of("Российский рубль", "RUB"),
                Arguments.of("Белорусский рубль", "BYN"),
                Arguments.of("Армянский драм", "AMD"),
                Arguments.of("Киргизский сом", "KGS"),
                Arguments.of("Узбекский сум", "UZS")
        );
    }

    @MethodSource("currencyCheckForCountries")
    @ParameterizedTest(name = "При выборе валюты {0} цена всех товаров отображается в {1}")
    @Tags({@Tag("UI"), @Tag("Search"), @Tag("Smoke")})
    void currencyCheckForCountries(String currencyName, String currencyAbbreviation) {
        open(baseUrl);
        wildberriesCatalogPage.productCardVisible();
        wildberriesCatalogPage.openingTheLoginMenu();
        wildberriesCatalogPage.goToTheCurrencyMenu();
        wildberriesCatalogPage.currencySelection(currencyName);
        wildberriesCatalogPage.openingTheLoginMenu();
        wildberriesCatalogPage.correctСurrencySelected(currencyAbbreviation);
    }

    @CsvSource(value = {
            "Женщинам , Женщинам",
            "Обувь    , Обувь",
            "Детям , Детям",
            "Мужчинам , Мужчинам",
            "Дом , Дом"
    })
    @ParameterizedTest(name = "В катологе при переходе в раздел {0} открывается страница {1}")
    @Tags({@Tag("UI"), @Tag("Catalog"), @Tag("Regress")})
    void menuExpansion(String chapter, String nameChapter) {
        open(baseUrl);
        wildberriesCatalogPage.productCardVisible();
        wildberriesCatalogPage.openingCatalog();
        wildberriesCatalogPage.selectCatalogHead(chapter);
        wildberriesCatalogPage.requiredChapterIsOpen(nameChapter);
    }
}

