package sample;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Backend.ObservableResult;
import sample.Backend.Result;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ResultsController implements Initializable {
    @FXML
    private TableView<ObservableResult> resultTable;
    @FXML
    private JFXButton btnReturn;
    /// Columns
    @FXML
    private TableColumn<ObservableResult,SimpleIntegerProperty> weekNumColumn = new TableColumn<>("Week");
    @FXML
    private TableColumn<ObservableResult,SimpleStringProperty> weightColumn = new TableColumn<>("Weight");
    @FXML
    private TableColumn<ObservableResult,SimpleStringProperty> bfColumn = new TableColumn<>("Body Fat %");
    @FXML
    private TableColumn<ObservableResult,SimpleStringProperty> lostBfColumn = new TableColumn<>("Lost weight");
    private ObservableList<ObservableResult> resultsObservableList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weekNumColumn.setCellValueFactory(new PropertyValueFactory<>("Week"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("Weight"));
        bfColumn.setCellValueFactory(new PropertyValueFactory<>("BodyFat"));
        lostBfColumn.setCellValueFactory(new PropertyValueFactory<>("LossFatWeight"));
        resultTable.getColumns().setAll(weekNumColumn,weightColumn,bfColumn,lostBfColumn);
        resultTable.setEditable(false);
        resultTable.setStyle(" -fx-background-color: transparent; ");
        resultsObservableList =FXCollections.observableArrayList();
        btnReturn.setOnAction(e->{
            resultsObservableList.clear();
            clearColumns();
            Main.STAGE.setScene(Main.MAIN_SCENE);
        });
    }
    public void BuildResultTable(ArrayList<Result> results,String selectedUnit){

        weightColumn.setText(weightColumn.getText()+"("+selectedUnit+")");
        lostBfColumn.setText(lostBfColumn.getText()+"("+selectedUnit+")");
        int i =1 ;
        for (Result result: results
                ) {
            resultsObservableList.add(new ObservableResult(i,result));
            i++;
        }
        resultTable.getItems().setAll(resultsObservableList);
        resultTable.sort();

    }
    private void clearColumns(){
        weightColumn.setText("Weight");
        lostBfColumn.setText("Lost Weight");
    }
}
