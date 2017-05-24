package ru.stqa.ptf.addressbook.appmanger;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Olga_Verkhovtseva on 5/24/2017.
 */
public class BaseHelper {

    protected FirefoxDriver wd;

    public BaseHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    protected void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }
}
