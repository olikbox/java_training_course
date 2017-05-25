package ru.stqa.ptf.addressbook.appmanger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Olga_Verkhovtseva on 5/23/2017.
 */
public class SessionHelper extends BaseHelper {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        type(By.xpath("//*[@id=\"LoginForm\"]/input[1]"), username);
        type(By.name("pass"), password);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }
}
