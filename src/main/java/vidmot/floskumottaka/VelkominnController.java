package vidmot.floskumottaka;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/******************************************************************************
 *  Nafn    : Sigmar Bergmann Sigurvinsson
 *  T-póstur: sbs85@hi.is
 *
 *  Lýsing  : Stýrir velkomnaviðmóti í viðtalsforritinu, þar sem notandi getur
 *            valið að hefja spurningar eða hætta í forritinu.
 *
 *****************************************************************************/
public class VelkominnController {
    @FXML
    private Button fxSpButton;
    @FXML
    private Button fxStopButton;

    /**
     * Skiptir yfir í spurningaviðmót.
     *
     * @param event viðburður þegar ýtt er á "Byrja spurningar" hnappinn
     */
    public void fxByrjaFloskumottoku(ActionEvent event) {
        ViewSwitcher.switchTo(View.FLOSKUR);
    }

    /**
     * Skiptir yfir í kveðjuviðmót til að hætta í forritinu.
     *
     * @param event viðburður þegar ýtt er á "Hætta" hnappinn
     */
    public void fxStopButtonHandler(ActionEvent event) {
        ViewSwitcher.switchTo(View.KVEDJA);
    }
}
