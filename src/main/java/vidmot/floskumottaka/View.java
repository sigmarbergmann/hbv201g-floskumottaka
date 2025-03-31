package vidmot.floskumottaka;

/******************************************************************************
 *  Nafn    : Sigmar Bergmann Sigurvinsson
 *  T-póstur: sbs85@hi.is
 *
 *  Lýsing  : Enum sem skilgreinir mismunandi viðmót í viðtalsforritinu.
 *
 *****************************************************************************/
public enum View {
    VELKOMINN("/vidmot/floskumottaka/velkominn-view.fxml"),
    FA_GREITT("fa-greitt-view.fxml"),
    FLOSKUR("/vidmot/floskumottaka/floskur-view.fxml"),
    KVEDJA("/vidmot/floskumottaka/kvedja-view.fxml");

    private String fileName;

    /**
     * Smiður fyrir enum gildi sem tengir viðmót við FXML skrá.
     *
     * @param fileName slóð á viðkomandi FXML skrá
     */
    View(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Skilar slóð á FXML skrá fyrir viðkomandi viðmót.
     *
     * @return slóð á FXML skrá
     */
    public String getFileName() {
        return fileName;
    }
}
