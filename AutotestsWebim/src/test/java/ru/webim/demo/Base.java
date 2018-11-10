package ru.webim.demo;

import org.junit.After;
import org.junit.Before;
import ru.webim.demo.POM.Driver;

import java.util.concurrent.TimeUnit;

public class Base {

    @Before
    public void Setup() {

        Driver.InitializeDriver();
        Driver.GetDriver().get("https://demo-pro.webim.ru/");
    }

    @After
    public void tearDown() {
        Driver.QuitDriver();
    }
}
