/*****************************************************************************
 *  Nafn    : Sigmar Bergmann Sigurvinsson
 *  T-póstur: sbs85@hi.is
 *  Lýsing  : Stýriklasi fyrir Flöskur. Notandi getur sett inn fjölda flaska,
 *  dósa, hreinsað og fengið
 *  greitt fyrir flöskur og dósir
 *****************************************************************************/

package vidmot.floskumottaka;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import vinnsla.floskumottaka.Floskur;
import vinnsla.floskumottaka.FloskurData;

import java.util.List;

/**
 * Stýrir aðgerðum í viðmóti fyrir flöskumóttöku. Heldur utan um
 * tengingar við gagnaklasa, les inntak frá notanda, reiknar virði og
 * uppfærir viðmót eftir aðgerðum.
 */
public class FloskurController {

    // fastar
    private static final String RANGT = "rangt-inntak";

    // viðmótshlutir
    @FXML
    private TextField fxFloskur;
    @FXML
    private TextField fxDosir;
    @FXML
    public Label fxISKFloskur;
    @FXML
    public Label fxISKDosir;
    @FXML
    public Label fxSamtalsFjoldi;
    @FXML
    public Label fxSamtalsVirdi;
    @FXML
    public Label fxHeildFjoldi;
    @FXML
    public Label fxHeildVirdi;

    // vinnsla
    private final Floskur floskur = FloskurData.getFloskur();

    /**
     * Setur inn fjölda flaska og reiknar virði.
     *
     * @param ignoredEvent ónotaður ActionEvent
     */
    @FXML
    protected void onFloskur(ActionEvent ignoredEvent) {
        try {
            int fjoldi = Integer.parseInt(fxFloskur.getText());
            if (fjoldi > 0) {
                floskur.setFjoldiFloskur(fjoldi);
                fxISKFloskur.setText(floskur.getISKFloskur() + "");
                setSamtals();
            } else {
                neikvaedurFjoldi(fxFloskur);
            }
        } catch (NumberFormatException e) {
            fxFloskur.getStyleClass().add(RANGT);
        }
    }

    /**
     * Setur inn fjölda dósa og reiknar virði.
     *
     * @param actionEvent ónotaður atburður
     */
    @FXML
    protected void onDosir(ActionEvent actionEvent) {
        try {
            int fjoldi = Integer.parseInt(fxDosir.getText());
            if (fjoldi > 0) {
                floskur.setFjoldiDosir(fjoldi);
                fxISKDosir.setText(floskur.getISKDosir() + "");
                setSamtals();
            } else {
                neikvaedurFjoldi(fxDosir);
            }
        } catch (NumberFormatException e) {
            fxDosir.getStyleClass().add(RANGT);
        }
    }

    /**
     * Hreinsar viðmótið og núverandi færslu.
     *
     * @param actionEvent ónotað
     */
    @FXML
    protected void onHreinsa(ActionEvent actionEvent) {
        floskur.hreinsa();
        fxDosir.setText(floskur.getFjoldiDosir() + "");
        fxFloskur.setText(floskur.getFjoldiFloskur() + "");
        fxISKDosir.setText(floskur.getISKDosir() + "");
        fxISKFloskur.setText(floskur.getISKFloskur() + "");
        eydaRanga(fxDosir.getStyleClass());
        eydaRanga(fxFloskur.getStyleClass());
        setSamtals();
    }

    /**
     * Greiðir fyrir flöskur og dósir og uppfærir heildartölur.
     *
     * @param actionEvent ónotað
     */
    @FXML
    protected void onGreida(ActionEvent actionEvent) {
        floskur.greida();
        fxHeildFjoldi.setText(floskur.getHeildFjoldi() + "");
        fxHeildVirdi.setText(floskur.getHeildVirdi() + "");
        onHreinsa(actionEvent);
    }

    /**
     * Fjarlægir villustíl þegar notandi skrifar aftur í reit.
     *
     * @param keyEvent atburður frá lyklaborði
     */
    public void onStafur(KeyEvent keyEvent) {
        TextField textField = (TextField) keyEvent.getSource();
        List<String> styleClasses = textField.getStyleClass();
        keyEydaRanga(keyEvent, styleClasses);
    }

    // hjálparaðferðir

    /**
     * Fjarlægir rauðan stíl ef ýtt er á takka sem er ekki ENTER.
     *
     * @param keyEvent     atburður frá lyklaborði
     * @param styleClasses stíllisti sem þarf að uppfæra
     */
    private static void keyEydaRanga(KeyEvent keyEvent, List<String> styleClasses) {
        if (styleClasses == null || styleClasses.isEmpty()) return;
        if (keyEvent.getCode() != KeyCode.ENTER) {
            eydaRanga(styleClasses);
        }
    }

    /**
     * Fjarlægir rauðan stíl (rangt-inntak) úr styleClass listanum.
     *
     * @param styleClasses stíllisti sem á að hreinsa
     */
    private static void eydaRanga(List<String> styleClasses) {
        styleClasses.remove(RANGT);
    }

    /**
     * Uppfærir samtals fjölda og virði í viðmóti.
     */
    private void setSamtals() {
        int samtalsFjoldi = floskur.getSamtalsFjoldi();
        int samtalsVirdi = floskur.getSamtalsVirdi();
        fxSamtalsFjoldi.setText(samtalsFjoldi + "");
        fxSamtalsVirdi.setText(samtalsVirdi + "");
    }

    /**
     * Bætir við villustíl ef inntakið er neikvætt.
     *
     * @param f TextField sem á að merkja sem rangt ef fjöldi < 0
     */
    private void neikvaedurFjoldi(TextField f) {
        int value = Integer.parseInt(f.getText());
        if (value < 0) {
            f.getStyleClass().add(RANGT);
        }
    }

    /**
     * Skiptir yfir í aðalviðmót þegar ýtt er á „Til baka“ hnappinn.
     *
     * @param event viðburður
     */
    @FXML
    public void fxTilbakaButtonHandler(ActionEvent event) {
        ViewSwitcher.switchTo(View.VELKOMINN);
    }

    /**
     * Skiptir yfir í kveðjuviðmót þegar ýtt er á „Hætta“ hnappinn.
     *
     * @param event viðburður
     */
    public void fxStopButtonHandler(ActionEvent event) {
        ViewSwitcher.switchTo(View.KVEDJA);
    }

    /**
     * Opnar þjónustuver dialog sem birtir svör við spurningum notanda.
     *
     * @param event viðburður
     */
    public void fxThjonustuverHandler(ActionEvent event) {
        SvarDialogController dialog = new SvarDialogController();
        dialog.showAndWait();
    }

    /**
     * Skiptir yfir í kvittunarviðmót þegar ýtt er á „Fá greitt“ hnappinn.
     *
     * @param event viðburður
     */
    public void fxFaGreittButtonHandler(ActionEvent event) {
        ViewSwitcher.switchTo(View.FA_GREITT);
    }
}
