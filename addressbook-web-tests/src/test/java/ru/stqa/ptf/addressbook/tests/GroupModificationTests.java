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
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().IsThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("Pugy Pug", "NovaLiga corporation", "NovaLiga inc. "));
        }
            //app.getGroupHelper().getExistingGroup();
        app.getGroupHelper().modifyGroup(new GroupData("Musa Mus", "NovaLiga corporation", "NovaLiga inc. "));


        // String existingText = wd.findElement(locator).getAttribute("value");

    }
}
