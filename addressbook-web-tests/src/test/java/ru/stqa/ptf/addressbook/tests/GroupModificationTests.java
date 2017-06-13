package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Olga_Verkhovtseva on 5/24/2017.
 */
public class GroupModificationTests extends TestBase {

    @Test

    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().IsThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("Pugy Pug", "NovaLiga corporation", "NovaLiga inc. "));
        }
        List <GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData(before.get(before.size()-1).getId(),"Musa Mus", "null", "null");
        app.getGroupHelper().modifyGroup(group);
        List <GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);
        Assert.assertEquals(new HashSet <Object>(before), new HashSet <Object>(after));
    }
}
