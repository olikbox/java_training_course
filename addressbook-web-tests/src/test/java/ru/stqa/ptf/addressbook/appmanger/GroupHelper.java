package ru.stqa.ptf.addressbook.appmanger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

import static ru.stqa.ptf.addressbook.tests.TestBase.app;

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

    public void selectGroupModification(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
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
        List <GroupData> before = getGroupList();
        selectGroupModification(before.size() - 1);
        intitGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        returntoGroupPage();
    }

    public int getGroupCount() {
       return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element:elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add ( new GroupData ( ).withId ( id ).withName ( name ) );
        }
        return groups;
    }

    public void modifyGroup(int index) {
        selectGroupModification(index);
      submitGroupDelete();
        app.getNavigationHelper().returntoGroupPage();
    }
}
