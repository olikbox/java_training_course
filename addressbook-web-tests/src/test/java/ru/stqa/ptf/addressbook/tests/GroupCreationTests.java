package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test

    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        List <GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("Pugy Pug", null, null);
        app.getGroupHelper().createGroup(group);
        List <GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);
        before.add(group);
        int max = 0;
        for (GroupData g : after){
            if (g.getId()>max);
        }
        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(group);
        Assert.assertEquals(new HashSet <Object>(before), new HashSet <Object>(after));
    }
}
