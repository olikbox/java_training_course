package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

/**
 * Created by Olga_Verkhovtseva on 5/24/2017.
 */
public class GroupModificationTests extends TestBase {

    @Test

    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if (!app.getGroupHelper().IsThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("Pugy Pug", "NovaLiga corporation", "NovaLiga inc. "));
        }
        app.getGroupHelper().modifyGroup(new GroupData("Musa Mus", "NovaLiga corporation", "NovaLiga inc. "));
        int after = app.getGroupHelper().getGroupCount();
       Assert.assertEquals(after, before);

    }
}
