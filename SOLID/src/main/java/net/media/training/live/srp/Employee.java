package net.media.training.live.srp;

import javax.swing.text.html.HTML;

public class Employee {
    private int empId;
    private static int TOTAL_LEAVES_ALLOWED = 30;

    private double monthlySalary;
    private String name;
    private String addressStreet;
    private String addressCity;
    private String addressCountry;
    private int leavesTaken;
    private int totalLeaveAllowed;
    private int leaveTaken;
    private String manager;
    private int yearsInOrg;
    private int thisYeard;
    private int[] leavesLeftPreviously;


    public Employee(int empId, double monthlySalary, String name, String addressStreet, String addressCity, String addressCountry, int leavesTaken, int[] leavesLeftPreviously) {
        this.empId = empId;
        this.monthlySalary = monthlySalary;
        this.name = name;
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.addressCountry = addressCountry;
        this.leavesTaken = leavesTaken;
        this.leavesLeftPreviously = leavesLeftPreviously;
        this.yearsInOrg = leavesLeftPreviously.length;
    }

    public Employee() {
    }

    public int getLeavesRemaining(){
        return this.totalLeaveAllowed - this.leaveTaken;
    }

    public long getMonthlySalary(){
        return Math.round(this.monthlySalary * 12);
    }

    public String getManager(){
        if(this.manager != null)
            return this.manager;
        return "None";
    }

    public int getTotalLeaveLeftPreviously(){
        int years = 3;
        if (this.yearsInOrg < 3) {
            years = this.yearsInOrg;
        }
        int totalLeaveLeftPreviously = 0;
        for (int i = 0; i < years; i++) {
            totalLeaveLeftPreviously += this.leavesLeftPreviously[this.yearsInOrg-i-1];
        }
        return totalLeaveLeftPreviously;
    }

    public String getEmployeeName(){
        return this.name;
    }

    public String toHtml(){
        String str = HTMLConverter.getSpanTag(this.getEmployeeName());

        String labelsTags = HTMLConverter.getSpanTag("Leave Left :");
        labelsTags += HTMLConverter.getSpanTag("Annual Salary:");
        labelsTags += HTMLConverter.getSpanTag("Manager:");
        labelsTags += HTMLConverter.getSpanTag("Reimbursable Leave:");
        str += HTMLConverter.getDivClassTag("left", labelsTags);
    
        String infoTags = HTMLConverter.getSpanTag(Integer.toString(this.getLeavesRemaining()));
        infoTags += HTMLConverter.getSpanTag(Long.toString(this.getMonthlySalary()));
        infoTags += HTMLConverter.getSpanTag(this.getManager());
        infoTags += HTMLConverter.getSpanTag(Integer.toString(this.getTotalLeaveLeftPreviously()));
        str += HTMLConverter.getDivClassTag("right", infoTags);
        
        return "<div>" + HTMLConverter.getH1Tag("Employee Info") + HTMLConverter.getDivIdTag("emp1", str);
    }
    //other method related to customer
}


class HTMLConverter{
    public static String getDivTag(String content){
        return "<div>" + content + "</div>";
    }

    public static String getDivIdTag(String idName, String content){
        return "<div id='"+ idName + "'>" + content + "</div>";
    }

    public static String getDivClassTag(String className, String content){
        return "<div class='"+ className + "'>" + content + "</div>";
    }

    public static String getSpanTag(String content){
        return "<span>" + content + "</span>";
    }

    public static String getH1Tag(String content){
        return "<h1>" + content + "</h1>";
    }
}