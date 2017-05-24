package ru.stqa.ptf.addressbook.appmanger;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Olga_Verkhovtseva on 5/23/2017.
 */
public class SessionHelper extends BaseHelper {

    public SessionHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        type(By.name("user"), username);
        type(By.name("pass"), password);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }
}
