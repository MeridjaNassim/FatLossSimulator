package sample.Backend;

import java.util.ArrayList;

public class Formatter {
    private static final String kilograms = "kg";
    private static final String pounds ="lbs";
    public static ArrayList<Result> format(String unit , ArrayList<Result> results) {
        if(unit.equals(pounds)){
            for (Result result: results
                    ) {
                if(result.getUnit().equals(pounds)) {
                    return results;
                }
                result.setWeight(result.getWeight()*2.2);
                result.setLossFatWeight(result.getLossFatWeight()*2.2);
                result.setUnit(kilograms);
            }
        }
        if(unit.equals(kilograms)) {
            for (Result result: results
                 ) {
                if(result.getUnit().equals(kilograms)) {
                    return results;
                }
                result.setWeight(result.getWeight()/2.2);
                result.setLossFatWeight(result.getLossFatWeight()/2.2);
                result.setUnit(kilograms);
            }
        }
        return results;
    }
}
