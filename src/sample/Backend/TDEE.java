package sample.Backend;

public class TDEE {
    private BMR bmr ;
    private ActivityLevel activityLevel;
    private double tdee ;
    public TDEE(BMR bmr, ActivityLevel activityLevel) {
        set(bmr,activityLevel);
    }

    public double get(){
        return tdee;
    }
    private double calculate(){
        double bmr = this.bmr.get();
        if(this.bmr.getSex() == Sex.MAN){
            switch (activityLevel){
                case SEDENTARY: return 1.2 * bmr;
                case LIGHTLY_ACTIVE: return 1.375*bmr;
                case MODERATLY_ACTIVE: return 1.55*bmr;
                case VERY_ACTIVE: return 1.725 * bmr;
                case EXTREMLY_ACTIVE: return 1.9 * bmr;
            }
        }else  {
            switch (activityLevel){
                case SEDENTARY: return 1.1 * bmr;
                case LIGHTLY_ACTIVE: return 1.275*bmr;
                case MODERATLY_ACTIVE: return 1.35*bmr;
                case VERY_ACTIVE: return 1.525 * bmr;
                case EXTREMLY_ACTIVE: return 1.725 * bmr;
            }
        }
        return bmr*1.2;
    }

    public void set(BMR  bmr , ActivityLevel level){
        this.bmr = bmr;
        this.activityLevel = level;
        tdee = this.calculate();
    }
}
