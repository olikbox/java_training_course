package ru.stqa.ptf.addressbook.appmanger;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Olga_Verkhovtseva on 5/23/2017.
 */

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void returntoGroupPage() {
        click(By.linkText("group page"));
    }

    public void gotoHomePage() {
        click(By.linkText("home"));
    }

    public void returntoHomePage() {
        click(By.linkText("home page"));
    }
}
