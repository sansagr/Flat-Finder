package org.example.mate_matcher.model.storage;

import lombok.Data;
import org.example.mate_matcher.model.enums.DrinkingPreference;
import org.example.mate_matcher.model.enums.FoodPreference;
import org.example.mate_matcher.model.enums.Gender;
import org.example.mate_matcher.model.enums.SmokingPreference;

import java.util.Arrays;

@Data
public class FFHousePreferences {
    private Gender gender;
    private int[] ageRange;
    private SmokingPreference smokingPreference;
    private FoodPreference foodPreference;
    private DrinkingPreference drinkingPreference;

    public FFHousePreferences (Gender gender, int[] ageRange, SmokingPreference smokingPreference, FoodPreference foodPreference, DrinkingPreference drinkingPreference){
        this.gender = gender;
        this.ageRange = ageRange;
        this.smokingPreference = smokingPreference;
        this.foodPreference = foodPreference;
        this.drinkingPreference = drinkingPreference;
    }

}
