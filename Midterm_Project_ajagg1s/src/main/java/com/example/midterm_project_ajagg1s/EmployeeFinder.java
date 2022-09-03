package com.example.midterm_project_ajagg1s;

public class EmployeeFinder extends project {
    private int salary;
    private String position;
    public EmployeeFinder(int totalHours, client clientAssociation, String projectName, int salary, String position) {
        super(totalHours, clientAssociation, projectName);
        this.salary = salary;
        this.position = position;
    }


}
