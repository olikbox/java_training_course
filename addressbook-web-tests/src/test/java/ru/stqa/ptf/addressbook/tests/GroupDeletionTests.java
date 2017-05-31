package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

/**
 * Created by Olga_Verkhovtseva on 5/24/2017.
 */
public class GroupDeletionTests extends TestBase {

    @Test

    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().IsThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData( "Pugy Pug", "NovaLiga corporation", "NovaLiga inc. "));
        }
        app.getGroupHelper().selectGroupModification();
        app.getGroupHelper().submitGroupDelete();
        app.getNavigationHelper().returntoGroupPage();
    }
}