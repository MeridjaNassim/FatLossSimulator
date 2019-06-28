package sample.Backend;

public class BMR {

    private double weightInLbs;
    private double heightInInches;
    private double age  ;
    private Sex sex ;
    private double value;
    public BMR(double weight,String weightUnit ,double height,String heightUnit, double age, Sex sex) {
        this.weightInLbs = (weightUnit.equals("lbs") )? weight : weight*2.2;
        this.heightInInches = (heightUnit.equals("inches")) ? height: height*0.3937 ;
        this.age = age;
        this.sex = sex;
        this.value = sex.getBMRValue(weightInLbs,heightInInches,age);
    }
    public double get(){
        return value;
    }

    public Sex getSex() {
        return sex;
    }
}
