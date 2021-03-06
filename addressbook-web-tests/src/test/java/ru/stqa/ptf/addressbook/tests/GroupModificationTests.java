package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Olga_Verkhovtseva on 5/24/2017.
 */
public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper ( ).gotoGroupPage ( );
        if (!app.getGroupHelper ( ).IsThereAGroup ( )) {
            app.getGroupHelper ( ).createGroup ( new GroupData ( ).withName ( "Test2" ) );
        }
    }

    @Test

    public void testGroupModification() {
        List <GroupData> before = app.getGroupHelper ( ).getGroupList ( );
        int index = before.size ( ) - 1;
        GroupData group = new GroupData ( ).withId ( before.get ( index ).getId ( ) ).withName ( "Musa Mus" ).withHeader ( "Header" ).withFooter ( "Footer" );
        app.getGroupHelper().modifyGroup(group);
        List <GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove ( index );
        before.add(group);
        Comparator <? super GroupData> byId = (g1, g2) -> Integer.compare ( g1.getId ( ), g2.getId ( ) );
        before.sort ( byId );
        after.sort(byId);
        Assert.assertEquals ( before, after );
    }

}

