package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

/**
 * Created by Olga_Verkhovtseva on 5/24/2017.
 */
public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroupModification();
        app.getGroupHelper().intitGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("Nova Liga2", "NovaLiga corporation", "NovaLiga inc. "));
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().returntoGroupPage();
    }
}
