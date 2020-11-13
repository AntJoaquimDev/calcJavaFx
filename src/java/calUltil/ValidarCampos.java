package calUltil;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

import java.util.ArrayList;
import java.util.List;

public class ValidarCampos {

    private static final Tooltip tooltip = new Tooltip("Digite Números para Obter resultados");

    public static boolean checarCampoVazio(Node... no) {
        List<Node> camposFalha = new ArrayList<>();
        tooltip.setStyle("-fx-backgraud-color: linear-gradient(#000000,#B222222);" + "-fx-font-weight:bold;");
        ValidaExibeTooTip.tempoToolTip(tooltip);
        for (Node n : no) {
            TextField textField = (TextField) n;
            textField.textProperty().addListener(((observable, oldValue, newValue) -> {
                ValidaExibeTooTip.removerCorBordaTooTip(textField, tooltip);
            }));
            // se o campo estiver vazio add a borda
            if (textField.getText().trim().equals("")) {

                camposFalha.add(n);
                ValidaExibeTooTip.addCorBordaTooTip(textField, tooltip);
            }
        }


        return camposFalha.isEmpty();
    }
}


