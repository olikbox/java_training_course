package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by Olga_Verkhovtseva on 5/24/2017.
 */
public class GroupDeletionTests extends TestBase {

    @Test

    public void testGroupDeletion() {

        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().IsThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("Pugy Pug", "NovaLiga corporation", "NovaLiga inc. "));
        }
        List <GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroupModification(before.size() - 1);
        app.getGroupHelper().submitGroupDelete();
        app.getNavigationHelper().returntoGroupPage();
        List <GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
        }
    }

