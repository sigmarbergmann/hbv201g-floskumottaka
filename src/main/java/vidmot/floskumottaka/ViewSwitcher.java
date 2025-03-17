package vidmot.floskumottaka;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/******************************************************************************
 *  Nafn    : Sigmar Bergmann Sigurvinsson
 *  T-póstur: sbs85@hi.is
 *
 *  Lýsing  : Sér um að skipta á milli viðmóta.
 *
 *****************************************************************************/
public class ViewSwitcher {

    private static final Map<View, Parent> cache = new HashMap<>();
    private static Scene scene;

    /**
     * Setur núverandi senu í ViewSwitcher.
     *
     * @param scene senan sem á að nota
     */
    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }

    /**
     * Skiptir yfir í viðmót sem tilgreint er
     *
     * @param view viðmótið sem á að birta
     */
    public static void switchTo(View view) {
        if (scene == null) {
            System.out.println("No scene was set");
            return;
        }

        try {
            Parent root;
            if (cache.containsKey(view)) {
                System.out.println("Loading from cache");
                root = cache.get(view);
            } else {
                System.out.println("Loading from FXML");
                root = FXMLLoader.load(
                        ViewSwitcher.class.getResource(view.getFileName())
                );
                cache.put(view, root);
            }

            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
