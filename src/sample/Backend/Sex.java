package sample.Backend;

public enum Sex {
    MAN(66.47,6.24,12.7,6.755),
    WOMAN (655.1,4.35,4.7,4.74);
    double BMRconstant;
    double BMRweightConstant;
    double BMRheightConstant;
    double BMRageConstant;

    Sex(double BMRconstant, double BMRweightConstant, double BMRheightConstant, double BMRageConstant) {
        this.BMRconstant = BMRconstant;
        this.BMRweightConstant = BMRweightConstant;
        this.BMRheightConstant = BMRheightConstant;
        this.BMRageConstant = BMRageConstant;
    }

    public double getBMRValue(double weightLbs, double heightInches,double age){
        return this.BMRconstant+(this.BMRweightConstant* weightLbs) + (this.BMRheightConstant * heightInches) -(this.BMRageConstant*age) +5;
    }
}
