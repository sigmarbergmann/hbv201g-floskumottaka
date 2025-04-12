package vinnsla.floskumottaka;

/******************************************************************************
 *  Nafn    : Sigmar Bergmann Sigurvinsson
 *  T-póstur: sbs85@hi.is
 *
 *  Lýsing  : Klasi sem gefur einfalt þjónustuver við spurningum sem tengjast
 *            flöskumóttöku. Svör eru á íslensku og byggt á lykilorðum.
 *****************************************************************************/

/**
 * Klasinn veitir sjálfvirk svör við algengum spurningum um flöskumóttöku.
 * Notar lykilorð til að bera kennsl á innihald spurningar og skilar viðeigandi svari.
 */
public class FeedbackService {

    /**
     * Skilar tilbúnu svari við spurningu eftir efni hennar.
     *
     * @param question spurning frá notanda
     * @return svarið sem hæfir spurningunni
     */
    public static String provideFeedback(String question) {
        if (question == null || question.trim().isEmpty()) {
            return "Svarið þitt er alltof stutt, reyndu að orða spurninguna betur.";
        }

        if (question.toLowerCase().contains("opnunartími") ||
                question.toLowerCase().contains("opnar") ||
                question.toLowerCase().contains("opið")) {
            return "Flöskumóttakan er opin allan sólahringinn, alla daga vikunnar, svo þú getur komið með flöskurnar þínar hvenær sem þér hentar.";
        }

        if (question.toLowerCase().contains("flösk") ||
                question.toLowerCase().contains("dós") ||
                question.toLowerCase().contains("skilagjald") ||
                question.toLowerCase().contains("skilagildi")) {

            return "Við tökum á móti öllum flöskum og dósum. Þú færð 15 krónur fyrir hverja flösku og 10 krónur fyrir hverja dós.";
        }

        return "Við skiljum ekki alveg spurninguna. Reyndu að orða hana aðeins skýrar.";
    }

    /**
     * Aðal aðferð til að prófa provideFeedback() með spurningu.
     *
     * @param args ekki notað
     */
    public static void main(String[] args) {
        String userQuestion = "Hvenær er opið?";
        System.out.println(provideFeedback(userQuestion));
    }
}
