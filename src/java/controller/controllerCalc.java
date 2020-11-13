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
import javafx.stage.Stage;
import modelCalc.Calculadora;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;



public class controllerCalc implements Initializable {
    @FXML
    private TableView<?> tbViewCalc;

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





}
