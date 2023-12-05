package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Configuration.baseUrl;

public class TestBase {

    @BeforeEach
    public void openWebsite(){
        baseUrl = "https://www.wildberries.ru/";
        Configuration.pageLoadStrategy = "normal";
        Configuration.browserSize = "1920x1080";
    }
    
}