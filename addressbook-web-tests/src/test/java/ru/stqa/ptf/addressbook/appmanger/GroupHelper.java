package ru.stqa.ptf.addressbook.appmanger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.ptf.addressbook.model.GroupData;

/**
 * Created by Olga_Verkhovtseva on 5/23/2017.
 */
public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void selectGroupModification() {
        click(By.name("selected[]"));
    }

    public void intitGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void submitGroupDelete() {
        click(By.name("delete"));
    }

    public void returntoGroupPage() {
        click(By.linkText("group page"));
    }

    public void createGroup(GroupData group) {

        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returntoGroupPage();

    }

    public boolean IsThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public void modifyGroup(GroupData group) {
        selectGroupModification();
        intitGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        returntoGroupPage();
    }

    public int getGroupCount() {
       return wd.findElements(By.name("selected[]")).size();
    }
}
