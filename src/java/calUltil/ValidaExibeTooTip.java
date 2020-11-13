package calUltil;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;

import java.lang.reflect.Field;

public class ValidaExibeTooTip {
    public static void tempoToolTip(Tooltip tooltip) {
        try {
            //criar campo para msg
            Field fildBehavior = tooltip.getClass().getDeclaredField("BEHAVIOR");
            fildBehavior.setAccessible(true);
            Object objBehavior = fildBehavior.get(tooltip);
            //ativar o tempo para mostrar a msg
            Field fildTimer = objBehavior.getClass().getDeclaredField("activationTime");
            fildBehavior.setAccessible(true);
            Timeline objTime = (Timeline) fildBehavior.get(objBehavior);
            //limpar frame e add tempo para mostrar
            objTime.getKeyFrames().clear();
            objTime.getKeyFrames().add(new KeyFrame(new Duration(1)));


        } catch (SecurityException | IllegalArgumentException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void removerCorBordaTooTip(Node n, Tooltip t) {
        Tooltip.install(n, t); //-> aqui add txfild e msg
        n.setStyle("-fx-border-color: #0031e1;");
    }

    public static void addCorBordaTooTip(Node n, Tooltip t) {
        Tooltip.install(n, t); //-> aqui add txfild e msg
        n.setStyle("-fx-border-color: #0031e1;");
    }
}

