/******************************************************************************
 *  Nafn    : Sigmar Bergmann Sigurvinsson
 *  T-póstur: sbs85@hi.is
 *  Lýsing  : Application klasi sem les inn notendaviðmótslýsingu úr .fxml og ræsir gluggann
 *
 *
 *****************************************************************************/

package vidmot.floskumottaka;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class FloskurApplication extends Application {
    @Override
    public void start(Stage stage) {
        var scene = new Scene(new Pane());
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.VELKOMINN);
        stage.setTitle("Flöskumóttaka");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}