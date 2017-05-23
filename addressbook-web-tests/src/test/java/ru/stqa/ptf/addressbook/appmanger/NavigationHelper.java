package ru.stqa.ptf.addressbook.appmanger;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Olga_Verkhovtseva on 5/23/2017.
 */

public class NavigationHelper {

    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void gotoGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void returntoGroupPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    public void returntoHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }
}
