package calUltil;

import javafx.application.Platform;
import javafx.scene.control.TextField;

import java.util.Locale;

public class MaskCampoCalc {
    private static void limitarTamanho(TextField textField, Integer tamanho) {

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null || newValue.length() > tamanho) {
                textField.setText(oldValue);
            }
        });
    }

    public static void mskNumero(TextField textField) {

        MaskCampoCalc.limitarTamanho(textField, 16);
        textField.lengthProperty().addListener((observable, oldValue, newValue) -> {
            Locale.setDefault(Locale.US);

            String textDigitado = textField.getText();
            textDigitado = textDigitado.replaceAll("[^0-9]", ""); //expressao regular
            textField.setText(String.format("%00,0f",textDigitado));
            MaskCampoCalc.posionarCursor(textField);
        });
    }

    //expressao lambida
    private static void posionarCursor(TextField textField) {
        Platform.runLater(() -> {
            if (textField.getText().length() != 0) {
                textField.positionCaret(textField.getText().length());
            }
        });
    }
}
