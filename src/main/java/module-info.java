module vidmot.floskumottaka {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens vidmot.floskumottaka to javafx.fxml;
    exports vidmot.floskumottaka;
}