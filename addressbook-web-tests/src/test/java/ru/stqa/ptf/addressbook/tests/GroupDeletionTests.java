package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by Olga_Verkhovtseva on 5/24/2017.
 */
public class GroupDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper ( ).gotoGroupPage ( );
        if (!app.getGroupHelper ( ).IsThereAGroup ( )) {
            app.getGroupHelper ( ).createGroup ( new GroupData().withName ( "Test2" ));
        }
    }

    @Test
    public void testGroupDeletion() {
        List <GroupData> before = app.getGroupHelper ( ).getGroupList ( );
        int index = before.size ( ) - 1;
        app.getGroupHelper ( ).modifyGroup ( index );
        List <GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals ( after.size ( ), index );

        before.remove ( index );
        Assert.assertEquals(before, after);
        }
}

