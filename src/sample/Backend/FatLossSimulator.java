package sample.Backend;

import java.util.ArrayList;

public class FatLossSimulator {

    private double initial_weightInLbs;
    private double initial_bodyfat;
    private double deficit_perDay;
    private ArrayList<Result> lastResults;
    public FatLossSimulator(double initial_weightInLbs, double initial_bodyfat, double deficit_perDay) {
        this.initial_weightInLbs = initial_weightInLbs;
        this.initial_bodyfat = initial_bodyfat;
        this.deficit_perDay = deficit_perDay;
    }
    public ArrayList<Result> simulate(int numberOfWeeks){
        double weight = initial_weightInLbs;
        double bf = initial_bodyfat;
        double deficit = deficit_perDay;
        ArrayList<Result> results = new ArrayList<>();
        for (int i = 0; i <numberOfWeeks ; i++) {
            Result r= estimate(weight,bf,deficit);
            results.add(r);
            weight = r.getWeight();
            bf = r.getBodyFat() ;
        }
        lastResults =results;
        return results;
    }

    public ArrayList<Result> getLastResults() {
        return lastResults;
    }

    private Result estimate(double weight, double bf , double deficit) {
        double lostWeight = (weight * bf *31/500)*deficit/500;
        return new Result(weight-lostWeight,bf -(lostWeight/weight),lostWeight);
    }

    @Override
    public String toString() {
        String re = "";
        int week = 1;
        for (Result result: lastResults
             ) {
            re= re+"Week "+week+": "
                    +result.toString()+"\n";
            week++;
        }
        return re;
    }
    public void log(){
        System.out.println(this.toString());
    }
}
