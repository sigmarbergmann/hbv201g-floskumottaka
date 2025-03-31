/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : Stýriklasi fyrir Flöskur. Notandi getur sett inn fjölda flaska,
 *  dósa, hreinsað og fengið greitt fyrir flöskur og dósir
 *****************************************************************************/

package vinnsla.floskumottaka;

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

    /** Setur fjölda flaska og uppfærir virði */
    public void setFjoldiFloskur(int floskur) {
        fjoldiFloskur = floskur;
        virdiFloskur = fjoldiFloskur * FLASKA_ISK;
        samtals();
    }

    /** Setur fjölda dósa og uppfærir virði */
    public void setFjoldiDosir(int dosir) {
        fjoldiDosir = dosir;
        virdiDosir = fjoldiDosir * DOS_ISK;
        samtals();
    }

    /** Skilar virði flaska */
    public int getISKFloskur() {
        return virdiFloskur;
    }

    /** Skilar virði dósa */
    public int getISKDosir() {
        return virdiDosir;
    }

    /** Skilar fjölda flaska */
    public int getFjoldiFloskur() {
        return fjoldiFloskur;
    }

    /** Skilar fjölda dósa */
    public int getFjoldiDosir() {
        return fjoldiDosir;
    }

    /** Skilar samtals fjölda flaska og dósa */
    public int getSamtalsFjoldi() {
        return samtalsFjoldi;
    }

    /** Skilar samtals virði */
    public int getSamtalsVirdi() {
        return samtalsVirdi;
    }

    /** Hreinsar núverandi færslu */
    public void hreinsa() {
        fjoldiFloskur = 0;
        fjoldiDosir = 0;
        virdiFloskur = 0;
        virdiDosir = 0;
        samtalsFjoldi = 0;
        samtalsVirdi = 0;
    }

    /** Vistar færslu og hreinsar hana */
    public void greida() {
        heildFjoldi += samtalsFjoldi;
        heildVirdi += samtalsVirdi;

        fjoldiFloskurSamtals += fjoldiFloskur;
        fjoldiDosirSamtals += fjoldiDosir;

        hreinsa();
    }

    /** Skilar heildarfjölda flaska og dósa */
    public int getHeildFjoldi() {
        return heildFjoldi;
    }

    /** Skilar heildarvirði */
    public int getHeildVirdi() {
        return heildVirdi;
    }

    /** Skilar samtals fjölda flaska eftir margar greiðslur */
    public int getFjoldiFloskurSamtals() {
        return fjoldiFloskurSamtals;
    }

    /** Skilar samtals fjölda dósa eftir margar greiðslur */
    public int getFjoldiDosirSamtals() {
        return fjoldiDosirSamtals;
    }

    /** Uppfærir samtals fjölda og virði */
    private void samtals() {
        samtalsFjoldi = fjoldiFloskur + fjoldiDosir;
        samtalsVirdi = virdiFloskur + virdiDosir;
    }
}
