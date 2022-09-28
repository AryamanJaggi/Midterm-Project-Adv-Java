package com.example.midterm_project_ajagg1s;

public class TeamMember {
    private project projectAssociation;
    private String name;
    private int hoursAllocated;
    private int hoursUtilized;

    public TeamMember(project projectAssociation, String name, int hoursAllocated, int hoursUtilized) {
        this.projectAssociation = projectAssociation;
        this.name = name;
        this.hoursAllocated = hoursAllocated;
        this.hoursUtilized = hoursUtilized;
    }
    public project getProjectAssociation() {
        return projectAssociation;
    }
    public void setProjectAssociation(project projectAssociation) {
        this.projectAssociation = projectAssociation;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHoursAllocated() {
        return hoursAllocated;
    }
    public void setHoursAllocated(int hoursAllocated) {
        this.hoursAllocated = hoursAllocated;
    }
    public int getHoursUtilized() {
        return hoursUtilized;
    }
    public void setHoursUtilized(int hoursUtilized) {
        this.hoursUtilized = hoursUtilized;
    }
}
