package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import sample.Backend.FatLossSimulator;
import sample.Backend.Formatter;
import sample.Backend.ObservableResult;
import sample.Backend.Result;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private JFXRadioButton kg;
    @FXML
    private AnchorPane root;


    @FXML
    private JFXRadioButton lbs;

    @FXML
    private JFXTextField weightText;

    @FXML
    private JFXTextField deficitText;

    @FXML
    private JFXTextField bfText;

    @FXML
    private JFXTextField weekText;

    @FXML
    private JFXButton btnSimulate;
    private ToggleGroup radios ;
    private FatLossSimulator simulator;
    private ArrayList<Result> results;
    // values ;
    public double weightInLbs ;
    public double bodyFat ;
    public double deficitPerDay;
    public int weekNumber ;

    private String selected_unit="kg";
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        simulator=  new FatLossSimulator();
        radios = new ToggleGroup();
        kg.setToggleGroup(radios);
        kg.setSelected(true);
        weightText.setStyle("-fx-text-inner-color: #dba62e;-fx-prompt-text-fill: #dba62e ;");
        bfText.setStyle("-fx-text-inner-color: #dba62e;-fx-prompt-text-fill: #dba62e ;");
        deficitText.setStyle("-fx-text-inner-color: #dba62e;-fx-prompt-text-fill: #dba62e ;");
       weekText.setStyle("-fx-text-inner-color: #dba62e;-fx-prompt-text-fill: #dba62e ;");
        kg.setSelectedColor(Color.ORANGE);
        lbs.setToggleGroup(radios);
       lbs.setSelectedColor(Color.ORANGE);

        btnSimulate.setOnAction(e->{
                getValues();
                startSimulation();
                Main.STAGE.setScene(Main.RESULTS_SCENE);
                Main.resultsController.BuildResultTable(results,selected_unit);

        });
    }
    private void getValues(){
        // getting weight
        if(radios.getSelectedToggle().equals(kg)){
            weightInLbs = Double.parseDouble(weightText.getText()) * 2.2;

        }else {
            weightInLbs = Double.parseDouble(weightText.getText());

        }
        // getting bf ;
        bodyFat = Double.parseDouble(bfText.getText());

        // getting deficit ;
        deficitPerDay = Double.parseDouble(deficitText.getText());

        // getting weeks ;
        weekNumber = Integer.parseInt(weekText.getText());

    }
    private void startSimulation(){
        simulator.setInitial_weightInLbs(weightInLbs);
        simulator.setInitial_bodyfat(bodyFat/100);
        simulator.setDeficit_perDay(deficitPerDay);
        results= simulator.simulate(weekNumber);
        selected_unit = (radios.getSelectedToggle().equals(kg)) ? "kg" : "lbs";
        Formatter.format(selected_unit,simulator.getLastResults());
        simulator.log();
    }

}
