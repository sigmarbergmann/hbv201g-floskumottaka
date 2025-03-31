package vinnsla.floskumottaka;

public class FloskurData {
    private static final Floskur floskur = new Floskur();

    public static Floskur getFloskur() {
        return floskur;
    }
}
