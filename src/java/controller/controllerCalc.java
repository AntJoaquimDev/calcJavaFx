package controller;

import calcDao.CrudGenecDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelCalc.Calculadora;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class controllerCalc implements Initializable {
    @FXML
    private TableView<Calculadora> tbViewCalc;

    @FXML
    private Button btnDeletar;

    @FXML
    private Button btnSair;

    private CrudGenecDao dao = new CrudGenecDao();
    private ObservableList<Calculadora> observableList = FXCollections.observableArrayList();
    private List<Calculadora> lista;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnSair.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnSair.getScene().getWindow().hide();
                try {
                    chamarTela();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        atualizarTabelas();
        criarColunasTabView();
    }

    @FXML
    void apagarHistorico(ActionEvent event) {
        dao.excluir(tbViewCalc);
    }

    public void chamarTela() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Calc2.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle(" Calculadora -> Joaquim");
        stage.setMaximized(false);
        stage.setScene(scene);
        stage.show();

    }

    public void criarColunasTabView() {
        TableColumn<Calculadora, Double> colunaValor1 = new TableColumn<>("1º Valor ");
        TableColumn<Calculadora, String> colunaOperador = new TableColumn<>("Operador ");
        colunaOperador.setMinWidth(140);
        colunaOperador.setMaxWidth(140);
        TableColumn<Calculadora, Double> colunaValor2 = new TableColumn<>("2º Valor ");
        TableColumn<Calculadora, String> colunaIgual = new TableColumn<>(" =");
        colunaIgual.setMinWidth(40);
        colunaIgual.setMaxWidth(40);
        TableColumn<Calculadora, Double> colunaResult = new TableColumn<>("Resultado Operação ");
        tbViewCalc.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tbViewCalc.getColumns().addAll(colunaValor1, colunaOperador, colunaValor2, colunaIgual, colunaResult);
        colunaValor1.setCellValueFactory(new PropertyValueFactory("valor1"));
        colunaOperador.setCellValueFactory(new PropertyValueFactory("operacao"));
        colunaValor2.setCellValueFactory(new PropertyValueFactory("valor2"));
        colunaResult.setCellValueFactory(new PropertyValueFactory("resultado"));
    }

    public void atualizarTabelas() {
        lista = dao.consultar("Calculadora");
        for (Calculadora cal : lista) {
            observableList.add(cal);
        }
        tbViewCalc.getItems().setAll(observableList);
        tbViewCalc.getSelectionModel().selectFirst();
    }

}
