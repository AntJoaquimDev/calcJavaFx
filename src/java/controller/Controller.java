package controller;

import calUltil.MaskCampoCalc;
import calUltil.ValidarCampos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button btnSete;

    @FXML
    private Button btnOito;

    @FXML
    private Button btnNove;

    @FXML
    private Button btnQuatro;

    @FXML
    private Button btnCinco;

    @FXML
    private Button btnSeis;

    @FXML
    private Button btnDiv;

    @FXML
    private Button btnUm;

    @FXML
    private Button btnDois;

    @FXML
    private Button btnTres;

    @FXML
    private Button btnSubt;

    @FXML
    private Button btnZero;

    @FXML
    private Button btnPonto;

    @FXML
    private Button btnIgual;

    @FXML
    private Button btnAdicao;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnMult;


    @FXML
    private TextField txfTelaCalc;
    double resultado = 0;
    String operacao;
    double valor1 = 0;
    double valor2 = 0;


    public void initialize(URL location, ResourceBundle resources) {
        focusTela();
        masckCamp();
        btnUm.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                ValidarCampos.checarCampoVazio();
                txfTelaCalc.setText(txfTelaCalc.getText() + "1");
                limparTootip();
            }
        });
        btnDois.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                txfTelaCalc.setText(txfTelaCalc.getText() + "2");
                limparTootip();
            }
        });
        btnTres.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                txfTelaCalc.setText(txfTelaCalc.getText() + "3");
                limparTootip();
            }
        });

        btnQuatro.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                txfTelaCalc.setText(txfTelaCalc.getText() + "4");
                limparTootip();
            }
        });
        btnCinco.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                txfTelaCalc.setText(txfTelaCalc.getText() + "5");
                limparTootip();
            }
        });
        btnSeis.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                txfTelaCalc.setText(txfTelaCalc.getText() + "6");
                limparTootip();
            }
        });
        btnSete.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                txfTelaCalc.setText(txfTelaCalc.getText() + "7");
                limparTootip();
            }
        });
        btnOito.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                txfTelaCalc.setText(txfTelaCalc.getText() + "8");
                limparTootip();
            }
        });
        btnNove.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                txfTelaCalc.setText(txfTelaCalc.getText() + "9");
                limparTootip();
            }
        });
        btnZero.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                txfTelaCalc.setText(txfTelaCalc.getText() + "0");
                limparTootip();
            }
        });

        btnMult.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                valor1 = Double.parseDouble(txfTelaCalc.getText());
                txfTelaCalc.setText("");
                operacao = "*";
            }
        });
        btnDiv.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                valor1 = Double.parseDouble(txfTelaCalc.getText());
                txfTelaCalc.setText("");
                operacao = "/";
            }
        });

        btnAdicao.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                valor1 = Double.parseDouble(txfTelaCalc.getText());
                txfTelaCalc.setText("");
                operacao = "+";

            }
        });

        btnSubt.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                valor1 = Double.parseDouble(txfTelaCalc.getText());
                txfTelaCalc.setText("");
                operacao = "-";

            }
        });

        btnClear.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                txfTelaCalc.clear();
                valor1 = 0;
                valor2 = 0;
                operacao = "";
                txfTelaCalc.requestFocus();
            }
        });
       }

    @FXML
    void calcResultado(ActionEvent event) {
        if (ValidarCampos.checarCampoVazio(txfTelaCalc)) {

            valor2 = Double.parseDouble(txfTelaCalc.getText());

            switch (operacao) {
                case "+":
                    resultado = valor1 + valor2;
                    txfTelaCalc.setText(String.valueOf(resultado));

                    break;
                case "-":
                    resultado = valor1 - valor2;
                    txfTelaCalc.setText(String.valueOf(resultado));
                    System.out.println(resultado);
                    break;
                case "*":
                    resultado = valor1 * valor2;
                    txfTelaCalc.setText(String.valueOf(resultado));
                    System.out.println(resultado);
                    break;
                case "/":
                    resultado = valor1 / valor2;
                    txfTelaCalc.setText(String.valueOf(resultado));
                    System.out.println(resultado);
                    break;
            }

        }
    }

    public void limparTootip() {
        txfTelaCalc.setStyle("-fx-backgraud-color: linear-gradient(#ffffff,#ffffff);\" + \"-fx-font-weight:bold;");
    }

    public void masckCamp() {
        MaskCampoCalc.mskNumero(txfTelaCalc);
    }
public void focusTela(){
    txfTelaCalc.requestFocus();
}
    public void limparTelaCalc() {
        txfTelaCalc.setText("");
        valor1 = 0;
        valor2 = 0;
        operacao = "";
        txfTelaCalc.requestFocus();
    }
}



