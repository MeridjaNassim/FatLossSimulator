package sample.Backend;

import java.text.DecimalFormat;

public class Result {

    private  double weight;
    private  double bodyFat;
    private  double lossFatWeight;
    private String unit ;
    public Result(double weight, double bodyFat, double lossFatWeight) {
        this.weight = weight;
        this.bodyFat = bodyFat;
        this.lossFatWeight = lossFatWeight;
        this.unit = "lbs";
    }
    public Result(double weight, double bodyFat, double lossFatWeight ,String unit) {
        this.weight = weight;
        this.bodyFat = bodyFat;
        this.lossFatWeight = lossFatWeight;
        this.unit = unit;
    }

    public double getBodyFat() {
        return bodyFat;
    }

    public double getLossFatWeight() {
        return lossFatWeight;
    }

    public double getWeight() {
        return weight;
    }

    public void setBodyFat(double bodyFat) {
        this.bodyFat = bodyFat;
    }

    public void setLossFatWeight(double lossFatWeight) {
        this.lossFatWeight = lossFatWeight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        String pattern = "###,###.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return "Weight : "+decimalFormat.format(weight)+unit+" at : "+decimalFormat.format(bodyFat*100)+"% body fat"+", lost weight : "+decimalFormat.format(lossFatWeight)+unit+" .";
    }
}
