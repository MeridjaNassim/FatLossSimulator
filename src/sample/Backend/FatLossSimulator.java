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
    public FatLossSimulator() {
        this.initial_weightInLbs = 0;
        this.initial_bodyfat = 0;
        this.deficit_perDay = 0;
    }

    public void setDeficit_perDay(double deficit_perDay) {
        this.deficit_perDay = deficit_perDay;
    }

    public void setInitial_bodyfat(double initial_bodyfat) {
        this.initial_bodyfat = initial_bodyfat;
    }

    public void setInitial_weightInLbs(double initial_weightInLbs) {
        this.initial_weightInLbs = initial_weightInLbs;
    }

    public ArrayList<Result> simulate(int numberOfWeeks){
        double weight = initial_weightInLbs;
        System.out.println("weight = " +weight);
        double bf = initial_bodyfat;
        System.out.println("bf = " +bf);
        double deficit = deficit_perDay;
        System.out.println("deficit = " +deficit);
        ArrayList<Result> results = new ArrayList<>();
        for (int i = 0; i <numberOfWeeks ; i++) {
            Result r= estimate(weight,bf,deficit);
            results.add(r);
            weight = r.getWeight();
            System.out.println("weight = " +weight);
            bf = r.getBodyFat() ;
            System.out.println("bf = " +bf);
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
