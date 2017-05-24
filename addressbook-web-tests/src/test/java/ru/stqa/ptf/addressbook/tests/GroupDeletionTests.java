package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Olga_Verkhovtseva on 5/24/2017.
 */
public class GroupDeletionTests extends TestBase {

    @Test

    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroupModification();
        app.getGroupHelper().submitGroupDelete();
        app.getNavigationHelper().returntoGroupPage();
    }
}