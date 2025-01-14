package org.example.mate_matcher.repository;

import org.example.mate_matcher.model.storage.FFHouse;

import java.util.HashMap;
import java.util.Map;

public class HouseStorage {
    public final Map<String, FFHouse> houseDatabase;

    public HouseStorage(){
        this.houseDatabase = new HashMap<>();
    }

}
