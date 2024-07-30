package net.media.training.designpattern.adapter;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import net.media.training.designpattern.adapter.thirdparty.ThirdPartyLeaveRecord;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 21, 2011
 * Time: 5:40:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class AdapterTest {
    private ThirdPartyLeaveRecordAdapter thirdPartyLeaveRecordAdapter = new ThirdPartyLeaveRecordAdapter(new ThirdPartyLeaveRecord());

    @Test
    public void testGetDisplayWallOfShame() throws Exception {
       FrontDoorRegister frontDoorRegister = new FrontDoorRegister(thirdPartyLeaveRecordAdapter);
       assertEquals("Super Commando Dhruv has been the most absent employee, shame!", frontDoorRegister.getDisplayWallOfShame());
    }

    @Test
    public void salaryDisbersmentTest() {
     SalaryDisberser salaryDisberser = new SalaryDisberser(thirdPartyLeaveRecordAdapter);
     assertEquals(10000, salaryDisberser.salary("James Bond"));
     assertEquals(8000, salaryDisberser.salary("Austin Powers"));
     assertEquals(5000, salaryDisberser.salary("Super Commando Dhruv"));
    }
}
