package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class WildberriesCatalogPage {

    SelenideElement productCard = $(".product-card__wrapper"),
            bottonEntry = $(byText("Войти")),
            currencyMenu = $(".profile-menu__currency"),
            currencyChange = $(".popup__content"),
            catalog = $("[data-wba-header-name=Catalog]"),
            menuList = $(".menu-burger__main-list"),
            chapterTitle = $(".catalog-title");

    public WildberriesCatalogPage productCardVisible() {
        productCard.shouldBe(visible);
        return this;
    }

    public WildberriesCatalogPage openingTheLoginMenu() {
        bottonEntry.hover();
        return this;
    }

    public WildberriesCatalogPage goToTheCurrencyMenu() {
        currencyMenu.click();

        return this;
    }

    public WildberriesCatalogPage currencySelection(String currencyName) {
        currencyChange.$(byText(currencyName)).click();

        return this;
    }

    public WildberriesCatalogPage correctСurrencySelected(String currencyAbbreviation) {
        currencyMenu.shouldHave(text(currencyAbbreviation));

        return this;
    }

    public WildberriesCatalogPage openingCatalog() {
        catalog.click();

        return this;
    }

    public WildberriesCatalogPage selectCatalogHead(String chapter) {
        menuList.$(byText(chapter)).shouldBe(visible).click();

        return this;
    }

    public WildberriesCatalogPage requiredChapterIsOpen(String nameChapter){
        chapterTitle.shouldBe(visible).shouldHave(text(nameChapter));

        return this;
    }
}
