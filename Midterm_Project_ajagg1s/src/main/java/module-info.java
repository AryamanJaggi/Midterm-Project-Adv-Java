module com.example.midterm_project_ajagg1s {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.midterm_project_ajagg1s to javafx.fxml;
    exports com.example.midterm_project_ajagg1s;
}