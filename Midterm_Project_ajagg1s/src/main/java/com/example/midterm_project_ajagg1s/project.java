package com.example.midterm_project_ajagg1s;

abstract class project {
    protected int totalHours; // total amount of hours budgeted for
    protected client clientAssociation;
    protected String projectName;
    public int getTotalHours() {
        return totalHours;
    }
    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }
    public client getClientAssociation() {
        return clientAssociation;
    }
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public project (int totalHours, client clientAssociation, String projectName) {
        this.totalHours = totalHours;
        this.clientAssociation = clientAssociation;
        this.projectName = projectName;
    }

}
