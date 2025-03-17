package vidmot.floskumottaka;

import javafx.application.Platform;

/******************************************************************************
 *  Nafn    : Sigmar Bergmann Sigurvinsson
 *  T-póstur: sbs85@hi.is
 *
 *  Lýsing  : Stýriklasi fyrir kveðjutakka í forritinu.
 *
 *****************************************************************************/
public class KvedjaController {

    /**
     * Lokar forritinu þegar ýtt er á kveðjutakka.
     */
    public void fxKvedjaTakki() {
        Platform.exit();
    }
}
