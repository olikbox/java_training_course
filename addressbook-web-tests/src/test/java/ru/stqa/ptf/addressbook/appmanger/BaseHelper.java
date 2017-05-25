package ru.stqa.ptf.addressbook.appmanger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Olga_Verkhovtseva on 5/24/2017.
 */
public class BaseHelper {

    public WebDriver wd;

    public BaseHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }
}
