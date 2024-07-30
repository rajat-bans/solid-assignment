package net.media.training.designpattern.adapter;

import net.media.training.designpattern.adapter.thirdparty.ThirdPartyLeaveRecord;

public class ThirdPartyLeaveRecordAdapter implements LeaveRecord{
    private ThirdPartyLeaveRecord thirdPartyLeaveRecord;
    public ThirdPartyLeaveRecordAdapter(ThirdPartyLeaveRecord thirdPartyLeaveRecord){
        this.thirdPartyLeaveRecord = thirdPartyLeaveRecord;
    }

    public String getMostAbsentEmployee(){
        String name = this.thirdPartyLeaveRecord.getMostAbsentEmployee().getName();
        return name.split(", ")[1] + " " + name.split(", ")[0];
    }

    public int getEmployeeAbsences(String employeeName){
        String[] splittedName = employeeName.split(" ");
        String firstName = String.join(" ", java.util.Arrays.copyOf(splittedName, splittedName.length - 1));
        String lastName = splittedName[splittedName.length - 1];
        return this.thirdPartyLeaveRecord.getEmployeeAbsences(new Employee(lastName + ", " + firstName));
    }    
}
