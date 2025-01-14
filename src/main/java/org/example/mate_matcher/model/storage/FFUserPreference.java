package org.example.mate_matcher.model.storage;

import lombok.Data;
import org.example.mate_matcher.model.enums.DrinkingPreference;
import org.example.mate_matcher.model.enums.FoodPreference;
import org.example.mate_matcher.model.enums.Gender;
import org.example.mate_matcher.model.enums.SmokingPreference;

import java.util.List;

@Data
public class FFUserPreference {
    public List<String> locality;
    public String state;
    public DrinkingPreference drinkingPreference;
    public SmokingPreference smokingPreference;
    public FoodPreference foodPreference;

    public FFUserPreference(List<String> locality, String state, DrinkingPreference drinkingPreference, SmokingPreference smokingPreference, FoodPreference foodPreference){
        this.locality = locality;
        this.state = state;
        this.drinkingPreference = drinkingPreference;
        this.smokingPreference = smokingPreference;
        this.foodPreference = foodPreference;
    }
}
