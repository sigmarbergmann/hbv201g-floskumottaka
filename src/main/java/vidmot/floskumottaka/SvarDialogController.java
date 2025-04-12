/******************************************************************************
 *  Nafn    : Sigmar Bergmann Sigurvinsson
 *  T-póstur: sbs85@hi.is
 *
 *  Lýsing  : Controller fyrir spurninga-díalóg þar sem notandi getur slegið
 *            inn spurningu og fengið svar frá FeedbackService.
 *****************************************************************************/

package vidmot.floskumottaka;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import vinnsla.floskumottaka.FeedbackService;

import java.io.IOException;

/**
 * Controller fyrir spurningaglugga sem birtir svör við spurningum
 * sem slegnar eru inn af notanda. Notar FeedbackService til að bregðast við.
 */
public class SvarDialogController extends Dialog<Void> {

    @FXML
    private TextField fxSvarTextField;

    @FXML
    private Label fxSvarDialogText;

    @FXML
    private Label fxFeedbackLabel;

    /**
     * Smiður sem les inn FXML skjámynd og setur tengingar við UI-hluta.
     */
    public SvarDialogController() {
        setDialogPane(lesaDialog());
        setUpBindings();
    }

    /**
     * Les inn dialog úr FXML skrá og tengir við controllerinn.
     *
     * @return tilbúinn DialogPane hlutur
     */
    private DialogPane lesaDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vidmot/floskumottaka/svar-view.fxml"));
        fxmlLoader.setController(this);
        try {
            return fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Setur upp texta og viðburð fyrir textasvæðið sem les spurningu
     * og birtir svar frá FeedbackService í merkimiða.
     */
    private void setUpBindings() {
        fxSvarDialogText.setText("Hvað viltu spyrja um?");
        fxSvarTextField.setOnAction(event -> {
            String spurning = fxSvarTextField.getText();
            fxFeedbackLabel.setText(FeedbackService.provideFeedback(spurning));
        });
    }
}
