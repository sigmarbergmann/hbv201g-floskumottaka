/******************************************************************************
 *  Nafn    : Sigmar Bergmann Sigurvinsson
 *  T-póstur: sbs85@hi.is
 *
 *  Lýsing  : Stýriklasi fyrir Flöskur. Notandi getur sett inn fjölda flaska,
 *  dósa, hreinsað og fengið greitt fyrir flöskur og dósir
 *****************************************************************************/

package vinnsla.floskumottaka;

/**
 * Klasinn heldur utan um magn og virði flaska og dósa sem notandi skilar.
 * Býður upp á að skrá færslur, reikna samtöl og halda utan um heildartölur.
 */
public class Floskur {

    private static final int FLASKA_ISK = 15;
    private static final int DOS_ISK = 10;

    private int fjoldiFloskur;
    private int fjoldiDosir;
    private int virdiFloskur;
    private int virdiDosir;
    private int samtalsFjoldi;
    private int samtalsVirdi;

    private int heildFjoldi;
    private int heildVirdi;

    private int fjoldiFloskurSamtals;
    private int fjoldiDosirSamtals;

    /**
     * Setur fjölda flaska og uppfærir virði og samtalsgildi.
     *
     * @param floskur fjöldi flaska
     */
    public void setFjoldiFloskur(int floskur) {
        fjoldiFloskur = floskur;
        virdiFloskur = fjoldiFloskur * FLASKA_ISK;
        samtals();
    }

    /**
     * Setur fjölda dósa og uppfærir virði og samtalsgildi.
     *
     * @param dosir fjöldi dósa
     */
    public void setFjoldiDosir(int dosir) {
        fjoldiDosir = dosir;
        virdiDosir = fjoldiDosir * DOS_ISK;
        samtals();
    }

    /**
     * Skilar virði flaska í ISK.
     *
     * @return virði flaska
     */
    public int getISKFloskur() {
        return virdiFloskur;
    }

    /**
     * Skilar virði dósa í ISK.
     *
     * @return virði dósa
     */
    public int getISKDosir() {
        return virdiDosir;
    }

    /**
     * Skilar fjölda flaska í núverandi færslu.
     *
     * @return fjöldi flaska
     */
    public int getFjoldiFloskur() {
        return fjoldiFloskur;
    }

    /**
     * Skilar fjölda dósa í núverandi færslu.
     *
     * @return fjöldi dósa
     */
    public int getFjoldiDosir() {
        return fjoldiDosir;
    }

    /**
     * Skilar samtals fjölda flaska og dósa í núverandi færslu.
     *
     * @return samtals fjöldi
     */
    public int getSamtalsFjoldi() {
        return samtalsFjoldi;
    }

    /**
     * Skilar samtals virði í núverandi færslu.
     *
     * @return samtals virði
     */
    public int getSamtalsVirdi() {
        return samtalsVirdi;
    }

    /**
     * Hreinsar núverandi færslu — núllstillir fjölda og virði.
     */
    public void hreinsa() {
        fjoldiFloskur = 0;
        fjoldiDosir = 0;
        virdiFloskur = 0;
        virdiDosir = 0;
        samtalsFjoldi = 0;
        samtalsVirdi = 0;
    }

    /**
     * Vistar núverandi færslu í heildartölur og hreinsar hana.
     */
    public void greida() {
        heildFjoldi += samtalsFjoldi;
        heildVirdi += samtalsVirdi;

        fjoldiFloskurSamtals += fjoldiFloskur;
        fjoldiDosirSamtals += fjoldiDosir;

        hreinsa();
    }

    /**
     * Skilar heildarfjölda flaska og dósa eftir allar greiðslur.
     *
     * @return heildarfjöldi
     */
    public int getHeildFjoldi() {
        return heildFjoldi;
    }

    /**
     * Skilar heildarvirði eftir allar greiðslur.
     *
     * @return heildarvirði
     */
    public int getHeildVirdi() {
        return heildVirdi;
    }

    /**
     * Skilar samtals fjölda flaska eftir margar greiðslur.
     *
     * @return fjöldi flaska samtals
     */
    public int getFjoldiFloskurSamtals() {
        return fjoldiFloskurSamtals;
    }

    /**
     * Skilar samtals fjölda dósa eftir margar greiðslur.
     *
     * @return fjöldi dósa samtals
     */
    public int getFjoldiDosirSamtals() {
        return fjoldiDosirSamtals;
    }

    /**
     * Uppfærir samtals fjölda og virði út frá núverandi fjölda flaska og dósa.
     */
    private void samtals() {
        samtalsFjoldi = fjoldiFloskur + fjoldiDosir;
        samtalsVirdi = virdiFloskur + virdiDosir;
    }
}
