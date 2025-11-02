module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires javafx.base;


    opens com.example.project to javafx.fxml;
    exports com.example.project;
    exports com.example.project.Game;
    opens com.example.project.Game to javafx.fxml;
    exports com.example.project.Start;
    opens com.example.project.Start to javafx.fxml;
    exports com.example.project.Usernames;
    opens com.example.project.Usernames to javafx.fxml;
    exports com.example.project.Util;
    opens com.example.project.Util to javafx.fxml;
}