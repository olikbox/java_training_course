package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test

    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("Pugy Pug", "NovaLiga corporation", "NovaLiga inc. "));
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().returntoGroupPage();
    }
}
