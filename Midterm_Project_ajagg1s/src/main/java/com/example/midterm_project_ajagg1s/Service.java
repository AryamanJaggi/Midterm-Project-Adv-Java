package com.example.midterm_project_ajagg1s;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Service {

    // member variables with "property" data types
    private StringProperty teamMemberName;
    private StringProperty projectName;
    private StringProperty projectType;
    private StringProperty clientName;
    private StringProperty clientType;
    private DoubleProperty projectCompleted;
    private DoubleProperty teamMemberHours;

    public Service(String tmn, String pn, String pt, String cn, String ct, double pc, double tm) {
        setTeamMemberName(tmn);
        setProjectName(pn);
        setProjectType(pt);
        setClientName(cn);
        setClientType(ct);
        setProjectCompleted(pc);
        setTeamMemberHours(tm);
    }


    public StringProperty teamMemberNameProperty() {
        if (teamMemberName == null) {
            teamMemberName = new SimpleStringProperty(this, "Team Member Name");
        }
        return teamMemberName;
    }


    public void setTeamMemberName(String value) {
        teamMemberNameProperty().set(value);
    }


    public String getTeamMemberName() {
        return teamMemberNameProperty().get();
    }

    public StringProperty projectNameProperty() {
        if (projectName == null) {
            projectName = new SimpleStringProperty(this, "Project Name");
        }
        return projectName;
    }


    public void setProjectName(String value) {
        projectNameProperty().set(value);
    }


    public String getProjectName() {
        return projectNameProperty().get();
    }

    public StringProperty projectTypeProperty() {
        if (projectType == null) {
            projectType = new SimpleStringProperty(this, "Project Type");
        }
        return projectType;
    }

    public void setProjectType(String value) {
        projectTypeProperty().set(value);
    }

    public String getProjectType() {
        return projectTypeProperty().get();
    }

    public StringProperty clientNameProperty() {
        if (clientName == null) {
            clientName = new SimpleStringProperty(this, "Client Name");
        }
        return clientName;
    }

    public void setClientName(String value) {
        clientNameProperty().set(value);
    }

    public String getClientName() {
        return clientNameProperty().get();
    }

    public StringProperty clientTypeProperty() {
        if (clientType == null) {
            clientType = new SimpleStringProperty(this, "Client Type");
        }
        return clientType;
    }

    public void setClientType(String value) {
        clientTypeProperty().set(value);
    }

    public String getClientType() {
        return clientTypeProperty().get();
    }

    public DoubleProperty projectCompletedProperty() {
        if (projectCompleted == null) {
            projectCompleted = new SimpleDoubleProperty(0.0);
        }
        return projectCompleted;
    }

    public void setProjectCompleted(double value) {
        projectCompletedProperty().set(value);
    }

    public Double getProjectCompleted() {
        return projectCompletedProperty().get();
    }

    public DoubleProperty teamMemberHoursProperty() {
        if (teamMemberHours == null) {
            teamMemberHours = new SimpleDoubleProperty( 0.0);
        }
        return teamMemberHours;
    }

    public void setTeamMemberHours(double value) {
        teamMemberHoursProperty().set(value);
    }

    public Double getTeamMemberHours() {
        return teamMemberHoursProperty().get();
    }
}