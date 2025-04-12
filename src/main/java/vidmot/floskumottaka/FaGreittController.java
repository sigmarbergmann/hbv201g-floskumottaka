/******************************************************************************
 *  Nafn    : Sigmar Bergmann Sigurvinsson
 *  T-póstur: sbs85@hi.is
 *
 *  Lýsing  : Controller sem birtir kvittun og sér um greiðsluaðgerðir með
 *            peningum eða korti. Lokar fyrir frekari greiðslu þegar greitt hefur verið.
 *****************************************************************************/

package vidmot.floskumottaka;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import vinnsla.floskumottaka.Floskur;
import vinnsla.floskumottaka.FloskurData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Controller fyrir kvittunarskjá. Sér um að birta kvittun og meðhöndla val á greiðslumáta.
 */
public class FaGreittController {

    @FXML private TextArea fxKvittun;
    @FXML private Button btnPeningar;
    @FXML private Button btnKort;

    private final Floskur floskur = FloskurData.getFloskur();
    private boolean erGreitt = false;

    /**
     * Upphafsstillir viðmótið með skilaboðum til notanda.
     */
    public void initialize() {
        fxKvittun.setText("Veldu greiðslumáta til að fá kvittun.\n");
    }

    /**
     * Handler þegar notandi velur að fá greitt með peningum.
     * Birtir kvittun og lokar fyrir frekari val.
     */
    @FXML
    protected void onPeningar() {
        if (erGreitt) return;
        birtaKvittun("Peningar");
        btnPeningar.setDisable(true);
        btnKort.setDisable(true);
        erGreitt = true;
    }

    /**
     * Handler þegar notandi velur að fá greitt með korti.
     * Birtir kvittun og lokar fyrir frekari val.
     */
    @FXML
    protected void onKort() {
        if (erGreitt) return;
        birtaKvittun("Kort");
        btnPeningar.setDisable(true);
        btnKort.setDisable(true);
        erGreitt = true;
    }

    /**
     * Býr til kvittun sem inniheldur upplýsingar um fjölda og virði skilaðra eininga,
     * greiðslumáta og dagsetningu.
     *
     * @param leid greiðslumáti sem notandi valdi ("Peningar" eða "Kort")
     */
    private void birtaKvittun(String leid) {
        String dagsetningOgTimi = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));

        int fjoldiFloskur = floskur.getFjoldiFloskurSamtals();
        int fjoldiDosir = floskur.getFjoldiDosirSamtals();
        int heildFjoldi = floskur.getHeildFjoldi();
        int heildVirdi = floskur.getHeildVirdi();

        int samtalsFloskur = fjoldiFloskur * 15;
        int samtalsDosir = fjoldiDosir * 10;

        String kvittun = String.format("""
                
                Vara       Magn   Eining   Samtals
                ------------------------------------------
                Dósir       %2d     10 kr.    %5d kr.
                Flöskur     %2d     15 kr.    %5d kr.
        
                ------------------------------------------
                Samtals:   %2d stk.           %5d kr.
        
                Greiðslumáti:   %s
                Dagsetning:     %s
                """,
                fjoldiDosir, samtalsDosir,
                fjoldiFloskur, samtalsFloskur,
                heildFjoldi, heildVirdi,
                leid,
                dagsetningOgTimi
        );

        fxKvittun.setText(kvittun);
        floskur.greida();
    }

    /**
     * Skiptir yfir í kveðjuviðmót þegar notandi ýtir á „Hætta“ hnappinn.
     *
     * @param event viðburður sem kemur frá hnappi
     */
    @FXML
    public void fxStopButtonHandler(ActionEvent event) {
        ViewSwitcher.switchTo(View.KVEDJA);
    }
}
