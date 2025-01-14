package org.example.mate_matcher.handlers;

import org.example.mate_matcher.model.storage.FFHouse;
import org.example.mate_matcher.model.storage.FFUserPreference;
import org.example.mate_matcher.repository.HouseStorage;

import java.util.ArrayList;
import java.util.List;

public class HouseSearchService {

    public HouseStorage houseStorage;

    public HouseSearchService(HouseStorage houseStorage){
        this.houseStorage = houseStorage;
    }

    public List<FFHouse> searchHouse(FFUserPreference userPreference){
//        Return the list of houses that match the userPreferences
        List<FFHouse> houses = new ArrayList<>();
        return houses;
    }
}
