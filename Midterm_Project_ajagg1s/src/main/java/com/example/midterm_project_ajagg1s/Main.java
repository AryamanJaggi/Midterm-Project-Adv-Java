package com.example.midterm_project_ajagg1s;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application{
    FlowPane rootNode;
    Button myButton1;
    Button myButton2;
    Button myButton3 = new Button("");
    Button myButton4;
    RadioButton myRadio1;
    RadioButton myRadio2;
    ToggleGroup myToggleGroup1;
    Label label1;
    Label label3 = new Label();
    Stage thisStage = new Stage();
    TextField input1;
    TextField input2;
    TextField input3;
    highClient Oracle = new highClient("Oracle");
    EmployeeFinder oracleEmployeeContract = new EmployeeFinder(100, Oracle, "Oracle Employee Recruitment Contract",
            100000, "Software Developer");
    lowClient John = new lowClient("John");
    JobFinder johnJobContract = new JobFinder(10, John, "John's Job Contract", 100000, "Masters Degree");

    ArrayList teamList = new ArrayList();
    public void start(Stage myStage) {
        thisStage.setTitle("Officium");
        rootNode = new FlowPane(Orientation.VERTICAL, 10, 20);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 500, 500);
        thisStage.setScene(myScene);
        Image icon = new Image("file:src/main/java/1_Officium_Emblem.png");
        thisStage.getIcons().add(icon);
        label1 = new Label("Project Management System");
        label1.setFont(new Font("Arial", 30));
        myButton1 = new Button("Team Setup");
        myButton1.setPrefSize(400, 100);
        myButton1.setOnAction(new ButtonHandler());
        myButton2 = new Button("Time Report");
        myButton2.setPrefSize(400, 100);
        myButton2.setOnAction(new ButtonHandler());
        rootNode.getChildren().addAll(label1, myButton1, myButton2);
        thisStage.show();
    }

    newStage stage = new newStage();
    class ButtonHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            //newStage stage = new newStage();
            if (event.getSource() == myButton1) {
                thisStage.close();
                stage.teamSetup();
            }
            else if (event.getSource() == myButton2){
                thisStage.close();
                stage.timeReport();
            }
            else if (event.getSource() == myButton3) {
                if (myButton3.getText().equals("Time Report")) {
                    stage.timeReport();
                    //myButton3.setText("Team Setup");
                }
                else if (myButton3.getText().equals("Team Setup")) {
                    stage.teamSetup();
                    //myButton3.setText("Time Report");
                }
            }
            else if (event.getSource() == myButton4) {
                //Add the inputs to some sort of Array/ArrayList so that they can be added to the table view.
                //Also remember to create an else if statement to handle the event created by the radio buttons
                if (myRadio1.isSelected()) {
                    teamList.add(new Service (input1.getText(), oracleEmployeeContract.getProjectName(), "Employee Finder",
                            oracleEmployeeContract.getClientAssociation().getName(), oracleEmployeeContract.getClientAssociation().getVolume(),
                            (Double.valueOf(input3.getText())/oracleEmployeeContract.getTotalHours()),
                            (Double.valueOf(input2.getText())-Double.valueOf(input3.getText()))));
                    label3.setStyle(null);
                    label3.setText("Added"); // Remember to add this as a child of the root node so it displays on the screen
                    stage.teamSetup();
                }
                else if (myRadio2.isSelected()) {
                    teamList.add(new Service (input1.getText(), johnJobContract.getProjectName(), "Job Finder",
                            johnJobContract.getClientAssociation().getName(), johnJobContract.getClientAssociation().getVolume(),
                            (Double.valueOf(input3.getText())/johnJobContract.getTotalHours()),
                            (Double.valueOf(input2.getText())-Double.valueOf(input3.getText()))));
                    label3.setStyle(null);
                    label3.setText("Added");
                    stage.teamSetup();
                }

                else {
                    label3.setStyle("-fx-text-fill: red;");
                    label3.setText("Error: Please fill all input fields");
                }
            }
        }
    }
    class newStage extends Stage {
        FlowPane rootNode1;
        Label label2;
        newStage () {
            this.setTitle("Project Management System");
            rootNode1 = new FlowPane(Orientation.VERTICAL);
            this.setScene(new Scene(rootNode1));
            Image icon = new Image("file:src/main/java/1_Officium_Emblem.png");
            this.getIcons().add(icon);
            this.setFullScreen(true);

        }
        public void teamSetup () {
            //myButton3 = new Button("Time Report");
            myButton3.setText("Time Report");
            myButton3.setOnAction(new ButtonHandler());
            Label firstValueLabel = new Label("Team Member Name");
            Label secondValueLabel = new Label("Project Name");
            Label thirdValueLabel = new Label("Amount of Work Hours Available");
            Label fourthValueLabel = new Label("Amount of work hours already utilized");

            input1 = new TextField();
            input2 = new TextField();
            input3 = new TextField();

            myRadio1 = new RadioButton(oracleEmployeeContract.getProjectName());
            myRadio2 = new RadioButton(johnJobContract.getProjectName());
            myToggleGroup1 = new ToggleGroup();
            myRadio1.setToggleGroup(myToggleGroup1);
            myRadio2.setToggleGroup(myToggleGroup1);

            myRadio1.setOnAction(new ButtonHandler());
            myRadio2.setOnAction(new ButtonHandler());

            myButton4 = new Button("Add Team Member");
            myButton4.setOnAction(new ButtonHandler());

            rootNode1.getChildren().clear();
            rootNode1.getChildren().addAll(firstValueLabel, input1, secondValueLabel, myRadio1, myRadio2, thirdValueLabel, input2,
                    fourthValueLabel, input3, myButton4, label3, myButton3);
            this.show();

        }
        public void timeReport () {
            label3.setText("");
            label2 = new Label("Team Member Time Tracking Report");
            TableView serviceTable = new TableView<>();
            //myButton3 = new Button("Team Setup");
            myButton3.setText("Team Setup");
            myButton3.setOnAction(new ButtonHandler());

            // Bind the prefHeight- and prefWidthProperty to the height and width of the stage, so the table fills the stage
            serviceTable.prefHeightProperty().bind(this.heightProperty().subtract(100));
            serviceTable.prefWidthProperty().bind(this.widthProperty());

            // define our table columns
            TableColumn teamMemberName = new TableColumn("Team Member Name");
            TableColumn projName = new TableColumn("Project Name");
            TableColumn projType = new TableColumn("Project Type");
            TableColumn clientName = new TableColumn("Client Name");
            TableColumn clientType = new TableColumn("Client Type");
            TableColumn projCompleted = new TableColumn("Project % Completed");
            TableColumn teammemberHours = new TableColumn("Teammember Hours");


            teamMemberName.setCellValueFactory(new PropertyValueFactory("TeamMemberName"));
            teamMemberName.prefWidthProperty().bind(serviceTable.widthProperty().divide(7));

            projName.setCellValueFactory(new PropertyValueFactory("ProjectName"));
            projName.prefWidthProperty().bind(serviceTable.widthProperty().divide(7));

            projType.setCellValueFactory(new PropertyValueFactory("ProjectType"));
            projType.prefWidthProperty().bind(serviceTable.widthProperty().divide(7));

            clientName.setCellValueFactory(new PropertyValueFactory("ClientName"));
            clientName.prefWidthProperty().bind(serviceTable.widthProperty().divide(7));

            clientType.setCellValueFactory(new PropertyValueFactory("ClientType"));
            clientType.prefWidthProperty().bind(serviceTable.widthProperty().divide(7));

            projCompleted.setCellValueFactory(new PropertyValueFactory ("Project%Completed"));
            projCompleted.prefWidthProperty().bind(serviceTable.widthProperty().divide(7));

            teammemberHours.setCellValueFactory(new PropertyValueFactory ("TeammemberHours"));
            teammemberHours.prefWidthProperty().bind(serviceTable.widthProperty().divide(7));

            ObservableList data = FXCollections.observableArrayList(teamList);
            System.out.println("0");
            serviceTable.setItems(data);
            System.out.println("1");
            serviceTable.getColumns().addAll(teamMemberName, projName, projType, clientName, clientType, projCompleted, teammemberHours);
            System.out.println("2");
            label2.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
            rootNode1.getChildren().clear();
            rootNode1.getChildren().addAll(label2, serviceTable, myButton3);
            System.out.println("3");
            this.show();
            System.out.println("4");
        }
    }
}

