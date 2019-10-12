package sample;

import sample.Backend.*;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        BMR nassim = new BMR(82.3,"kg",177,"cm",20,Sex.MAN);
        System.out.println("Your BMR is : "+ nassim.get());
        TDEE tdee = new TDEE(nassim,ActivityLevel.MODERATLY_ACTIVE);
        System.out.println("your TDEE is : " + tdee.get());
        FatLossSimulator simulator = new FatLossSimulator(176.36,0.201,250);
        simulator.simulate(7);
        Formatter.format("kg",simulator.getLastResults());
        simulator.log();
    }
}
