package sample.Backend;

public enum ActivityLevel {
    SEDENTARY("little to no exercice"),
    LIGHTLY_ACTIVE("ligh exercice/sports 1-3 days/week"),
    MODERATLY_ACTIVE("moderate exercise/sports 3-5 days/week"),
    VERY_ACTIVE("hard exercise/sports 6-7 days a week" ),
    EXTREMLY_ACTIVE("very heavy exercise/ physical job/ training twice a day");
    private String description ;

    ActivityLevel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
