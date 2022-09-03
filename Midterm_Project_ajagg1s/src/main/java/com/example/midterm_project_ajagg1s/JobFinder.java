package com.example.midterm_project_ajagg1s;

public class JobFinder extends project{
    private int minPay;
    private String highestLevelQualification; // high school diploma, industrial certification, degree, masters, phd, etc.
    public JobFinder(int totalHours, client clientAssociation, String projectName, int minPay, String highestLevelQualification) {
        super(totalHours, clientAssociation, projectName);
        this.minPay = minPay;
        this.highestLevelQualification = highestLevelQualification;
    }
}
