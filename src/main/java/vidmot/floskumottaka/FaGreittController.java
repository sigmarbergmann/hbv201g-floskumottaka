package vidmot.floskumottaka;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import vinnsla.floskumottaka.Floskur;
import vinnsla.floskumottaka.FloskurData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FaGreittController {

    @FXML private TextArea fxKvittun;
    @FXML private Button btnPeningar;
    @FXML private Button btnKort;

    private final Floskur floskur = FloskurData.getFloskur();
    private boolean erGreitt = false;

    public void initialize() {
        fxKvittun.setText("Veldu greiðslumáta til að fá kvittun.\n");
    }

    @FXML
    protected void onPeningar() {
        if (erGreitt) return;
        birtaKvittun("Peningar");
        btnPeningar.setDisable(true);
        btnKort.setDisable(true);
        erGreitt = true;
    }

    @FXML
    protected void onKort() {
        if (erGreitt) return;
        birtaKvittun("Kort");
        btnPeningar.setDisable(true);
        btnKort.setDisable(true);
        erGreitt = true;
    }

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

    @FXML
    public void fxStopButtonHandler(ActionEvent event) {
        ViewSwitcher.switchTo(View.KVEDJA);
    }
}
