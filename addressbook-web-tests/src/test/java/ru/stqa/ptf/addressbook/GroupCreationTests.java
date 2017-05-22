package ru.stqa.ptf.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("Nova Liga1", "NovaLiga corporation", "NovaLiga inc. "));
        submitGroupCretiopn();
        returntoGroupPage();
    }

}
