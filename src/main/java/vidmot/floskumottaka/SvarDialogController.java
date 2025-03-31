package vidmot.floskumottaka;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import vinnsla.floskumottaka.FeedbackService;

import java.io.IOException;

public class SvarDialogController extends Dialog<Void> {

    @FXML
    private TextField fxSvarTextField;
    @FXML
    private Label fxSvarDialogText;
    @FXML
    private Label fxFeedbackLabel;

    public SvarDialogController() {
        setDialogPane(lesaDialog());
        setUpBindings();
    }

    private DialogPane lesaDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vidmot/floskumottaka/svar-view.fxml"));
        fxmlLoader.setController(this);
        try {
            return fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void setUpBindings() {
        fxSvarDialogText.setText("Hvað viltu spyrja um?");
        fxSvarTextField.setOnAction(event -> {
            String spurning = fxSvarTextField.getText();
            fxFeedbackLabel.setText(FeedbackService.provideFeedback(spurning));
        });

    }
}
