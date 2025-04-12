/******************************************************************************
 *  Nafn    : Sigmar Bergmann Sigurvinsson
 *  T-póstur: sbs85@hi.is
 *
 *  Lýsing  : Geymir eina tilviksbreytu af Floskur sem hægt er að nálgast í gegnum
 *            aðferðina getFloskur(). Notað til að miðla gögnum milli hluta forritsins.
 *
 *****************************************************************************/
package vinnsla.floskumottaka;

/**
 * Gagnaklasi sem heldur utan um eina sameiginlega tilviksbreytu af Floskur.
 */
public class FloskurData {
    private static final Floskur floskur = new Floskur();

    /**
     * Skilar tilviksbreytunni floskur.
     *
     * @return hlut af taginu Floskur
     */
    public static Floskur getFloskur() {
        return floskur;
    }
}
