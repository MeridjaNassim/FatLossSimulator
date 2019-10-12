package sample.Backend;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.DecimalFormat;

public class ObservableResult {

    public final SimpleIntegerProperty Week = new SimpleIntegerProperty();
    public final SimpleStringProperty Weight = new SimpleStringProperty();
    public final  SimpleStringProperty BodyFat = new SimpleStringProperty();
    public final SimpleStringProperty LossFatWeight = new SimpleStringProperty();

    public ObservableResult(int weekNum , Result result) {
        DecimalFormat format = new DecimalFormat("##.00");
        this.Week.set(weekNum);
        this.Weight.set(format.format(result.getWeight()));
        this.BodyFat.set(format.format(result.getBodyFat()*100));
        this.LossFatWeight.set(format.format(result.getLossFatWeight()));

    }

    public int getWeek() {
        return Week.get();
    }

    public String getWeight() {
        return Weight.get();
    }

    public String getLossFatWeight() {
        return LossFatWeight.get();
    }

    public String getBodyFat() {
        return BodyFat.get();
    }
}
